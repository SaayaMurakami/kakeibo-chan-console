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

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import saaya.murakami.dbflute.allcommon.*;
import saaya.murakami.dbflute.cbean.*;
import saaya.murakami.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of STATEMENT.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsStatementCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsStatementCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "STATEMENT";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param statementId The value of statementId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setStatementId_Equal(Long statementId) {
        doSetStatementId_Equal(statementId);
    }

    protected void doSetStatementId_Equal(Long statementId) {
        regStatementId(CK_EQ, statementId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param statementId The value of statementId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStatementId_NotEqual(Long statementId) {
        doSetStatementId_NotEqual(statementId);
    }

    protected void doSetStatementId_NotEqual(Long statementId) {
        regStatementId(CK_NES, statementId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param statementId The value of statementId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStatementId_GreaterThan(Long statementId) {
        regStatementId(CK_GT, statementId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param statementId The value of statementId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStatementId_LessThan(Long statementId) {
        regStatementId(CK_LT, statementId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param statementId The value of statementId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStatementId_GreaterEqual(Long statementId) {
        regStatementId(CK_GE, statementId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param statementId The value of statementId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStatementId_LessEqual(Long statementId) {
        regStatementId(CK_LE, statementId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of statementId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of statementId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setStatementId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setStatementId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of statementId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of statementId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setStatementId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueStatementId(), "STATEMENT_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param statementIdList The collection of statementId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStatementId_InScope(Collection<Long> statementIdList) {
        doSetStatementId_InScope(statementIdList);
    }

    protected void doSetStatementId_InScope(Collection<Long> statementIdList) {
        regINS(CK_INS, cTL(statementIdList), xgetCValueStatementId(), "STATEMENT_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param statementIdList The collection of statementId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStatementId_NotInScope(Collection<Long> statementIdList) {
        doSetStatementId_NotInScope(statementIdList);
    }

    protected void doSetStatementId_NotInScope(Collection<Long> statementIdList) {
        regINS(CK_NINS, cTL(statementIdList), xgetCValueStatementId(), "STATEMENT_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setStatementId_IsNull() { regStatementId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setStatementId_IsNotNull() { regStatementId(CK_ISNN, DOBJ); }

    protected void regStatementId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueStatementId(), "STATEMENT_ID"); }
    protected abstract ConditionValue xgetCValueStatementId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param categoryId The value of categoryId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setCategoryId_Equal(Long categoryId) {
        doSetCategoryId_Equal(categoryId);
    }

    protected void doSetCategoryId_Equal(Long categoryId) {
        regCategoryId(CK_EQ, categoryId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param categoryId The value of categoryId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCategoryId_NotEqual(Long categoryId) {
        doSetCategoryId_NotEqual(categoryId);
    }

    protected void doSetCategoryId_NotEqual(Long categoryId) {
        regCategoryId(CK_NES, categoryId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param categoryId The value of categoryId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCategoryId_GreaterThan(Long categoryId) {
        regCategoryId(CK_GT, categoryId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param categoryId The value of categoryId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCategoryId_LessThan(Long categoryId) {
        regCategoryId(CK_LT, categoryId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param categoryId The value of categoryId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCategoryId_GreaterEqual(Long categoryId) {
        regCategoryId(CK_GE, categoryId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param categoryId The value of categoryId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCategoryId_LessEqual(Long categoryId) {
        regCategoryId(CK_LE, categoryId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param minNumber The min number of categoryId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of categoryId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setCategoryId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setCategoryId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param minNumber The min number of categoryId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of categoryId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setCategoryId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueCategoryId(), "CATEGORY_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param categoryIdList The collection of categoryId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCategoryId_InScope(Collection<Long> categoryIdList) {
        doSetCategoryId_InScope(categoryIdList);
    }

    protected void doSetCategoryId_InScope(Collection<Long> categoryIdList) {
        regINS(CK_INS, cTL(categoryIdList), xgetCValueCategoryId(), "CATEGORY_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @param categoryIdList The collection of categoryId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCategoryId_NotInScope(Collection<Long> categoryIdList) {
        doSetCategoryId_NotInScope(categoryIdList);
    }

    protected void doSetCategoryId_NotInScope(Collection<Long> categoryIdList) {
        regINS(CK_NINS, cTL(categoryIdList), xgetCValueCategoryId(), "CATEGORY_ID");
    }

    protected void regCategoryId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCategoryId(), "CATEGORY_ID"); }
    protected abstract ConditionValue xgetCValueCategoryId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param accountId The value of accountId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setAccountId_Equal(Long accountId) {
        doSetAccountId_Equal(accountId);
    }

    protected void doSetAccountId_Equal(Long accountId) {
        regAccountId(CK_EQ, accountId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param accountId The value of accountId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setAccountId_NotEqual(Long accountId) {
        doSetAccountId_NotEqual(accountId);
    }

    protected void doSetAccountId_NotEqual(Long accountId) {
        regAccountId(CK_NES, accountId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param accountId The value of accountId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setAccountId_GreaterThan(Long accountId) {
        regAccountId(CK_GT, accountId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param accountId The value of accountId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setAccountId_LessThan(Long accountId) {
        regAccountId(CK_LT, accountId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param accountId The value of accountId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setAccountId_GreaterEqual(Long accountId) {
        regAccountId(CK_GE, accountId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param accountId The value of accountId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setAccountId_LessEqual(Long accountId) {
        regAccountId(CK_LE, accountId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param minNumber The min number of accountId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of accountId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setAccountId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setAccountId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param minNumber The min number of accountId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of accountId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setAccountId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueAccountId(), "ACCOUNT_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param accountIdList The collection of accountId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAccountId_InScope(Collection<Long> accountIdList) {
        doSetAccountId_InScope(accountIdList);
    }

    protected void doSetAccountId_InScope(Collection<Long> accountIdList) {
        regINS(CK_INS, cTL(accountIdList), xgetCValueAccountId(), "ACCOUNT_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @param accountIdList The collection of accountId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAccountId_NotInScope(Collection<Long> accountIdList) {
        doSetAccountId_NotInScope(accountIdList);
    }

    protected void doSetAccountId_NotInScope(Collection<Long> accountIdList) {
        regINS(CK_NINS, cTL(accountIdList), xgetCValueAccountId(), "ACCOUNT_ID");
    }

    protected void regAccountId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAccountId(), "ACCOUNT_ID"); }
    protected abstract ConditionValue xgetCValueAccountId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @param statementType The value of statementType as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStatementType_Equal(String statementType) {
        doSetStatementType_Equal(fRES(statementType));
    }

    protected void doSetStatementType_Equal(String statementType) {
        regStatementType(CK_EQ, statementType);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @param statementType The value of statementType as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStatementType_NotEqual(String statementType) {
        doSetStatementType_NotEqual(fRES(statementType));
    }

    protected void doSetStatementType_NotEqual(String statementType) {
        regStatementType(CK_NES, statementType);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @param statementTypeList The collection of statementType as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStatementType_InScope(Collection<String> statementTypeList) {
        doSetStatementType_InScope(statementTypeList);
    }

    protected void doSetStatementType_InScope(Collection<String> statementTypeList) {
        regINS(CK_INS, cTL(statementTypeList), xgetCValueStatementType(), "STATEMENT_TYPE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @param statementTypeList The collection of statementType as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStatementType_NotInScope(Collection<String> statementTypeList) {
        doSetStatementType_NotInScope(statementTypeList);
    }

    protected void doSetStatementType_NotInScope(Collection<String> statementTypeList) {
        regINS(CK_NINS, cTL(statementTypeList), xgetCValueStatementType(), "STATEMENT_TYPE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)} <br>
     * <pre>e.g. setStatementType_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param statementType The value of statementType as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setStatementType_LikeSearch(String statementType, ConditionOptionCall<LikeSearchOption> opLambda) {
        setStatementType_LikeSearch(statementType, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)} <br>
     * <pre>e.g. setStatementType_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param statementType The value of statementType as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setStatementType_LikeSearch(String statementType, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(statementType), xgetCValueStatementType(), "STATEMENT_TYPE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @param statementType The value of statementType as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setStatementType_NotLikeSearch(String statementType, ConditionOptionCall<LikeSearchOption> opLambda) {
        setStatementType_NotLikeSearch(statementType, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @param statementType The value of statementType as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setStatementType_NotLikeSearch(String statementType, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(statementType), xgetCValueStatementType(), "STATEMENT_TYPE", likeSearchOption);
    }

    protected void regStatementType(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueStatementType(), "STATEMENT_TYPE"); }
    protected abstract ConditionValue xgetCValueStatementType();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * @param date The value of date as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDate_Equal(java.time.LocalDate date) {
        regDate(CK_EQ,  date);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * @param date The value of date as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDate_GreaterThan(java.time.LocalDate date) {
        regDate(CK_GT,  date);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * @param date The value of date as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDate_LessThan(java.time.LocalDate date) {
        regDate(CK_LT,  date);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * @param date The value of date as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDate_GreaterEqual(java.time.LocalDate date) {
        regDate(CK_GE,  date);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * @param date The value of date as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDate_LessEqual(java.time.LocalDate date) {
        regDate(CK_LE, date);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * <pre>e.g. setDate_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of date. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of date. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setDate_FromTo(java.time.LocalDate fromDatetime, java.time.LocalDate toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setDate_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (日付)DATE: {NotNull, DATE(10)}
     * <pre>e.g. setDate_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of date. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of date. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setDate_FromTo(java.time.LocalDate fromDatetime, java.time.LocalDate toDatetime, FromToOption fromToOption) {
        String nm = "DATE"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueDate(), nm, op);
    }

    protected void regDate(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDate(), "DATE"); }
    protected abstract ConditionValue xgetCValueDate();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param amount The value of amount as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setAmount_Equal(Integer amount) {
        doSetAmount_Equal(amount);
    }

    protected void doSetAmount_Equal(Integer amount) {
        regAmount(CK_EQ, amount);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param amount The value of amount as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setAmount_NotEqual(Integer amount) {
        doSetAmount_NotEqual(amount);
    }

    protected void doSetAmount_NotEqual(Integer amount) {
        regAmount(CK_NES, amount);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param amount The value of amount as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setAmount_GreaterThan(Integer amount) {
        regAmount(CK_GT, amount);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param amount The value of amount as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setAmount_LessThan(Integer amount) {
        regAmount(CK_LT, amount);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param amount The value of amount as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setAmount_GreaterEqual(Integer amount) {
        regAmount(CK_GE, amount);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param amount The value of amount as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setAmount_LessEqual(Integer amount) {
        regAmount(CK_LE, amount);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param minNumber The min number of amount. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of amount. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setAmount_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setAmount_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param minNumber The min number of amount. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of amount. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setAmount_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueAmount(), "AMOUNT", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param amountList The collection of amount as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAmount_InScope(Collection<Integer> amountList) {
        doSetAmount_InScope(amountList);
    }

    protected void doSetAmount_InScope(Collection<Integer> amountList) {
        regINS(CK_INS, cTL(amountList), xgetCValueAmount(), "AMOUNT");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @param amountList The collection of amount as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAmount_NotInScope(Collection<Integer> amountList) {
        doSetAmount_NotInScope(amountList);
    }

    protected void doSetAmount_NotInScope(Collection<Integer> amountList) {
        regINS(CK_NINS, cTL(amountList), xgetCValueAmount(), "AMOUNT");
    }

    protected void regAmount(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAmount(), "AMOUNT"); }
    protected abstract ConditionValue xgetCValueAmount();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     * @param memo The value of memo as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMemo_Equal(String memo) {
        doSetMemo_Equal(fRES(memo));
    }

    protected void doSetMemo_Equal(String memo) {
        regMemo(CK_EQ, memo);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     * @param memo The value of memo as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMemo_NotEqual(String memo) {
        doSetMemo_NotEqual(fRES(memo));
    }

    protected void doSetMemo_NotEqual(String memo) {
        regMemo(CK_NES, memo);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     * @param memoList The collection of memo as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMemo_InScope(Collection<String> memoList) {
        doSetMemo_InScope(memoList);
    }

    protected void doSetMemo_InScope(Collection<String> memoList) {
        regINS(CK_INS, cTL(memoList), xgetCValueMemo(), "MEMO");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     * @param memoList The collection of memo as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMemo_NotInScope(Collection<String> memoList) {
        doSetMemo_NotInScope(memoList);
    }

    protected void doSetMemo_NotInScope(Collection<String> memoList) {
        regINS(CK_NINS, cTL(memoList), xgetCValueMemo(), "MEMO");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)} <br>
     * <pre>e.g. setMemo_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param memo The value of memo as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setMemo_LikeSearch(String memo, ConditionOptionCall<LikeSearchOption> opLambda) {
        setMemo_LikeSearch(memo, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)} <br>
     * <pre>e.g. setMemo_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param memo The value of memo as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setMemo_LikeSearch(String memo, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(memo), xgetCValueMemo(), "MEMO", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     * @param memo The value of memo as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setMemo_NotLikeSearch(String memo, ConditionOptionCall<LikeSearchOption> opLambda) {
        setMemo_NotLikeSearch(memo, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     * @param memo The value of memo as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setMemo_NotLikeSearch(String memo, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(memo), xgetCValueMemo(), "MEMO", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     */
    public void setMemo_IsNull() { regMemo(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     */
    public void setMemo_IsNullOrEmpty() { regMemo(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * (メモ)MEMO: {VARCHAR(200)}
     */
    public void setMemo_IsNotNull() { regMemo(CK_ISNN, DOBJ); }

    protected void regMemo(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueMemo(), "MEMO"); }
    protected abstract ConditionValue xgetCValueMemo();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_Equal(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_EQ,  registerDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setRegisterDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "REGISTER_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueRegisterDatetime(), nm, op);
    }

    protected void regRegisterDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterDatetime(), "REGISTER_DATETIME"); }
    protected abstract ConditionValue xgetCValueRegisterDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * (登録ユーザー)REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterUser_Equal(String registerUser) {
        doSetRegisterUser_Equal(fRES(registerUser));
    }

    protected void doSetRegisterUser_Equal(String registerUser) {
        regRegisterUser(CK_EQ, registerUser);
    }

    protected void regRegisterUser(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterUser(), "REGISTER_USER"); }
    protected abstract ConditionValue xgetCValueRegisterUser();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_Equal(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setUpdateDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "UPDATE_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueUpdateDatetime(), nm, op);
    }

    protected void regUpdateDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateDatetime(), "UPDATE_DATETIME"); }
    protected abstract ConditionValue xgetCValueUpdateDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * (更新ユーザー)UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateUser_Equal(String updateUser) {
        doSetUpdateUser_Equal(fRES(updateUser));
    }

    protected void doSetUpdateUser_Equal(String updateUser) {
        regUpdateUser(CK_EQ, updateUser);
    }

    protected void regUpdateUser(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateUser(), "UPDATE_USER"); }
    protected abstract ConditionValue xgetCValueUpdateUser();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setVersionNo_Equal(Long versionNo) {
        doSetVersionNo_Equal(versionNo);
    }

    protected void doSetVersionNo_Equal(Long versionNo) {
        regVersionNo(CK_EQ, versionNo);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)}
     * @param minNumber The min number of versionNo. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of versionNo. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setVersionNo_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setVersionNo_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)}
     * @param minNumber The min number of versionNo. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of versionNo. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVersionNo_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVersionNo(), "VERSION_NO", rangeOfOption);
    }

    protected void regVersionNo(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVersionNo(), "VERSION_NO"); }
    protected abstract ConditionValue xgetCValueVersionNo();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StatementCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, StatementCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StatementCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, StatementCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StatementCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, StatementCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StatementCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, StatementCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StatementCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, StatementCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;StatementCB&gt;() {
     *     public void query(StatementCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StatementCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, StatementCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        StatementCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(StatementCQ sq);

    protected StatementCB xcreateScalarConditionCB() {
        StatementCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected StatementCB xcreateScalarConditionPartitionByCB() {
        StatementCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<StatementCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        StatementCB cb = new StatementCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "STATEMENT_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(StatementCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<StatementCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(StatementCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        StatementCB cb = new StatementCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "STATEMENT_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(StatementCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<StatementCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        StatementCB cb = new StatementCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(StatementCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected StatementCB newMyCB() {
        return new StatementCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return StatementCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
