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
package saaya.murakami.dbflute.cbean.nss;

import saaya.murakami.dbflute.cbean.cq.StatementCQ;

/**
 * The nest select set-upper of STATEMENT.
 * @author DBFlute(AutoGenerator)
 */
public class StatementNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final StatementCQ _query;
    public StatementNss(StatementCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * (アカウント)ACCOUNT by my ACCOUNT_ID, named 'account'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public AccountNss withAccount() {
        _query.xdoNss(() -> _query.queryAccount());
        return new AccountNss(_query.queryAccount());
    }
    /**
     * With nested relation columns to select clause. <br>
     * (カテゴリー)CATEGORY by my CATEGORY_ID, named 'category'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public CategoryNss withCategory() {
        _query.xdoNss(() -> _query.queryCategory());
        return new CategoryNss(_query.queryCategory());
    }
}
