/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package saaya.murakami.app.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;

import javax.annotation.Resource;

import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.optional.OptionalEntity;
import org.lastaflute.db.jta.stage.TransactionStage;
import org.lastaflute.job.LaJob;
import org.lastaflute.job.LaJobRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import saaya.murakami.dbflute.allcommon.CDef.StatementType;
import saaya.murakami.dbflute.exbhv.AccountBhv;
import saaya.murakami.dbflute.exbhv.CategoryBhv;
import saaya.murakami.dbflute.exbhv.MemberBhv;
import saaya.murakami.dbflute.exbhv.StatementBhv;
import saaya.murakami.dbflute.exentity.Account;
import saaya.murakami.dbflute.exentity.Category;
import saaya.murakami.dbflute.exentity.Member;
import saaya.murakami.dbflute.exentity.Statement;

public class KakeiboJob implements LaJob {

    private static final Logger logger = LoggerFactory.getLogger(KakeiboJob.class);

    @Resource
    private TransactionStage stage;
    @Resource
    private MemberBhv memberBhv;
    @Resource
    private StatementBhv statementBhv;
    @Resource
    private CategoryBhv categoryBhv;
    @Resource
    private AccountBhv accountBhv;

    private final int ALL_PERIOD = 1; //全期間
    private final int YEARLY_PERIOD = 2; //年間
    private final int MONTHLY_PERIOD = 3; //月間

