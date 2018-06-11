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
package saaya.murakami.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import saaya.murakami.dbflute.exbhv.*;
import saaya.murakami.dbflute.exentity.*;
import saaya.murakami.dbflute.cbean.*;

/**
 * The referrer loader of (会員)MEMBER as TABLE. <br>
 * <pre>
 * [primary key]
 *     USER_ID
 *
 * [column]
 *     USER_ID, MAIL_ADDRESS, USER_NAME, PASSWORD, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     USER_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     ACCOUNT, CATEGORY
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     accountList, categoryList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMember {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Member> _selectedList;
    protected BehaviorSelector _selector;
    protected MemberBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMember ready(List<Member> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MemberBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MemberBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Account> _referrerAccount;

    /**
     * Load referrer of accountList by the set-upper of referrer. <br>
     * (アカウント)ACCOUNT by USER_ID, named 'accountList'.
     * <pre>
     * <span style="color: #0000C0">memberBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">memberList</span>, <span style="color: #553000">memberLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">memberLoader</span>.<span style="color: #CC4747">loadAccount</span>(<span style="color: #553000">accountCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">accountCB</span>.setupSelect...
     *         <span style="color: #553000">accountCB</span>.query().set...
     *         <span style="color: #553000">accountCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">accountLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    accountLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Member member : <span style="color: #553000">memberList</span>) {
     *     ... = member.<span style="color: #CC4747">getAccountList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setUserId_InScope(pkList);
     * cb.query().addOrderBy_UserId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfAccount> loadAccount(ReferrerConditionSetupper<AccountCB> refCBLambda) {
        myBhv().loadAccount(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerAccount = refLs);
        return hd -> hd.handle(new LoaderOfAccount().ready(_referrerAccount, _selector));
    }

    protected List<Category> _referrerCategory;

    /**
     * Load referrer of categoryList by the set-upper of referrer. <br>
     * (カテゴリー)CATEGORY by USER_ID, named 'categoryList'.
     * <pre>
     * <span style="color: #0000C0">memberBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">memberList</span>, <span style="color: #553000">memberLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">memberLoader</span>.<span style="color: #CC4747">loadCategory</span>(<span style="color: #553000">categoryCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">categoryCB</span>.setupSelect...
     *         <span style="color: #553000">categoryCB</span>.query().set...
     *         <span style="color: #553000">categoryCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">categoryLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    categoryLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Member member : <span style="color: #553000">memberList</span>) {
     *     ... = member.<span style="color: #CC4747">getCategoryList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setUserId_InScope(pkList);
     * cb.query().addOrderBy_UserId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfCategory> loadCategory(ReferrerConditionSetupper<CategoryCB> refCBLambda) {
        myBhv().loadCategory(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerCategory = refLs);
        return hd -> hd.handle(new LoaderOfCategory().ready(_referrerCategory, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Member> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
