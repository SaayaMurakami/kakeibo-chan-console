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
package saaya.murakami.dbflute.cbean.cq.bs;

import java.util.Map;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import saaya.murakami.dbflute.cbean.cq.ciq.*;
import saaya.murakami.dbflute.cbean.*;
import saaya.murakami.dbflute.cbean.cq.*;

/**
 * The base condition-query of STATEMENT.
 * @author DBFlute(AutoGenerator)
 */
public class BsStatementCQ extends AbstractBsStatementCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected StatementCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsStatementCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from STATEMENT) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public StatementCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected StatementCIQ xcreateCIQ() {
        StatementCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected StatementCIQ xnewCIQ() {
        return new StatementCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join STATEMENT on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public StatementCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        StatementCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _statementId;
    public ConditionValue xdfgetStatementId()
    { if (_statementId == null) { _statementId = nCV(); }
      return _statementId; }
    protected ConditionValue xgetCValueStatementId() { return xdfgetStatementId(); }

    /**
     * Add order-by as ascend. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_StatementId_Asc() { regOBA("STATEMENT_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_StatementId_Desc() { regOBD("STATEMENT_ID"); return this; }

    protected ConditionValue _categoryId;
    public ConditionValue xdfgetCategoryId()
    { if (_categoryId == null) { _categoryId = nCV(); }
      return _categoryId; }
    protected ConditionValue xgetCValueCategoryId() { return xdfgetCategoryId(); }

    /**
     * Add order-by as ascend. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_CategoryId_Asc() { regOBA("CATEGORY_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_CategoryId_Desc() { regOBD("CATEGORY_ID"); return this; }

    protected ConditionValue _accountId;
    public ConditionValue xdfgetAccountId()
    { if (_accountId == null) { _accountId = nCV(); }
      return _accountId; }
    protected ConditionValue xgetCValueAccountId() { return xdfgetAccountId(); }

    /**
     * Add order-by as ascend. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_AccountId_Asc() { regOBA("ACCOUNT_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_AccountId_Desc() { regOBD("ACCOUNT_ID"); return this; }

    protected ConditionValue _statementType;
    public ConditionValue xdfgetStatementType()
    { if (_statementType == null) { _statementType = nCV(); }
      return _statementType; }
    protected ConditionValue xgetCValueStatementType() { return xdfgetStatementType(); }

    /**
     * Add order-by as ascend. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_StatementType_Asc() { regOBA("STATEMENT_TYPE"); return this; }

    /**
     * Add order-by as descend. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_StatementType_Desc() { regOBD("STATEMENT_TYPE"); return this; }

    protected ConditionValue _date;
    public ConditionValue xdfgetDate()
    { if (_date == null) { _date = nCV(); }
      return _date; }
    protected ConditionValue xgetCValueDate() { return xdfgetDate(); }

    /**
     * Add order-by as ascend. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_Date_Asc() { regOBA("DATE"); return this; }

    /**
     * Add order-by as descend. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_Date_Desc() { regOBD("DATE"); return this; }

    protected ConditionValue _amount;
    public ConditionValue xdfgetAmount()
    { if (_amount == null) { _amount = nCV(); }
      return _amount; }
    protected ConditionValue xgetCValueAmount() { return xdfgetAmount(); }

    /**
     * Add order-by as ascend. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_Amount_Asc() { regOBA("AMOUNT"); return this; }

    /**
     * Add order-by as descend. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_Amount_Desc() { regOBD("AMOUNT"); return this; }

    protected ConditionValue _memo;
    public ConditionValue xdfgetMemo()
    { if (_memo == null) { _memo = nCV(); }
      return _memo; }
    protected ConditionValue xgetCValueMemo() { return xdfgetMemo(); }

    /**
     * Add order-by as ascend. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_Memo_Asc() { regOBA("MEMO"); return this; }

    /**
     * Add order-by as descend. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_Memo_Desc() { regOBD("MEMO"); return this; }

    protected ConditionValue _registerDatetime;
    public ConditionValue xdfgetRegisterDatetime()
    { if (_registerDatetime == null) { _registerDatetime = nCV(); }
      return _registerDatetime; }
    protected ConditionValue xgetCValueRegisterDatetime() { return xdfgetRegisterDatetime(); }

    /**
     * Add order-by as ascend. <br>
     * (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

    protected ConditionValue _registerUser;
    public ConditionValue xdfgetRegisterUser()
    { if (_registerUser == null) { _registerUser = nCV(); }
      return _registerUser; }
    protected ConditionValue xgetCValueRegisterUser() { return xdfgetRegisterUser(); }

    /**
     * Add order-by as ascend. <br>
     * (登録ユーザー)REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_RegisterUser_Asc() { regOBA("REGISTER_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * (登録ユーザー)REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_RegisterUser_Desc() { regOBD("REGISTER_USER"); return this; }

    protected ConditionValue _updateDatetime;
    public ConditionValue xdfgetUpdateDatetime()
    { if (_updateDatetime == null) { _updateDatetime = nCV(); }
      return _updateDatetime; }
    protected ConditionValue xgetCValueUpdateDatetime() { return xdfgetUpdateDatetime(); }

    /**
     * Add order-by as ascend. <br>
     * (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

    protected ConditionValue _updateUser;
    public ConditionValue xdfgetUpdateUser()
    { if (_updateUser == null) { _updateUser = nCV(); }
      return _updateUser; }
    protected ConditionValue xgetCValueUpdateUser() { return xdfgetUpdateUser(); }

    /**
     * Add order-by as ascend. <br>
     * (更新ユーザー)UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_UpdateUser_Asc() { regOBA("UPDATE_USER"); return this; }

    /**
     * Add order-by as descend. <br>
     * (更新ユーザー)UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_UpdateUser_Desc() { regOBD("UPDATE_USER"); return this; }

    protected ConditionValue _versionNo;
    public ConditionValue xdfgetVersionNo()
    { if (_versionNo == null) { _versionNo = nCV(); }
      return _versionNo; }
    protected ConditionValue xgetCValueVersionNo() { return xdfgetVersionNo(); }

    /**
     * Add order-by as ascend. <br>
     * (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }

    /**
     * Add order-by as descend. <br>
     * (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsStatementCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsStatementCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsStatementCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        StatementCQ bq = (StatementCQ)bqs;
        StatementCQ uq = (StatementCQ)uqs;
        if (bq.hasConditionQueryAccount()) {
            uq.queryAccount().reflectRelationOnUnionQuery(bq.queryAccount(), uq.queryAccount());
        }
        if (bq.hasConditionQueryCategory()) {
            uq.queryCategory().reflectRelationOnUnionQuery(bq.queryCategory(), uq.queryCategory());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * (アカウント)ACCOUNT by my ACCOUNT_ID, named 'account'.
     * @return The instance of condition-query. (NotNull)
     */
    public AccountCQ queryAccount() {
        return xdfgetConditionQueryAccount();
    }
    public AccountCQ xdfgetConditionQueryAccount() {
        String prop = "account";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryAccount()); xsetupOuterJoinAccount(); }
        return xgetQueRlMap(prop);
    }
    protected AccountCQ xcreateQueryAccount() {
        String nrp = xresolveNRP("STATEMENT", "account"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new AccountCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "account", nrp);
    }
    protected void xsetupOuterJoinAccount() { xregOutJo("account"); }
    public boolean hasConditionQueryAccount() { return xhasQueRlMap("account"); }

    /**
     * Get the condition-query for relation table. <br>
     * (カテゴリー)CATEGORY by my CATEGORY_ID, named 'category'.
     * @return The instance of condition-query. (NotNull)
     */
    public CategoryCQ queryCategory() {
        return xdfgetConditionQueryCategory();
    }
    public CategoryCQ xdfgetConditionQueryCategory() {
        String prop = "category";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryCategory()); xsetupOuterJoinCategory(); }
        return xgetQueRlMap(prop);
    }
    protected CategoryCQ xcreateQueryCategory() {
        String nrp = xresolveNRP("STATEMENT", "category"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new CategoryCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "category", nrp);
    }
    protected void xsetupOuterJoinCategory() { xregOutJo("category"); }
    public boolean hasConditionQueryCategory() { return xhasQueRlMap("category"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, StatementCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(StatementCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, StatementCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(StatementCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, StatementCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(StatementCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, StatementCQ> _myselfExistsMap;
    public Map<String, StatementCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(StatementCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, StatementCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(StatementCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return StatementCB.class.getName(); }
    protected String xCQ() { return StatementCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
