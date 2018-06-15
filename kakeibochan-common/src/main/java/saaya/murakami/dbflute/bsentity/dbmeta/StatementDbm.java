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
package saaya.murakami.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import saaya.murakami.dbflute.allcommon.*;
import saaya.murakami.dbflute.exentity.*;

/**
 * The DB meta of STATEMENT. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class StatementDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final StatementDbm _instance = new StatementDbm();
    private StatementDbm() {}
    public static StatementDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((Statement)et).getStatementId(), (et, vl) -> ((Statement)et).setStatementId(ctl(vl)), "statementId");
        setupEpg(_epgMap, et -> ((Statement)et).getUserId(), (et, vl) -> ((Statement)et).setUserId(ctl(vl)), "userId");
        setupEpg(_epgMap, et -> ((Statement)et).getCategoryId(), (et, vl) -> ((Statement)et).setCategoryId(ctl(vl)), "categoryId");
        setupEpg(_epgMap, et -> ((Statement)et).getAccountId(), (et, vl) -> ((Statement)et).setAccountId(ctl(vl)), "accountId");
        setupEpg(_epgMap, et -> ((Statement)et).getStatementType(), (et, vl) -> ((Statement)et).setStatementType((String)vl), "statementType");
        setupEpg(_epgMap, et -> ((Statement)et).getDate(), (et, vl) -> ((Statement)et).setDate(ctld(vl)), "date");
        setupEpg(_epgMap, et -> ((Statement)et).getAmount(), (et, vl) -> ((Statement)et).setAmount(cti(vl)), "amount");
        setupEpg(_epgMap, et -> ((Statement)et).getMemo(), (et, vl) -> ((Statement)et).setMemo((String)vl), "memo");
        setupEpg(_epgMap, et -> ((Statement)et).getRegisterDatetime(), (et, vl) -> ((Statement)et).setRegisterDatetime(ctldt(vl)), "registerDatetime");
        setupEpg(_epgMap, et -> ((Statement)et).getRegisterUser(), (et, vl) -> ((Statement)et).setRegisterUser((String)vl), "registerUser");
        setupEpg(_epgMap, et -> ((Statement)et).getUpdateDatetime(), (et, vl) -> ((Statement)et).setUpdateDatetime(ctldt(vl)), "updateDatetime");
        setupEpg(_epgMap, et -> ((Statement)et).getUpdateUser(), (et, vl) -> ((Statement)et).setUpdateUser((String)vl), "updateUser");
        setupEpg(_epgMap, et -> ((Statement)et).getVersionNo(), (et, vl) -> ((Statement)et).setVersionNo(ctl(vl)), "versionNo");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((Statement)et).getAccount(), (et, vl) -> ((Statement)et).setAccount((OptionalEntity<Account>)vl), "account");
        setupEfpg(_efpgMap, et -> ((Statement)et).getCategory(), (et, vl) -> ((Statement)et).setCategory((OptionalEntity<Category>)vl), "category");
        setupEfpg(_efpgMap, et -> ((Statement)et).getMember(), (et, vl) -> ((Statement)et).setMember((OptionalEntity<Member>)vl), "member");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "STATEMENT";
    protected final String _tableDispName = "STATEMENT";
    protected final String _tablePropertyName = "statement";
    protected final TableSqlName _tableSqlName = new TableSqlName("STATEMENT", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "明細";
    public String getTableAlias() { return _tableAlias; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnStatementId = cci("STATEMENT_ID", "STATEMENT_ID", null, "明細ID", Long.class, "statementId", null, true, true, true, "BIGINT", 19, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUserId = cci("USER_ID", "USER_ID", null, "会員ID", Long.class, "userId", null, false, false, true, "BIGINT", 19, 0, null, null, false, null, null, "member", null, null, false);
    protected final ColumnInfo _columnCategoryId = cci("CATEGORY_ID", "CATEGORY_ID", null, "カテゴリーID", Long.class, "categoryId", null, false, false, true, "BIGINT", 19, 0, null, null, false, null, null, "category", null, null, false);
    protected final ColumnInfo _columnAccountId = cci("ACCOUNT_ID", "ACCOUNT_ID", null, "アカウントID", Long.class, "accountId", null, false, false, true, "BIGINT", 19, 0, null, null, false, null, null, "account", null, null, false);
    protected final ColumnInfo _columnStatementType = cci("STATEMENT_TYPE", "STATEMENT_TYPE", null, "STATEMENT_TYPE", String.class, "statementType", null, false, false, true, "VARCHAR", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDate = cci("DATE", "DATE", null, "日付", java.time.LocalDate.class, "date", null, false, false, true, "DATE", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnAmount = cci("AMOUNT", "AMOUNT", null, "金額", Integer.class, "amount", null, false, false, true, "INT", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnMemo = cci("MEMO", "MEMO", null, "メモ", String.class, "memo", null, false, false, false, "VARCHAR", 200, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, "登録日時", java.time.LocalDateTime.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, "登録ユーザー", String.class, "registerUser", null, false, false, true, "VARCHAR", 200, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, "更新日時", java.time.LocalDateTime.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, "更新ユーザー", String.class, "updateUser", null, false, false, true, "VARCHAR", 200, 0, null, null, true, null, null, null, null, null, false);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, "バージョン番号", Long.class, "versionNo", null, false, false, true, "BIGINT", 19, 0, null, null, false, OptimisticLockType.VERSION_NO, null, null, null, null, false);

    /**
     * (明細ID)STATEMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnStatementId() { return _columnStatementId; }
    /**
     * (会員ID)USER_ID: {IX, NotNull, BIGINT(19), FK to MEMBER}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUserId() { return _columnUserId; }
    /**
     * (カテゴリーID)CATEGORY_ID: {IX, NotNull, BIGINT(19), FK to CATEGORY}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCategoryId() { return _columnCategoryId; }
    /**
     * (アカウントID)ACCOUNT_ID: {IX, NotNull, BIGINT(19), FK to ACCOUNT}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAccountId() { return _columnAccountId; }
    /**
     * (STATEMENT_TYPE)STATEMENT_TYPE: {NotNull, VARCHAR(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnStatementType() { return _columnStatementType; }
    /**
     * (日付)DATE: {NotNull, DATE(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDate() { return _columnDate; }
    /**
     * (金額)AMOUNT: {NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAmount() { return _columnAmount; }
    /**
     * (メモ)MEMO: {VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemo() { return _columnMemo; }
    /**
     * (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    /**
     * (登録ユーザー)REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    /**
     * (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    /**
     * (更新ユーザー)UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }
    /**
     * (バージョン番号)VERSION_NO: {NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnStatementId());
        ls.add(columnUserId());
        ls.add(columnCategoryId());
        ls.add(columnAccountId());
        ls.add(columnStatementType());
        ls.add(columnDate());
        ls.add(columnAmount());
        ls.add(columnMemo());
        ls.add(columnRegisterDatetime());
        ls.add(columnRegisterUser());
        ls.add(columnUpdateDatetime());
        ls.add(columnUpdateUser());
        ls.add(columnVersionNo());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnStatementId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * (アカウント)ACCOUNT by my ACCOUNT_ID, named 'account'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignAccount() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnAccountId(), AccountDbm.getInstance().columnAccountId());
        return cfi("statement_ibfk_1", "account", this, AccountDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "statementList", false);
    }
    /**
     * (カテゴリー)CATEGORY by my CATEGORY_ID, named 'category'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignCategory() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCategoryId(), CategoryDbm.getInstance().columnCategoryId());
        return cfi("statement_ibfk_2", "category", this, CategoryDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "statementList", false);
    }
    /**
     * (会員)MEMBER by my USER_ID, named 'member'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMember() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnUserId(), MemberDbm.getInstance().columnUserId());
        return cfi("statement_ibfk_3", "member", this, MemberDbm.getInstance(), mp, 2, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "statementList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }
    public boolean hasVersionNo() { return true; }
    public ColumnInfo getVersionNoColumnInfo() { return _columnVersionNo; }
    public boolean hasCommonColumn() { return true; }
    public List<ColumnInfo> getCommonColumnInfoList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnUpdateDatetime(), columnUpdateUser()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeInsertList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnUpdateDatetime(), columnUpdateUser()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeUpdateList()
    { return newArrayList(columnUpdateDatetime(), columnUpdateUser()); }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "saaya.murakami.dbflute.exentity.Statement"; }
    public String getConditionBeanTypeName() { return "saaya.murakami.dbflute.cbean.StatementCB"; }
    public String getBehaviorTypeName() { return "saaya.murakami.dbflute.exbhv.StatementBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Statement> getEntityType() { return Statement.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Statement newEntity() { return new Statement(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Statement)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Statement)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
