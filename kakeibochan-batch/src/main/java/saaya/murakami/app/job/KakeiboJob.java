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
            System.out.println("やりたいことを選んでね（数字で選択）");
            System.out.println("1.家計簿をつける  2.家計簿を見る");
            int num = inputIntNumber("", reader);

            switch (num) {
            case 1: //家計簿をつける
                registerStatement(reader, userId);
                break;

            case 2:

            default:
                break;
            }
        });
    }

    private void registerStatement(BufferedReader reader, Long userId) {
        do {
            Statement statement = new Statement();

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
                typeName = "支出";

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
                //TODO 会員ID
                cb.query().setUserId_Equal(userId);
            });
            ListResultBean<Category> categoryList = categoryBhv.selectList(cb -> {
                //TODO 他人のカテゴリー見えちゃまずね　会員ID！
                cb.query().setUserId_Equal(userId);
                cb.query().addOrderBy_CategoryId_Asc();
            });
            categoryList.forEach(category -> {
                System.out.print(category.getCategoryId() + ":" + category.getCategory() + " ");
            });
            Long catergoryNum = inputLongNumber("", reader);
            while (catergoryNum < 1 || catergoryNum > countCategory) {
                //TODO 二人目はIDが違いそうだね
                System.out.println("1~" + countCategory + "の数字で入力してください");
                catergoryNum = inputLongNumber("", reader);
            }
            OptionalEntity<Category> selectMember1 = categoryBhv.selectEntity(cb -> {
                cb.query().setUserId_Equal(userId);
            });
            String categoryName = selectMember1.get().getCategory();
            statement.setCategoryId(catergoryNum);

            //アカウントを登録
            System.out.println("アカウントを選んでください（数字で選択）");
            int countAccount = accountBhv.selectCount(cb -> {
                //TODO　会員IDとヒモ付
                cb.query().setUserId_Equal(userId);
            });
            ListResultBean<Account> AccounttList = accountBhv.selectList(cb -> {
                //TODO 会員IDとヒモ付
                cb.query().setUserId_Equal(userId);
                cb.query().addOrderBy_AccountId_Asc();
            });
            AccounttList.forEach(account -> {
                System.out.print(account.getAccountId() + ":" + account.getAccountName() + " ");
            });
            Long accountNum = inputLongNumber("", reader);
            while (accountNum < 1 || accountNum > countAccount) {
                System.out.println("1~" + countAccount + "の数字で入力してください");
                accountNum = inputLongNumber("", reader);
            }
            OptionalEntity<Account> selectMember2 = accountBhv.selectEntity(cb -> {
                cb.query().setUserId_Equal(userId);
            });
            String accountName = selectMember2.get().getAccountName();
            statement.setAccountId(accountNum);

            //金額を登録
            int amount = inputIntNumber("金額を入力してください（ex.500）", reader);
            statement.setAmount(amount);

            //メモを登録
            String memo = inputString("メモを入力してください", reader);
            statement.setMemo(memo);

            //登録内容の確認
            System.out.println("入力内容を確認します");
            System.out.println(typeName + " " + localDate + " " + categoryName + " " + accountName + " " + amount + "円 " + memo); //TODO カテゴリとアカウントは名称で表示したい
            String answer = getAnswer("登録しますか", reader);
            if (answer.equals("はい")) {
                statementBhv.insert(statement); //statementをkakeibodbに登録
                System.out.println("登録完了");
                answer = getAnswer("続けて登録しますか？", reader);
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
            System.out.println("1.会員登録　2.ログイン");
            int selectNum = inputIntNumber("", reader);
            switch (selectNum) {
            case 1: //会員登録
                String loginAnswer = null;
                String mailAddress;
                String userName;
                String password;
                do {
                    mailAddress = inputString("メールアドレスを入力してください", reader);
                    userName = inputString("ユーザー名を入力してください", reader);
                    password = inputString("パスワードを入力してください", reader);
                    System.out.println("入力情報確認");
                    System.out.println("メールアドレス：" + mailAddress);
                    System.out.print("ユーザー名：" + userName);
                    System.out.println("パスワード：" + password);
                    loginAnswer = getAnswer("入力間違いはありませんか？", reader);
                    if (loginAnswer.equals("いいえ")) {
                        System.out.println("やり直します");
                    }
                } while (loginAnswer.equals("いいえ"));

                Member member = new Member();
                member.setMailAddress(mailAddress);
                member.setUserName(userName);
                member.setPassword(password);
                memberBhv.insert(member);
                System.out.println("登録完了");

                memberBhv.selectList(cb -> {
                    cb.query().addOrderBy_UserId_Asc();
                }).forEach(tmpMember -> {
                    System.out.println(tmpMember.toString());
                });

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
