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
import saaya.murakami.dbflute.exbhv.*;
import saaya.murakami.dbflute.exentity.*;

/**
 * The referrer loader of (明細)STATEMENT as TABLE. <br>
 * <pre>
 * [primary key]
 *     STATEMENT_ID
 *
 * [column]
 *     STATEMENT_ID, CATEGORY_ID, ACCOUNT_ID, STATEMENT_TYPE, DATE, AMOUNT, MEMO, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     STATEMENT_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     ACCOUNT, CATEGORY
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     account, category
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfStatement {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Statement> _selectedList;
    protected BehaviorSelector _selector;
    protected StatementBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfStatement ready(List<Statement> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected StatementBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(StatementBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfAccount _foreignAccountLoader;
    public LoaderOfAccount pulloutAccount() {
        if (_foreignAccountLoader == null)
        { _foreignAccountLoader = new LoaderOfAccount().ready(myBhv().pulloutAccount(_selectedList), _selector); }
        return _foreignAccountLoader;
    }

    protected LoaderOfCategory _foreignCategoryLoader;
    public LoaderOfCategory pulloutCategory() {
        if (_foreignCategoryLoader == null)
        { _foreignCategoryLoader = new LoaderOfCategory().ready(myBhv().pulloutCategory(_selectedList), _selector); }
        return _foreignCategoryLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Statement> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
