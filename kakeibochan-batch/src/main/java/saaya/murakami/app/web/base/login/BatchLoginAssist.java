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
package saaya.murakami.app.web.base.login;

import javax.annotation.Resource;

import org.dbflute.optional.OptionalEntity;
import org.dbflute.optional.OptionalThing;
import org.lastaflute.core.magic.async.AsyncManager;
import org.lastaflute.core.time.TimeManager;
import org.lastaflute.db.jta.stage.TransactionStage;
import org.lastaflute.web.login.credential.UserPasswordCredential;
import org.lastaflute.web.login.option.LoginSpecifiedOption;

import saaya.murakami.app.web.RootAction;
import saaya.murakami.dbflute.cbean.MemberCB;
import saaya.murakami.dbflute.exbhv.MemberBhv;
import saaya.murakami.dbflute.exentity.Member;
import saaya.murakami.mylasta.action.BatchUserBean;
import saaya.murakami.mylasta.direction.BatchConfig;

/**
 * @author jflute
 */
public class BatchLoginAssist extends KakeibochanLoginAssist<BatchUserBean, Member> { // #change_it

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    private TimeManager timeManager;
    @Resource
    private AsyncManager asyncManager;
    @Resource
    private TransactionStage transactionStage;
    @Resource
    private BatchConfig config;
    @Resource
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                           Find User
    //                                                                           =========
    @Override
    protected void checkCredential(CredentialChecker checker) {
        checker.check(UserPasswordCredential.class, credential -> {
            return memberBhv.selectCount(cb -> arrangeLoginByCredential(cb, credential)) > 0;
        });
    }

    @Override
    protected void resolveCredential(CredentialResolver resolver) {
        resolver.resolve(UserPasswordCredential.class, credential -> {
            return memberBhv.selectEntity(cb -> arrangeLoginByCredential(cb, credential));
        });
    }

    private void arrangeLoginByCredential(MemberCB cb, UserPasswordCredential credential) {
        //TODO       cb.query().arrangeLogin(credential.getUser(), encryptPassword(credential.getPassword()));
    }

    @Override
    protected OptionalEntity<Member> doFindLoginUser(Integer userId) {
        return OptionalEntity.empty();
        //TODO
        //        return memberBhv.selectEntity(cb -> {
        //            cb.query().arrangeLoginByIdentity(userId);
        //        });
    }

    // ===================================================================================
    //                                                                       Login Process
    //                                                                       =============
    @Override
    protected BatchUserBean createUserBean(Member userEntity) {
        return new BatchUserBean(userEntity);
    }

    @Override
    protected OptionalThing<String> getCookieRememberMeKey() {
        return OptionalThing.of(config.getCookieRememberMeBatchKey());
    }

    @Override
    protected void saveLoginHistory(Member member, BatchUserBean userBean, LoginSpecifiedOption option) {
        asyncManager.async(() -> {
            transactionStage.requiresNew(tx -> {
                insertLogin(member);
            });
        });
    }

    protected void insertLogin(Member member) {
        //TODO
        //        MemberLogin login = new MemberLogin();
        //        login.setMemberId(member.getMemberId());
        //        login.setLoginMemberStatusCodeAsMemberStatus(member.getMemberStatusCodeAsMemberStatus());
        //        login.setLoginDatetime(timeManager.currentDateTime());
        //        login.setMobileLoginFlg_False(); // mobile unsupported for now
        //        memberLoginBhv.insert(login);
    }

    // ===================================================================================
    //                                                                      Login Resource
    //                                                                      ==============
    @Override
    protected Class<BatchUserBean> getUserBeanType() {
        return BatchUserBean.class;
    }

    @Override
    protected Class<?> getLoginActionType() {
        return RootAction.class;
    }
}
