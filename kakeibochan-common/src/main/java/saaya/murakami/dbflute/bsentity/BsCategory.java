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
import saaya.murakami.dbflute.exentity.*;

/**
 * The entity of (カテゴリー)CATEGORY as TABLE. <br>
 * <pre>
 * [primary-key]
 *     CATEGORY_ID
 *
 * [column]
 *     CATEGORY_ID, USER_ID, CATEGORY_TYPE, CATEGORY, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
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
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long categoryId = entity.getCategoryId();
 * Long userId = entity.getUserId();
 * String categoryType = entity.getCategoryType();
 * String category = entity.getCategory();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setCategoryId(categoryId);
 * entity.setUserId(userId);
 * entity.setCategoryType(categoryType);
 * entity.setCategory(category);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCategory extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** (カテゴリーID)CATEGORY_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _categoryId;

    /** (会員ID)USER_ID: {IX, NotNull, BIGINT(19), FK to MEMBER} */
    protected Long _userId;

    /** (カテゴリタイプ)CATEGORY_TYPE: {NotNull, VARCHAR(10)} */
    protected String _categoryType;

    /** (カテゴリー)CATEGORY: {NotNull, VARCHAR(200)} */
    protected String _category;

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
        return "CATEGORY";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_categoryId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
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
    /** (明細)STATEMENT by CATEGORY_ID, named 'statementList'. */
    protected List<Statement> _statementList;

    /**
     * [get] (明細)STATEMENT by CATEGORY_ID, named 'statementList'.
     * @return The entity list of referrer property 'statementList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Statement> getStatementList() {
        if (_statementList == null) { _statementList = newReferrerList(); }
        return _statementList;
    }

    /**
     * [set] (明細)STATEMENT by CATEGORY_ID, named 'statementList'.
     * @param statementList The entity list of referrer property 'statementList'. (NullAllowed)
     */
    public void setStatementList(List<Statement> statementList) {
        _statementList = statementList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsCategory) {
            BsCategory other = (BsCategory)obj;
            if (!xSV(_categoryId, other._categoryId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _categoryId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_member != null && _member.isPresent())
        { sb.append(li).append(xbRDS(_member, "member")); }
        if (_statementList != null) { for (Statement et : _statementList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "statementList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_categoryId));
        sb.append(dm).append(xfND(_userId));
        sb.append(dm).append(xfND(_categoryType));
        sb.append(dm).append(xfND(_category));
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
        if (_member != null && _member.isPresent())
        { sb.append(dm).append("member"); }
        if (_statementList != null && !_statementList.isEmpty())
        { sb.append(dm).append("statementList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Category clone() {
        return (Category)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (カテゴリーID)CATEGORY_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @return The value of the column 'CATEGORY_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getCategoryId() {
        checkSpecifiedProperty("categoryId");
        return _categoryId;
    }

    /**
     * [set] (カテゴリーID)CATEGORY_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @param categoryId The value of the column 'CATEGORY_ID'. (basically NotNull if update: for the constraint)
     */
    public void setCategoryId(Long categoryId) {
        registerModifiedProperty("categoryId");
        _categoryId = categoryId;
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
     * [get] (カテゴリタイプ)CATEGORY_TYPE: {NotNull, VARCHAR(10)} <br>
     * @return The value of the column 'CATEGORY_TYPE'. (basically NotNull if selected: for the constraint)
     */
    public String getCategoryType() {
        checkSpecifiedProperty("categoryType");
        return convertEmptyToNull(_categoryType);
    }

    /**
     * [set] (カテゴリタイプ)CATEGORY_TYPE: {NotNull, VARCHAR(10)} <br>
     * @param categoryType The value of the column 'CATEGORY_TYPE'. (basically NotNull if update: for the constraint)
     */
    public void setCategoryType(String categoryType) {
        registerModifiedProperty("categoryType");
        _categoryType = categoryType;
    }

    /**
     * [get] (カテゴリー)CATEGORY: {NotNull, VARCHAR(200)} <br>
     * @return The value of the column 'CATEGORY'. (basically NotNull if selected: for the constraint)
     */
    public String getCategory() {
        checkSpecifiedProperty("category");
        return convertEmptyToNull(_category);
    }

    /**
     * [set] (カテゴリー)CATEGORY: {NotNull, VARCHAR(200)} <br>
     * @param category The value of the column 'CATEGORY'. (basically NotNull if update: for the constraint)
     */
    public void setCategory(String category) {
        registerModifiedProperty("category");
        _category = category;
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
}
