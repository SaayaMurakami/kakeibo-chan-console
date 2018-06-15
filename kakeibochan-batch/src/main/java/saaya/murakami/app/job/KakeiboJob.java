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

import javax.annotation.Resource;

import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.optional.OptionalEntity;
import org.lastaflute.db.jta.stage.TransactionStage;
import org.lastaflute.job.LaJob;
import org.lastaflute.job.LaJobRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    // ===================================================================================
    //                                                                             Job Run
    //                                                                             =======
    @Override
    public void run(LaJobRuntime runtime) { // exception job!
        stage.required(tx -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //ユーザー登録・ログイン
            long userId = loginProcess(reader);

            //家計
            loopout: do {
                System.out.println("やりたいことを選んでね（数字で選択）");
                System.out.println("1.家計簿をつける  2.家計簿を見る　3.カテゴリを編集する　4.アカウントを編集する　5.終了");
                int num = inputIntNumber("", reader);

                switch (num) {
                case 1: //家計簿をつける
                    registerStatement(reader, userId);
                    break;

                case 2://家計簿を見る
                    showStatement(reader, userId);
                    break;

                case 3:
                    registerCategory(reader, userId);
                    break;

                case 4:
                    registerAccount(reader, userId);
                    break;

                case 5:
                    System.out.println("--- Bye ---");
                    break loopout;

                default:
                    break;
                }
            } while (true);
        });
    }

    private void registerCategory(BufferedReader reader, Long userId) {
        boolean continueAnswer = true;
        do {
            String answer;
            System.out.println("現在のカテゴリー");
            ListResultBean<Category> categoryList = categoryBhv.selectList(cb -> {
                cb.query().setUserId_Equal(userId);
            });
            if (categoryList.isEmpty()) {
                System.out.println("カテゴリーは登録されていません");
            } else {
                for (int i = 0; i < categoryList.getAllRecordCount(); i++) {
                    Category category = categoryList.get(i);
                    System.out.print((i + 1) + ":" + category.getCategory() + " ");
                }
                System.out.println("");
            }
            System.out.println("何をしますか？");
            int num;
            num = inputIntNumber("1.追加　2.削除　3.もどる", reader);
            switch (num) {
            case 1:
                do {
                    Category category = new Category();
                    String categoryName = inputString("追加したいカテゴリ名を入力してください", reader);
                    category.setUserId(userId);
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
        ListResultBean<Statement> statementList = statementBhv.selectList(cb -> {
            cb.query().setUserId_Equal(userId);
        });
        if (statementList.isEmpty()) {
            System.out.println("閲覧するデータはありません");
        }
        {
            statementList.forEach(statement -> {
                String typeName = null;
                if (statement.getStatementType().equals("INCOME")) {
                    typeName = "収入";
                } else if (statement.getStatementType().equals("SPEND")) {
                    typeName = "支出";
                }
                final String TYPE_NAME = typeName;

                OptionalEntity<Category> category = categoryBhv.selectEntity(cb -> {
                    cb.query().setCategoryId_Equal(statement.getCategoryId());
                });

                OptionalEntity<Account> account = accountBhv.selectEntity(cb -> {
                    cb.query().setAccountId_Equal(statement.getAccountId());
                });

                System.out.println(TYPE_NAME + " " + statement.getDate() + " " + category.get().getCategory() + " "
                        + account.get().getAccountName() + " " + statement.getAmount() + "円 " + statement.getMemo());
            });
            inputString("閲覧をやめるときはEnterをおす", reader);
        }
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
            String statementType = "";
            String typeName = "";
            if (typeNum == 1) {
                statementType = "SPEND";
                typeName = "支出";
            } else if (typeNum == 2) {
                statementType = "INCOME";
                typeName = "収入";

            }
            statement.setStatementType(statementType);

            //日付を登録
            System.out.println("日付を登録します");
            int year = inputIntNumber("年度を入力してください（ex.1998）", reader);
            int month = inputIntNumber("月を入力してください（ex.9）", reader);
            int date = inputIntNumber("日付を入してください（ex.16）", reader);
            LocalDate localDate = LocalDate.of(year, month, date);
            statement.setDate(localDate);

            //カテゴリを登録
            System.out.println("カテゴリを選んでください（数字で選択）");
            int countCategory = categoryBhv.selectCount(cb -> {
                cb.query().setUserId_Equal(userId);
            });
            ListResultBean<Category> categoryList = categoryBhv.selectList(cb -> {
                cb.query().setUserId_Equal(userId);
                cb.query().addOrderBy_CategoryId_Asc();
            });

            for (int i = 0; i < countCategory; i++) {
                Category category = categoryList.get(i);
                System.out.print((i + 1) + ":" + category.getCategory() + " ");
            }
            System.out.println("");
            int catergoryNum = inputIntNumber("", reader);
            while (catergoryNum < 1 || catergoryNum > countCategory) {
                System.out.println("1~" + countCategory + "の数字で入力してください");
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
            System.out.println(typeName + " " + localDate + " " + categoryName + " " + accountName + " " + amount + "円 " + memo);
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

    private long loginProcess(BufferedReader reader) {
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
                    loop: do {
                        mailAddress = inputString("メールアドレスを入力してください", reader);
                        final String MAIL_ADDRESS = mailAddress;
                        OptionalEntity<Member> selectMember = memberBhv.selectEntity(cb -> {
                            cb.query().setMailAddress_Equal(MAIL_ADDRESS);
                        });
                        boolean Existence = selectMember.isPresent();
                        if (Existence) {
                            System.out.println("入力されたメールアドレスはすでに使われています");
                        } else {
                            break loop;
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
                Category category = new Category();
                category.setUserId(userId);
                category.setCategory("食費");
                categoryBhv.insert(category);

                Account account1 = new Account();
                account1.setUserId(userId);
                account1.setAccountName("財布");
                accountBhv.insert(account1);
                Account account2 = new Account();
                account2.setUserId(userId);
                account2.setAccountName("銀行");
                accountBhv.insert(account2);

                System.out.println("登録完了");
                break;

            case 2:
                do {
                    final String loginAdd = inputString("メールアドレスを入力してください", reader);
                    final String loginPass = inputString("パスワードを入力してください", reader);

                    OptionalEntity<Member> loginMenber = memberBhv.selectEntity(cb -> {
                        cb.query().setMailAddress_Equal(loginAdd);
                        cb.query().setPassword_Equal(loginPass);
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

    private long inputLongNumber(String message, BufferedReader reader) {
        if (!message.isEmpty()) {
            System.out.println(message);
        }
        do {
            try {
                return Long.parseLong(reader.readLine());
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

}
