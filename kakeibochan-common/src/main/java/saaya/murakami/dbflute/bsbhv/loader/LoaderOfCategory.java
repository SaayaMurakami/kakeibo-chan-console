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
 * The referrer loader of (カテゴリー)CATEGORY as TABLE. <br>
 * <pre>
 * [primary key]
 *     CATEGORY_ID
 *
 * [column]
 *     CATEGORY_ID, USER_ID, CATEGORY, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     CATEGORY_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     MEMBER
 *
 * [referrer table]
 *     STATEMENT
 *
 * [foreign property]
 *     member
 *
 * [referrer property]
 *     statementList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfCategory {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Category> _selectedList;
    protected BehaviorSelector _selector;
    protected CategoryBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfCategory ready(List<Category> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected CategoryBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(CategoryBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Statement> _referrerStatement;

    /**
     * Load referrer of statementList by the set-upper of referrer. <br>
     * (明細)STATEMENT by CATEGORY_ID, named 'statementList'.
     * <pre>
     * <span style="color: #0000C0">categoryBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">categoryList</span>, <span style="color: #553000">categoryLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">categoryLoader</span>.<span style="color: #CC4747">loadStatement</span>(<span style="color: #553000">statementCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">statementCB</span>.setupSelect...
     *         <span style="color: #553000">statementCB</span>.query().set...
     *         <span style="color: #553000">statementCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">statementLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    statementLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Category category : <span style="color: #553000">categoryList</span>) {
     *     ... = category.<span style="color: #CC4747">getStatementList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setCategoryId_InScope(pkList);
     * cb.query().addOrderBy_CategoryId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfStatement> loadStatement(ReferrerConditionSetupper<StatementCB> refCBLambda) {
        myBhv().loadStatement(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerStatement = refLs);
        return hd -> hd.handle(new LoaderOfStatement().ready(_referrerStatement, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMember _foreignMemberLoader;
    public LoaderOfMember pulloutMember() {
        if (_foreignMemberLoader == null)
        { _foreignMemberLoader = new LoaderOfMember().ready(myBhv().pulloutMember(_selectedList), _selector); }
        return _foreignMemberLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Category> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
