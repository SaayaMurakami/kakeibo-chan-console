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

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import saaya.murakami.dbflute.allcommon.EntityDefinedCommonColumn;
import saaya.murakami.dbflute.allcommon.DBMetaInstanceHandler;
import saaya.murakami.dbflute.exentity.*;

/**
 * The entity of (会員)MEMBER as TABLE. <br>
 * <pre>
 * [primary-key]
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
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long userId = entity.getUserId();
 * String mailAddress = entity.getMailAddress();
 * String userName = entity.getUserName();
 * String password = entity.getPassword();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setUserId(userId);
 * entity.setMailAddress(mailAddress);
 * entity.setUserName(userName);
 * entity.setPassword(password);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMember extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** (会員ID)USER_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _userId;

    /** (メールアドレス)MAIL_ADDRESS: {UQ, NotNull, VARCHAR(200)} */
    protected String _mailAddress;

    /** (名前)USER_NAME: {NotNull, VARCHAR(200)} */
    protected String _userName;

    /** (パスワード)PASSWORD: {NotNull, VARCHAR(200)} */
    protected String _password;

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
        return "MEMBER";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_userId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param mailAddress (メールアドレス): UQ, NotNull, VARCHAR(200). (NotNull)
     */
    public void uniqueBy(String mailAddress) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("mailAddress");
        setMailAddress(mailAddress);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** (アカウント)ACCOUNT by USER_ID, named 'accountList'. */
    protected List<Account> _accountList;

    /**
     * [get] (アカウント)ACCOUNT by USER_ID, named 'accountList'.
     * @return The entity list of referrer property 'accountList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Account> getAccountList() {
        if (_accountList == null) { _accountList = newReferrerList(); }
        return _accountList;
    }

    /**
     * [set] (アカウント)ACCOUNT by USER_ID, named 'accountList'.
     * @param accountList The entity list of referrer property 'accountList'. (NullAllowed)
     */
    public void setAccountList(List<Account> accountList) {
        _accountList = accountList;
    }

    /** (カテゴリー)CATEGORY by USER_ID, named 'categoryList'. */
    protected List<Category> _categoryList;

    /**
     * [get] (カテゴリー)CATEGORY by USER_ID, named 'categoryList'.
     * @return The entity list of referrer property 'categoryList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Category> getCategoryList() {
        if (_categoryList == null) { _categoryList = newReferrerList(); }
        return _categoryList;
    }

    /**
     * [set] (カテゴリー)CATEGORY by USER_ID, named 'categoryList'.
     * @param categoryList The entity list of referrer property 'categoryList'. (NullAllowed)
     */
    public void setCategoryList(List<Category> categoryList) {
        _categoryList = categoryList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsMember) {
            BsMember other = (BsMember)obj;
            if (!xSV(_userId, other._userId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _userId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_accountList != null) { for (Account et : _accountList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "accountList")); } } }
        if (_categoryList != null) { for (Category et : _categoryList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "categoryList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_userId));
        sb.append(dm).append(xfND(_mailAddress));
        sb.append(dm).append(xfND(_userName));
        sb.append(dm).append(xfND(_password));
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
        if (_accountList != null && !_accountList.isEmpty())
        { sb.append(dm).append("accountList"); }
        if (_categoryList != null && !_categoryList.isEmpty())
        { sb.append(dm).append("categoryList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Member clone() {
        return (Member)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ID)USER_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @return The value of the column 'USER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getUserId() {
        checkSpecifiedProperty("userId");
        return _userId;
    }

    /**
     * [set] (会員ID)USER_ID: {PK, ID, NotNull, BIGINT(19)} <br>
     * @param userId The value of the column 'USER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setUserId(Long userId) {
        registerModifiedProperty("userId");
        _userId = userId;
    }

    /**
     * [get] (メールアドレス)MAIL_ADDRESS: {UQ, NotNull, VARCHAR(200)} <br>
     * @return The value of the column 'MAIL_ADDRESS'. (basically NotNull if selected: for the constraint)
     */
    public String getMailAddress() {
        checkSpecifiedProperty("mailAddress");
        return convertEmptyToNull(_mailAddress);
    }

    /**
     * [set] (メールアドレス)MAIL_ADDRESS: {UQ, NotNull, VARCHAR(200)} <br>
     * @param mailAddress The value of the column 'MAIL_ADDRESS'. (basically NotNull if update: for the constraint)
     */
    public void setMailAddress(String mailAddress) {
        registerModifiedProperty("mailAddress");
        _mailAddress = mailAddress;
    }

    /**
     * [get] (名前)USER_NAME: {NotNull, VARCHAR(200)} <br>
     * @return The value of the column 'USER_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getUserName() {
        checkSpecifiedProperty("userName");
        return convertEmptyToNull(_userName);
    }

    /**
     * [set] (名前)USER_NAME: {NotNull, VARCHAR(200)} <br>
     * @param userName The value of the column 'USER_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setUserName(String userName) {
        registerModifiedProperty("userName");
        _userName = userName;
    }

    /**
     * [get] (パスワード)PASSWORD: {NotNull, VARCHAR(200)} <br>
     * @return The value of the column 'PASSWORD'. (basically NotNull if selected: for the constraint)
     */
    public String getPassword() {
        checkSpecifiedProperty("password");
        return convertEmptyToNull(_password);
    }

    /**
     * [set] (パスワード)PASSWORD: {NotNull, VARCHAR(200)} <br>
     * @param password The value of the column 'PASSWORD'. (basically NotNull if update: for the constraint)
     */
    public void setPassword(String password) {
        registerModifiedProperty("password");
        _password = password;
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
