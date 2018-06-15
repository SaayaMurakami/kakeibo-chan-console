/* Drop Tables */

DROP TABLE IF EXISTS STATEMENT;
DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS MEMBER;




/* Create Tables */

-- アカウント
CREATE TABLE ACCOUNT
(
	ACCOUNT_ID bigint NOT NULL AUTO_INCREMENT COMMENT 'アカウントID',
	USER_ID bigint NOT NULL COMMENT '会員ID',
	ACCOUNT_NAME varchar(200) NOT NULL COMMENT 'アカウント名',
	REGISTER_DATETIME datetime NOT NULL COMMENT '登録日時',
	REGISTER_USER varchar(200) NOT NULL COMMENT '登録ユーザー',
	UPDATE_DATETIME datetime NOT NULL COMMENT '更新日時',
	UPDATE_USER varchar(200) NOT NULL COMMENT '更新ユーザー',
	VERSION_NO bigint NOT NULL COMMENT 'バージョン番号',
	PRIMARY KEY (ACCOUNT_ID),
	UNIQUE (ACCOUNT_ID)
) COMMENT = 'アカウント';


-- カテゴリー
CREATE TABLE CATEGORY
(
	CATEGORY_ID bigint NOT NULL AUTO_INCREMENT COMMENT 'カテゴリーID ',
	USER_ID bigint NOT NULL COMMENT '会員ID',
	CATEGORY varchar(200) NOT NULL COMMENT 'カテゴリー',
	REGISTER_DATETIME datetime NOT NULL COMMENT '登録日時',
	REGISTER_USER varchar(200) NOT NULL COMMENT '登録ユーザー',
	UPDATE_DATETIME datetime NOT NULL COMMENT '更新日時',
	UPDATE_USER varchar(200) NOT NULL COMMENT '更新ユーザー',
	VERSION_NO bigint NOT NULL COMMENT 'バージョン番号',
	PRIMARY KEY (CATEGORY_ID),
	UNIQUE (CATEGORY_ID)
) COMMENT = 'カテゴリー';


-- 会員
CREATE TABLE MEMBER
(
	USER_ID bigint NOT NULL AUTO_INCREMENT COMMENT '会員ID',
	MAIL_ADDRESS varchar(200) NOT NULL COMMENT 'メールアドレス',
	USER_NAME varchar(200) NOT NULL COMMENT '名前',
	PASSWORD varchar(200) NOT NULL COMMENT 'パスワード',
	REGISTER_DATETIME datetime NOT NULL COMMENT '登録日時',
	REGISTER_USER varchar(200) NOT NULL COMMENT '登録ユーザー',
	UPDATE_DATETIME datetime NOT NULL COMMENT '更新日時',
	UPDATE_USER varchar(200) NOT NULL COMMENT '更新ユーザー',
	VERSION_NO bigint NOT NULL COMMENT 'バージョン番号',
	PRIMARY KEY (USER_ID),
	UNIQUE (USER_ID),
	UNIQUE (MAIL_ADDRESS)
) COMMENT = '会員';


-- 明細
CREATE TABLE STATEMENT
(
	STATEMENT_ID bigint NOT NULL AUTO_INCREMENT COMMENT '明細ID',
	USER_ID bigint NOT NULL COMMENT '会員ID',
	CATEGORY_ID bigint NOT NULL COMMENT 'カテゴリーID ',
	ACCOUNT_ID bigint NOT NULL COMMENT 'アカウントID',
	STATEMENT_TYPE varchar(10) NOT NULL COMMENT 'STATEMENT_TYPE',
	DATE date NOT NULL COMMENT '日付',
	AMOUNT int NOT NULL COMMENT '金額',
	-- 支出内容の補足説明
	MEMO varchar(200) COMMENT 'メモ : 支出内容の補足説明',
	REGISTER_DATETIME datetime NOT NULL COMMENT '登録日時',
	REGISTER_USER varchar(200) NOT NULL COMMENT '登録ユーザー',
	UPDATE_DATETIME datetime NOT NULL COMMENT '更新日時',
	UPDATE_USER varchar(200) NOT NULL COMMENT '更新ユーザー',
	VERSION_NO bigint NOT NULL COMMENT 'バージョン番号',
	PRIMARY KEY (STATEMENT_ID),
	UNIQUE (STATEMENT_ID)
) COMMENT = '明細';



/* Create Foreign Keys */

ALTER TABLE STATEMENT
	ADD FOREIGN KEY (ACCOUNT_ID)
	REFERENCES ACCOUNT (ACCOUNT_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE STATEMENT
	ADD FOREIGN KEY (CATEGORY_ID)
	REFERENCES CATEGORY (CATEGORY_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ACCOUNT
	ADD FOREIGN KEY (USER_ID)
	REFERENCES MEMBER (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE CATEGORY
	ADD FOREIGN KEY (USER_ID)
	REFERENCES MEMBER (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE STATEMENT
	ADD FOREIGN KEY (USER_ID)
	REFERENCES MEMBER (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



