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
package saaya.murakami.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import saaya.murakami.dbflute.allcommon.EntityDefinedCommonColumn;
import saaya.murakami.dbflute.allcommon.DBMetaInstanceHandler;
import saaya.murakami.dbflute.allcommon.CDef;
import saaya.murakami.dbflute.exentity.*;

/**
 * The entity of (明細)STATEMENT as TABLE. <br>
 * <pre>
 * [primary-key]
 *     STATEMENT_ID
 *
 * [column]
 *     STATEMENT_ID, USER_ID, CATEGORY_ID, ACCOUNT_ID, STATEMENT_TYPE, DATE, AMOUNT, MEMO, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
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
 *     ACCOUNT, CATEGORY, MEMBER
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     account, category, member
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long statementId = entity.getStatementId();
 * Long userId = entity.getUserId();
 * Long categoryId = entity.getCategoryId();
 * Long accountId = entity.getAccountId();
 * String statementType = entity.getStatementType();
 * java.time.LocalDate date = entity.getDate();
 * Integer amount = entity.getAmount();
 * String memo = entity.getMemo();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setStatementId(statementId);
 * entity.setUserId(userId);
 * entity.setCategoryId(categoryId);
 * entity.setAccountId(accountId);
 * entity.setStatementType(statementType);
 * entity.setDate(date);
 * entity.setAmount(amount);
 * entity.setMemo(memo);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsStatement extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _statementId;

    /** (会員ID)USER_ID: {IX, NotNull, BIGINT(19), FK to MEMBER} */
    protected Long _userId;

    /** (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY} */
    protected Long _categoryId;

    /** (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT} */
    protected Long _accountId;

    /** (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10), classification=StatementType} */
    protected String _statementType;

    /** (日付)DATE: {NotNull, DATE(10)} */
    protected java.time.LocalDate _date;

    /** (金額)AMOUNT: {NotNull, INT(10)} */
    protected Integer _amount;

    /** (メモ)MEMO: {VARCHAR(200)} */
    protected String _memo;

    /** (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _registerDatetime;

    /** (登録ユーザー)REGISTER_USER: {NotNull, VARCHAR(200)} */
    protected String _registerUser;

    /** (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _updateDatetime;

    /** (更新ユーザー)UPDATE_USER: {NotNull, VARCHAR(200)} */
    protected String _updateUser;

    /** (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)} */
    protected Long _versionNo;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "STATEMENT";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_statementId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of statementType as the classification of StatementType. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10), classification=StatementType} <br>
     * 明細の種類を表す区分値
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.StatementType getStatementTypeAsStatementType() {
        return CDef.StatementType.codeOf(getStatementType());
    }

    /**
     * Set the value of statementType as the classification of StatementType. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10), classification=StatementType} <br>
     * 明細の種類を表す区分値
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setStatementTypeAsStatementType(CDef.StatementType cdef) {
        setStatementType(cdef != null ? cdef.code() : null);
    }

    /**
     * Set the value of statementType as boolean. <br>
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10), classification=StatementType} <br>
     * 明細の種類を表す区分値
     * @param determination The determination, true or false. (NullAllowed: if null, null value is set to the column)
     */
    public void setStatementTypeAsBoolean(Boolean determination) {
        setStatementTypeAsStatementType(CDef.StatementType.codeOf(determination));
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of statementType as Income (INCOME). <br>
     * 収入: 収入を表す
     */
    public void setStatementType_Income() {
        setStatementTypeAsStatementType(CDef.StatementType.Income);
    }

    /**
     * Set the value of statementType as Spend (SPEND). <br>
     * 支出: 支出を表す
     */
    public void setStatementType_Spend() {
        setStatementTypeAsStatementType(CDef.StatementType.Spend);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of statementType Income? <br>
     * 収入: 収入を表す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isStatementTypeIncome() {
        CDef.StatementType cdef = getStatementTypeAsStatementType();
        return cdef != null ? cdef.equals(CDef.StatementType.Income) : false;
    }

    /**
     * Is the value of statementType Spend? <br>
     * 支出: 支出を表す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isStatementTypeSpend() {
        CDef.StatementType cdef = getStatementTypeAsStatementType();
        return cdef != null ? cdef.equals(CDef.StatementType.Spend) : false;
    }

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
    /**
     * Get the value of the column 'statementType' as classification alias.
     * @return The string of classification alias. (NullAllowed: when the column value is null)
     */
    public String getStatementTypeAlias() {
        CDef.StatementType cdef = getStatementTypeAsStatementType();
        return cdef != null ? cdef.alias() : null;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** (アカウント)ACCOUNT by my ACCOUNT_ID, named 'account'. */
    protected OptionalEntity<Account> _account;

    /**
     * [get] (アカウント)ACCOUNT by my ACCOUNT_ID, named 'account'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'account'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Account> getAccount() {
        if (_account == null) { _account = OptionalEntity.relationEmpty(this, "account"); }
        return _account;
    }

    /**
     * [set] (アカウント)ACCOUNT by my ACCOUNT_ID, named 'account'.
     * @param account The entity of foreign property 'account'. (NullAllowed)
     */
    public void setAccount(OptionalEntity<Account> account) {
        _account = account;
    }

    /** (カテゴリー)CATEGORY by my CATEGORY_ID, named 'category'. */
    protected OptionalEntity<Category> _category;

    /**
     * [get] (カテゴリー)CATEGORY by my CATEGORY_ID, named 'category'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'category'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Category> getCategory() {
        if (_category == null) { _category = OptionalEntity.relationEmpty(this, "category"); }
        return _category;
    }

    /**
     * [set] (カテゴリー)CATEGORY by my CATEGORY_ID, named 'category'.
     * @param category The entity of foreign property 'category'. (NullAllowed)
     */
    public void setCategory(OptionalEntity<Category> category) {
        _category = category;
    }

    /** (会員)MEMBER by my USER_ID, named 'member'. */
    protected OptionalEntity<Member> _member;

    /**
     * [get] (会員)MEMBER by my USER_ID, named 'member'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'member'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Member> getMember() {
        if (_member == null) { _member = OptionalEntity.relationEmpty(this, "member"); }
        return _member;
    }

    /**
     * [set] (会員)MEMBER by my USER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(OptionalEntity<Member> member) {
        _member = member;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsStatement) {
            BsStatement other = (BsStatement)obj;
            if (!xSV(_statementId, other._statementId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _statementId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_account != null && _account.isPresent())
        { sb.append(li).append(xbRDS(_account, "account")); }
        if (_category != null && _category.isPresent())
        { sb.append(li).append(xbRDS(_category, "category")); }
        if (_member != null && _member.isPresent())
        { sb.append(li).append(xbRDS(_member, "member")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_statementId));
        sb.append(dm).append(xfND(_userId));
        sb.append(dm).append(xfND(_categoryId));
        sb.append(dm).append(xfND(_accountId));
        sb.append(dm).append(xfND(_statementType));
        sb.append(dm).append(xfND(_date));
        sb.append(dm).append(xfND(_amount));
        sb.append(dm).append(xfND(_memo));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerUser));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateUser));
        sb.append(dm).append(xfND(_versionNo));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_account != null && _account.isPresent())
        { sb.append(dm).append("account"); }
        if (_category != null && _category.isPresent())
        { sb.append(dm).append("category"); }
        if (_member != null && _member.isPresent())
        { sb.append(dm).append("member"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Statement clone() {
        return (Statement)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @return The value of the column 'STATEMENT_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getStatementId() {
        checkSpecifiedProperty("statementId");
        return _statementId;
    }

    /**
     * [set] (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @param statementId The value of the column 'STATEMENT_ID'. (basically NotNull if update: for the constraint)
     */
    public void setStatementId(Long statementId) {
        registerModifiedProperty("statementId");
        _statementId = statementId;
    }

    /**
     * [get] (会員ID)USER_ID: {IX, NotNull, BIGINT(19), FK to MEMBER} <br>
     * @return The value of the column 'USER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getUserId() {
        checkSpecifiedProperty("userId");
        return _userId;
    }

    /**
     * [set] (会員ID)USER_ID: {IX, NotNull, BIGINT(19), FK to MEMBER} <br>
     * @param userId The value of the column 'USER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setUserId(Long userId) {
        registerModifiedProperty("userId");
        _userId = userId;
    }

    /**
     * [get] (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY} <br>
     * @return The value of the column 'CATEGORY_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getCategoryId() {
        checkSpecifiedProperty("categoryId");
        return _categoryId;
    }

    /**
     * [set] (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY} <br>
     * @param categoryId The value of the column 'CATEGORY_ID'. (basically NotNull if update: for the constraint)
     */
    public void setCategoryId(Long categoryId) {
        registerModifiedProperty("categoryId");
        _categoryId = categoryId;
    }

    /**
     * [get] (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT} <br>
     * @return The value of the column 'ACCOUNT_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getAccountId() {
        checkSpecifiedProperty("accountId");
        return _accountId;
    }

    /**
     * [set] (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT} <br>
     * @param accountId The value of the column 'ACCOUNT_ID'. (basically NotNull if update: for the constraint)
     */
    public void setAccountId(Long accountId) {
        registerModifiedProperty("accountId");
        _accountId = accountId;
    }

    /**
     * [get] (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10), classification=StatementType} <br>
     * @return The value of the column 'STATEMENT_TYPE'. (basically NotNull if selected: for the constraint)
     */
    public String getStatementType() {
        checkSpecifiedProperty("statementType");
        return convertEmptyToNull(_statementType);
    }

    /**
     * [set] (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10), classification=StatementType} <br>
     * @param statementType The value of the column 'STATEMENT_TYPE'. (basically NotNull if update: for the constraint)
     */
    protected void setStatementType(String statementType) {
        checkClassificationCode("STATEMENT_TYPE", CDef.DefMeta.StatementType, statementType);
        registerModifiedProperty("statementType");
        _statementType = statementType;
    }

    /**
     * [get] (日付)DATE: {NotNull, DATE(10)} <br>
     * @return The value of the column 'DATE'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDate getDate() {
        checkSpecifiedProperty("date");
        return _date;
    }

    /**
     * [set] (日付)DATE: {NotNull, DATE(10)} <br>
     * @param date The value of the column 'DATE'. (basically NotNull if update: for the constraint)
     */
    public void setDate(java.time.LocalDate date) {
        registerModifiedProperty("date");
        _date = date;
    }

    /**
     * [get] (金額)AMOUNT: {NotNull, INT(10)} <br>
     * @return The value of the column 'AMOUNT'. (basically NotNull if selected: for the constraint)
     */
    public Integer getAmount() {
        checkSpecifiedProperty("amount");
        return _amount;
    }

    /**
     * [set] (金額)AMOUNT: {NotNull, INT(10)} <br>
     * @param amount The value of the column 'AMOUNT'. (basically NotNull if update: for the constraint)
     */
    public void setAmount(Integer amount) {
        registerModifiedProperty("amount");
        _amount = amount;
    }

    /**
     * [get] (メモ)MEMO: {VARCHAR(200)} <br>
     * 支出内容の補足説明
     * @return The value of the column 'MEMO'. (NullAllowed even if selected: for no constraint)
     */
    public String getMemo() {
        checkSpecifiedProperty("memo");
        return convertEmptyToNull(_memo);
    }

    /**
     * [set] (メモ)MEMO: {VARCHAR(200)} <br>
     * 支出内容の補足説明
     * @param memo The value of the column 'MEMO'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemo(String memo) {
        registerModifiedProperty("memo");
        _memo = memo;
    }

    /**
     * [get] (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.time.LocalDateTime registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] (登録ユーザー)REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * @return The value of the column 'REGISTER_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterUser() {
        checkSpecifiedProperty("registerUser");
        return convertEmptyToNull(_registerUser);
    }

    /**
     * [set] (登録ユーザー)REGISTER_USER: {NotNull, VARCHAR(200)} <br>
     * @param registerUser The value of the column 'REGISTER_USER'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterUser(String registerUser) {
        registerModifiedProperty("registerUser");
        _registerUser = registerUser;
    }

    /**
     * [get] (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.time.LocalDateTime updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] (更新ユーザー)UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * @return The value of the column 'UPDATE_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateUser() {
        checkSpecifiedProperty("updateUser");
        return convertEmptyToNull(_updateUser);
    }

    /**
     * [set] (更新ユーザー)UPDATE_USER: {NotNull, VARCHAR(200)} <br>
     * @param updateUser The value of the column 'UPDATE_USER'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateUser(String updateUser) {
        registerModifiedProperty("updateUser");
        _updateUser = updateUser;
    }

    /**
     * [get] (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)} <br>
     * @return The value of the column 'VERSION_NO'. (basically NotNull if selected: for the constraint)
     */
    public Long getVersionNo() {
        checkSpecifiedProperty("versionNo");
        return _versionNo;
    }

    /**
     * [set] (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)} <br>
     * @param versionNo The value of the column 'VERSION_NO'. (basically NotNull if update: for the constraint)
     */
    public void setVersionNo(Long versionNo) {
        registerModifiedProperty("versionNo");
        _versionNo = versionNo;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param statementType The value of the column 'STATEMENT_TYPE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingStatementType(String statementType) {
        setStatementType(statementType);
    }
}
