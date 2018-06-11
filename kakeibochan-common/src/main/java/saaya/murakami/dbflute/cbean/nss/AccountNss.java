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

import saaya.murakami.dbflute.cbean.cq.AccountCQ;

/**
 * The nest select set-upper of ACCOUNT.
 * @author DBFlute(AutoGenerator)
 */
public class AccountNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final AccountCQ _query;
    public AccountNss(AccountCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * (会員)MEMBER by my USER_ID, named 'member'.
     */
    public void withMember() {
        _query.xdoNss(() -> _query.queryMember());
    }
}