    // ===================================================================================
    //                                                                             Job Run
    //                                                                             =======
    @Override
    public void run(LaJobRuntime runtime) { // exception job!
        stage.required(tx -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //ユーザー登録・ログイン
            long userId = registerAndLoginProcess(reader);

            //家計簿
            OptionalEntity<Member> loginMember = memberBhv.selectEntity(cb -> {
                cb.query().setUserId_Equal(userId);
            });
            System.out.println("ようこそ" + loginMember.get().getUserName() + "さん");
            loopout: do {
                System.out.println("やりたいことを選んでね（数字で選択）");
                System.out.println("1.家計簿をつける  2.家計簿を見る　3.家計簿を編集する　4.終了");
                int num = inputIntNumber("", reader);

                switch (num) {
                case 1: //家計簿をつける
                    registerStatement(reader, userId);
                    break;

                case 2://家計簿を見る
                    showStatement(reader, userId);
                    break;

                case 3:
                    System.out.println("何をしますか？");
                    int editNum = inputIntNumber("1.明細の削除　2.カテゴリの追加　3.アカウントの追加　4.もどる", reader);
                    switch (editNum) {
                    case 1:
                        deleteStatement(reader, userId);
                        break;

                    case 2:
                        registerCategory(reader, userId);
                        break;

                    case 3:
                        registerAccount(reader, userId);
                        break;

                    case 4:
                        break;

                    default:
                        break;
                    }
                    break;

                case 4:
                    System.out.println("--- Bye ---");
                    break loopout;

                default:
                    break;
                }
            } while (true);
        });
    }

    private void deleteStatement(BufferedReader reader, Long userId) {
        boolean continueAnswer = true;
        do {
            int year = inputIntNumber("削除したい明細の年度を入力してください", reader);
            int month = inputIntNumber("削除したい明細の月を入力してください", reader);
            LocalDate localDate = LocalDate.of(year, month, 1);
            ListResultBean<Statement> statementList = statementBhv.selectList(cb -> {
                cb.query().setUserId_Equal(userId);
                cb.query().setDate_FromTo(localDate, localDate, op -> op.compareAsMonth());
            });
            statementList.forEach(statement -> {
                OptionalEntity<Category> category = categoryBhv.selectEntity(cb -> {
                    cb.query().setCategoryId_Equal(statement.getCategoryId());
                });

                OptionalEntity<Account> account = accountBhv.selectEntity(cb -> {
                    cb.query().setAccountId_Equal(statement.getAccountId());
                });
                System.out.println("ID  明細タイプ  日付  カテゴリ名  アカウント名  金額  メモ");

                System.out.println(statement.getStatementId() + " " + statement.getStatementTypeAlias() + " " + statement.getDate() + " "
                        + category.get().getCategory() + " " + account.get().getAccountName() + " " + statement.getAmount() + "円 "
                        + statement.getMemo());
            });

            Long statementId = Long.parseLong(inputString("削除したい明細の明細IDを入力してください", reader));
            OptionalEntity<Statement> optStatement = statementBhv.selectEntity(cb -> {
                cb.query().setStatementId_Equal(statementId);
            });
            if (optStatement.isPresent()) {
                Statement statement = optStatement.get();
                System.out.println("この明細を削除しますか？（はい/いいえ）");
                OptionalEntity<Category> optCategory = categoryBhv.selectEntity(cb -> {
                    cb.query().setCategoryId_Equal(statement.getCategoryId());
                });
                OptionalEntity<Account> account = accountBhv.selectEntity(cb -> {
                    cb.query().setAccountId_Equal(statement.getAccountId());
                });

                System.out.println(statement.getStatementId() + " " + statement.getStatementTypeAlias() + " " + statement.getDate() + " "
                        + optCategory.get().getCategory() + " " + account.get().getAccountName() + " " + statement.getAmount() + "円 "
                        + statement.getMemo());
                String answer = getAnswer("", reader);
                if (answer.equals("はい")) {
                    Statement updateStatement = new Statement();
                    updateStatement.setStatementId(statementId);
                    statement.setDelFlag(1);
                    statementBhv.updateNonstrict(statement);
                    System.out.println("削除しました");
                    continueAnswer = false;
                } else if (answer.equals("いいえ")) {
                    System.out.println("やりなおします");
                }
            } else {
                System.out.println("入力されたIDの明細は存在しません、やりなおしてください");
            }
        } while (continueAnswer);

    }

    private void registerCategory(BufferedReader reader, Long userId) {
        boolean continueAnswer = true;
        do {
            String answer;
            System.out.println("現在のカテゴリー");
            ListResultBean<Category> spendCategoryList = categoryBhv.selectList(cb -> {
                cb.query().setUserId_Equal(userId);
                cb.query().setCategoryType_Equal("SPEND");
            });
            ListResultBean<Category> incomeCategoryList = categoryBhv.selectList(cb -> {
                cb.query().setUserId_Equal(userId);
                cb.query().setCategoryType_Equal("INCOME");
            });
            if (!spendCategoryList.isEmpty() || !incomeCategoryList.isEmpty()) {
                System.out.print("支出　");
                for (int i = 0; i < spendCategoryList.getAllRecordCount(); i++) {
                    Category spendCategory = spendCategoryList.get(i);
                    System.out.print((i + 1) + ":" + spendCategory.getCategory() + " ");
                }
                System.out.print("    ");
                System.out.print("収入　");
                for (int i = 0; i < incomeCategoryList.getAllRecordCount(); i++) {
                    Category incomeCategory = incomeCategoryList.get(i);
                    System.out.print((i + 1) + ":" + incomeCategory.getCategory() + " ");
                }
                System.out.println("");
            } else {
                System.out.println("カテゴリーは登録されていません");
            }
            System.out.println("何をしますか？");
            int num;
            num = inputIntNumber("1.追加　2.削除　3.もどる", reader);
            switch (num) {
            case 1:
                do {
                    Category category = new Category();
                    System.out.println("どちらのカテゴリを追加しますか？");
                    int typeNum = inputIntNumber("1.支出　2.収入", reader);
                    String categoryName = inputString("追加したいカテゴリ名を入力してください", reader);
                    category.setUserId(userId);
                    if (typeNum == 1) {
                        category.setCategoryType("SPEND");
                    } else if (typeNum == 2) {
                        category.setCategoryType("INCOME");
                    }
                    category.setCategory(categoryName);
                    answer = getAnswer("「" + categoryName + "」" + "を追加しますか？（はい/いいえ）", reader);
                    if (answer.equals("はい")) {
                        categoryBhv.insert(category);
                        System.out.println("追加しました");
                        break;
                    } else if (answer.equals("いいえ")) {
                        System.out.println("やり直します");
                    }
                } while (answer.equals("いいえ"));
                break;

            case 2:
                System.out.println("ごめんなさい、まだできません！(;_;)");
                break;

            case 3:
                continueAnswer = false;
                break;

            default:
                break;
            }
        } while (continueAnswer);
    }

    private void registerAccount(BufferedReader reader, Long userId) {
        boolean continueAnswer = true;
        do {
            String answer;
            System.out.println("現在のアカウント");
            ListResultBean<Account> accountList = accountBhv.selectList(cb -> {
                cb.query().setUserId_Equal(userId);
            });
            if (accountList.isEmpty()) {
                System.out.println("アカウントは登録されていません");
            } else {
                for (int i = 0; i < accountList.getAllRecordCount(); i++) {
                    Account account = accountList.get(i);
                    System.out.print((i + 1) + ":" + account.getAccountName() + " ");
                }
                System.out.println("");
            }
            System.out.println("何をしますか？");
            int num;
            num = inputIntNumber("1.追加　2.削除　3.もどる", reader);
            switch (num) {
            case 1:
                do {
                    Account account = new Account();
                    String accountName = inputString("追加したいアカウント名を入力してください", reader);
                    account.setUserId(userId);
                    account.setAccountName(accountName);
                    answer = getAnswer("「" + accountName + "」" + "を追加しますか？（はい/いいえ）", reader);
                    if (answer.equals("はい")) {
                        accountBhv.insert(account);
                        System.out.println("追加しました");
                        break;
                    } else if (answer.equals("いいえ")) {
                        System.out.println("やり直します");
                    }
                } while (answer.equals("いいえ"));
                break;
            case 2:
                System.out.println("ごめんなさい、まだできません！(;_;)");
                break;

            case 3:
                continueAnswer = false;
                break;

            default:
                break;
            }
        } while (continueAnswer);

    }

    private void showStatement(BufferedReader reader, Long userId) {
        boolean continueAnswer = true;
        do {
            System.out.println("何をしますか？");
            int num = inputIntNumber("1.明細　2.カテゴリー分析　3.アカウント分析　4.もどる", reader);
            switch (num) {
            case 1:
                int periodNum = inputPeriod(reader);
                final LocalDate periodDate = prepareDateForPeriod(reader, periodNum);

                ListResultBean<Statement> statementList = statementBhv.selectList(cb -> {
                    cb.query().setUserId_Equal(userId);
                    cb.query().setDelFlag_Equal(0);
                    cb.query().arrangeSetPeriodDate(periodNum, periodDate);
                    cb.query().addOrderBy_Date_Asc();
                });

                if (statementList.isEmpty()) {
                    System.out.println("閲覧するデータはありません");
                } {
                statementList.forEach(statement -> {
                    OptionalEntity<Category> category = categoryBhv.selectEntity(cb -> {
                        cb.query().setCategoryId_Equal(statement.getCategoryId());
                    });

                    OptionalEntity<Account> account = accountBhv.selectEntity(cb -> {
                        cb.query().setAccountId_Equal(statement.getAccountId());
                    });

                    System.out.println(statement.getStatementTypeAlias() + " " + statement.getDate() + " " + category.get().getCategory()
                            + " " + account.get().getAccountName() + " " + statement.getAmount() + "円 " + statement.getMemo());
                });
                inputString("閲覧をやめるときはEnterをおす", reader);
            }
                break;

            case 2:
                int periodNum2 = inputPeriod(reader);
                final LocalDate periodDate2 = prepareDateForPeriod(reader, periodNum2);

                ListResultBean<Category> categoryList = categoryBhv.selectList(cb -> {
                    cb.query().setUserId_Equal(userId);
                });

                categoryList.forEach(category -> {
                    ListResultBean<Statement> categoryStatementList = statementBhv.selectList(cb -> {
                        cb.query().setUserId_Equal(userId);
                        cb.query().setCategoryId_Equal(category.getCategoryId());
                        cb.query().arrangeSetPeriodDate(periodNum2, periodDate2);
                    });
                    int categoryAmount = 0;
                    for (Statement statement : categoryStatementList) {
                        categoryAmount += statement.getAmount();
                    }
                    System.out.println(category.getCategory() + ":" + categoryAmount + "円");
                });
                inputString("閲覧をやめるときはEnterをおす", reader);

                break;

            case 3:
                int periodNum3 = inputPeriod(reader);
                final LocalDate periodDate3 = prepareDateForPeriod(reader, periodNum3);

                ListResultBean<Account> accountList = accountBhv.selectList(cb -> {
                    cb.query().setUserId_Equal(userId);
                });

                accountList.forEach(account -> {
                    ListResultBean<Statement> accountStatementList = statementBhv.selectList(cb -> {
                        cb.query().setUserId_Equal(userId);
                        cb.query().setAccountId_Equal(account.getAccountId());
                        cb.query().arrangeSetPeriodDate(periodNum3, periodDate3);
                    });
                    int accountAmount = 0;
                    for (Statement statement : accountStatementList) {
                        if (statement.getStatementTypeAsStatementType() == StatementType.Income) {
                            accountAmount += statement.getAmount();
                        } else if (statement.getStatementTypeAsStatementType() == StatementType.Spend) {
                            accountAmount -= statement.getAmount();
                        }
                    }
                    System.out.println(account.getAccountName() + ":" + accountAmount + "円");
                });

                break;

            case 4:
                continueAnswer = false;

            default:
                break;
            }
        } while (continueAnswer);

    }

    private void registerStatement(BufferedReader reader, Long userId) {
        do {
            Statement statement = new Statement();
            statement.setUserId(userId);

            //支出or収入を登録
            int typeNum = inputIntNumber("1.支出　2.収入（数字で選択）", reader);
            while (!(typeNum == 1 || typeNum == 2)) {
                System.out.println("1か2を入力してください");
                typeNum = inputIntNumber("1.支出　2.収入（数字で選択）", reader);
            }
            final int TYPE_NUM = typeNum;
            if (TYPE_NUM == 1) {
                statement.setStatementType_Spend();
            } else if (TYPE_NUM == 2) {
                statement.setStatementType_Income();
            }

            //日付を登録
            System.out.println("日付を登録します");
            int year = inputIntNumber("年度を入力してください（ex.1998）", reader);
            int month = inputIntNumber("月を入力してください（ex.9）", reader);
            int date = inputIntNumber("日付を入力してください（ex.16）", reader);
            LocalDate localDate = LocalDate.of(year, month, date);
            statement.setDate(localDate);

            //カテゴリを登録
            System.out.println("カテゴリを選んでください（数字で選択）");
            ListResultBean<Category> categoryList = categoryBhv.selectList(cb -> {
                cb.query().setUserId_Equal(userId);
                if (TYPE_NUM == 1) {
                    cb.query().setCategoryType_Equal("SPEND");
                } else if (TYPE_NUM == 2) {
                    cb.query().setCategoryType_Equal("INCOME");
                }
                cb.query().addOrderBy_CategoryId_Asc();
            });

            for (int i = 0; i < categoryList.size(); i++) {
                Category category = categoryList.get(i);
                System.out.print((i + 1) + ":" + category.getCategory() + " ");
            }
            System.out.println("");
            int catergoryNum = inputIntNumber("", reader);
            while (catergoryNum < 1 || catergoryNum > categoryList.size()) {
                System.out.println("1~" + categoryList.size() + "の数字で入力してください");
                catergoryNum = inputIntNumber("", reader);
            }
            Category category = categoryList.get(catergoryNum - 1); //選択されたカテゴリーを取得
            String categoryName = category.getCategory();
            Long categoryId = category.getCategoryId();
            statement.setCategoryId(categoryId);

            //アカウントを登録
            System.out.println("アカウントを選んでください（数字で選択）");
            int countAccount = accountBhv.selectCount(cb -> {
                cb.query().setUserId_Equal(userId);
            });
            ListResultBean<Account> accountList = accountBhv.selectList(cb -> { //ログインユーザーに該当するアカウントをリストに格納
                cb.query().setUserId_Equal(userId);
                cb.query().addOrderBy_AccountId_Asc();
            });
            for (int i = 0; i < countAccount; i++) {
                Account account = accountList.get(i);
                System.out.print((i + 1) + ":" + account.getAccountName() + " ");
            }
            System.out.println("");
            int accountNum = inputIntNumber("", reader);
            while (accountNum < 1 || accountNum > countAccount) {
                System.out.println("1~" + countAccount + "の数字で入力してください");
                accountNum = inputIntNumber("", reader);
            }
            Account account = accountList.get(accountNum - 1); //選択されたカテゴリーを取得
            String accountName = account.getAccountName();
            Long accountId = account.getAccountId();
            statement.setAccountId(accountId);

            //金額を登録
            int amount = inputIntNumber("金額を入力してください（ex.500）", reader);
            statement.setAmount(amount);

            //メモを登録
            String memo = inputString("メモを入力してください", reader);
            statement.setMemo(memo);

            //登録内容の確認
            System.out.println("入力内容を確認します");
            System.out.println(statement.getStatementTypeAlias() + " " + localDate + " " + categoryName + " " + accountName + " " + amount
                    + "円 " + memo);
            String answer = getAnswer("登録しますか（はい/いいえ）", reader);
            if (answer.equals("はい")) {
                statementBhv.insert(statement); //statementをkakeibodbに登録
                System.out.println("登録完了");
                answer = getAnswer("続けて登録しますか？（はい/いいえ）", reader);
                if (answer.equals("いいえ")) {
                    break;
                }
            } else if (answer.equals("いいえ")) {
                System.out.println("やり直します");
            }
        } while (true);
    }

    /**
     * 会員登録処理と、ログイン処理を実行する
     * @param reader
     * @return ログインしたユーザーのID
     */
    private long registerAndLoginProcess(BufferedReader reader) {
        do {
            System.out.println("家計簿ちゃん");
            System.out.println("1.会員登録　2.ログイン 3.終了");
            int selectNum = inputIntNumber("", reader);
            switch (selectNum) {
            case 1: //会員登録
                String loginAnswer = null;
                String mailAddress;
                String userName;
                String password;
                do {
                    do {
                        mailAddress = inputString("メールアドレスを入力してください", reader);
                        final String MAIL_ADDRESS = mailAddress;
                        OptionalEntity<Member> memberOpt = memberBhv.selectEntity(cb -> {
                            cb.query().setMailAddress_Equal(MAIL_ADDRESS);
                        });

                        boolean existance = memberOpt.isPresent();
                        if (existance) {
                            System.out.println("入力されたメールアドレスはすでに使われています");
                        } else {
                            break;
                        }
                    } while (true);

                    userName = inputString("ユーザー名を入力してください", reader);
                    password = inputString("パスワードを入力してください", reader);
                    System.out.println("入力情報確認");
                    System.out.println("メールアドレス：" + mailAddress);
                    System.out.println("ユーザー名：" + userName);
                    System.out.println("パスワード：" + password);
                    loginAnswer = getAnswer("入力間違いはありませんか？（はい/いいえ）", reader);
                    if (loginAnswer.equals("いいえ")) {
                        System.out.println("やり直します");
                    }
                } while (loginAnswer.equals("いいえ"));
                Member member = new Member();
                member.setMailAddress(mailAddress);
                member.setUserName(userName);
                member.setPassword(password);
                memberBhv.insert(member);

                Long userId = member.getUserId();
                Category foodExpense = new Category();
                foodExpense.setUserId(userId);
                foodExpense.setCategoryType("SPEND");
                foodExpense.setCategory("食費");
                categoryBhv.insert(foodExpense);

                Category salary = new Category();
                salary.setUserId(userId);
                salary.setCategoryType("INCOME");
                salary.setCategory("給料");
                categoryBhv.insert(salary);

                Account wallet = new Account();
                wallet.setUserId(userId);
                wallet.setAccountName("財布");
                accountBhv.insert(wallet);

                Account bank = new Account();
                bank.setUserId(userId);
                bank.setAccountName("銀行");
                accountBhv.insert(bank);

                System.out.println("登録完了");
                break;

            case 2:
                do {
                    final String loginMailAddress = inputString("メールアドレスを入力してください", reader);//TODO 何も入力されなかったときどうするか
                    final String loginPassword = inputString("パスワードを入力してください", reader);

                    OptionalEntity<Member> loginMenber = memberBhv.selectEntity(cb -> {
                        cb.query().setMailAddress_Equal(loginMailAddress);
                        cb.query().setPassword_Equal(loginPassword);
                    });
                    if (loginMenber.isPresent()) {
                        return loginMenber.get().getUserId();
                    } else {
                        System.out.println("入力し直してください");
                    }
                } while (true);

            case 3:
                System.out.println("--- bye ---");
                System.exit(0);

            default:
                break;
            }
        } while (true);
    }

    private int inputIntNumber(String message, BufferedReader reader) {
        if (!message.isEmpty()) {
            System.out.println(message);
        }
        do {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください");
            } catch (IOException e) {
                throw new RuntimeException("エラー", e);
            }
        } while (true);
    }

    private String inputString(String message, BufferedReader reader) {
        if (!message.isEmpty()) {
            System.out.println(message);
        }
        do {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("エラー", e);
            }
        } while (true);
    }

    private String getAnswer(String message, BufferedReader reader) {
        if (!message.isEmpty()) {
            System.out.println(message);
        }
        do {
            try {
                String str = reader.readLine();
                if (str.equals("はい") || str.equals("いいえ")) {
                    return str;
                } else {
                    System.out.println("「はい」か「いいえ」で答えてください");
                }
            } catch (IOException e) {
                throw new RuntimeException("エラー", e);
            }
        } while (true);
    }

    private int inputPeriod(BufferedReader reader) {
        System.out.println("期間を選択");
        do {
            int periodNum = inputIntNumber("1.全期間　2.年間　3.月間", reader);
            if (Arrays.asList(ALL_PERIOD, YEARLY_PERIOD, MONTHLY_PERIOD).contains(periodNum)) {
                return periodNum;
            }
            System.out.println("1~3で選択してください");
        } while (true);
    }

    private LocalDate prepareDateForPeriod(BufferedReader reader, int periodNum) {
        LocalDate inputDate = null;
        switch (periodNum) {
        case ALL_PERIOD:
            break;

        case YEARLY_PERIOD:
            int year = inputIntNumber("表示したい年度を入力してください（ex.2018）", reader);
            inputDate = LocalDate.of(year, 1, 1);
            break;

        case MONTHLY_PERIOD:
            int month = inputIntNumber("表示したい月を入力してください（ex.6）", reader);
            inputDate = LocalDate.of(2018, month, 1);
            break;

        default:
            break;
        }

        return inputDate;
    }

}
