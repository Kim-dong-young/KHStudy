-- SELECT * FROM USER_CONSTRAINTS;

DROP TABLE TB_SHARE;
DROP TABLE TB_COMMENT;
DROP TABLE TB_BULLETIN;
DROP TABLE TB_MEMBER_ITEM;
DROP TABLE TB_ITEM;
DROP TABLE TB_TRADELOG;
DROP TABLE TB_MEMBER;
DROP TABLE TB_MEMBER_RANK;
DROP TABLE TB_STOCK;

--================== 테이블 생성  ======================
CREATE TABLE "TB_MEMBER" (
  "MEMBER_UID" NUMBER CONSTRAINT TB_MEMBER_PK PRIMARY KEY,
  "MEMBER_NAME" VARCHAR2(30),
  "MEMBER_ID" VARCHAR2(20) CONSTRAINT MEMBER_ID_UQ UNIQUE CONSTRAINT MEMBER_ID_NN NOT NULL,
  "MEMBER_PWD" VARCHAR2(30) CONSTRAINT MEMBER_PWD_NN NULL,
  "MEMBER_RCODE" VARCHAR2(5) DEFAULT 'M1',
  "ENROLL_DATE" DATE DEFAULT SYSDATE,
  "WITHDRAW_YN" CHAR(1) DEFAULT 'N' CONSTRAINT WITHDRAW_YN_CK CHECK(WITHDRAW_YN IN ('Y','N')) 
);

COMMENT ON COLUMN TB_MEMBER.MEMBER_UID IS '멤버UID(시퀀스)';
COMMENT ON COLUMN TB_MEMBER.MEMBER_NAME IS '멤버 이름';
COMMENT ON COLUMN TB_MEMBER.MEMBER_ID IS '멤버 아이디';
COMMENT ON COLUMN TB_MEMBER.MEMBER_PWD IS '멤버 비밀번호';
COMMENT ON COLUMN TB_MEMBER.MEMBER_RCODE IS '멤버 등급번호';
COMMENT ON COLUMN TB_MEMBER.ENROLL_DATE IS '멤버 가입일';
COMMENT ON COLUMN TB_MEMBER.WITHDRAW_YN IS '멤버 탈퇴여부';

CREATE TABLE "TB_MEMBER_RANK" (
  "MEMBER_RCODE" VARCHAR2(5) CONSTRAINT TB_MEMBER_RANK_PK PRIMARY KEY,
  "MEMBER_RNAME" VARCHAR2(30)
);

COMMENT ON COLUMN TB_MEMBER_RANK.MEMBER_RCODE IS '멤버 등급번호';
COMMENT ON COLUMN TB_MEMBER_RANK.MEMBER_RNAME IS '멤버 등급이름';

CREATE TABLE "TB_STOCK" (
  "STOCK_ID" NUMBER CONSTRAINT TB_STOCK_PK PRIMARY KEY,
  "STOCK_NAME" VARCHAR2(50),
  "DELIST_YN" CHAR(1) DEFAULT 'N' CONSTRAINT DELIST_YN_CK CHECK(DELIST_YN IN('Y','N'))
);

COMMENT ON COLUMN TB_STOCK.STOCK_ID IS '주식 번호(시퀀스)';
COMMENT ON COLUMN TB_STOCK.STOCK_NAME IS '주식 이름';

CREATE TABLE "TB_SHARE" (
  "MEMBER_UID" NUMBER,
  "STOCK_ID" NUMBER,
  "SHARE_QTY" NUMBER DEFAULT 0,
  "PURCHASE_PRICE" NUMBER DEFAULT 0,
  "SHARE_FLUCT" NUMBER DEFAULT 0,
  CONSTRAINT TB_SHARE_PK PRIMARY KEY ("MEMBER_UID", "STOCK_ID")
);

COMMENT ON COLUMN TB_SHARE.MEMBER_UID IS '멤버UID(시퀀스)';
COMMENT ON COLUMN TB_SHARE.STOCK_ID IS '주식 번호(시퀀스)';
COMMENT ON COLUMN TB_SHARE.SHARE_QTY IS '주식 보유량';
COMMENT ON COLUMN TB_SHARE.PURCHASE_PRICE IS '주식 매입가';
COMMENT ON COLUMN TB_SHARE.SHARE_FLUCT IS '주식 변동률(다음날)';

CREATE TABLE "TB_TRADELOG" (
  "TRADE_ID" NUMBER CONSTRAINT TB_TRADELOG_PK PRIMARY KEY,
  "MEMBER_UID" NUMBER,
  "TRADE_DATE" DATE DEFAULT SYSDATE,
  "STOCK_ID" NUMBER,
  "TRADE_QTY" NUMBER CONSTRAINT TRADE_QTY_NN NOT NULL,
  "TRADE_PRICE" NUMBER CONSTRAINT TRADE_PRICE_NN NOT NULL,
  "TRADE_STATUS" VARCHAR2(9) CONSTRAINT TRADE_STATUS NOT NULL
);

COMMENT ON COLUMN TB_TRADELOG.TRADE_ID IS '거래 번호(시퀀스)';
COMMENT ON COLUMN TB_TRADELOG.MEMBER_UID IS '멤버UID(시퀀스)';
COMMENT ON COLUMN TB_TRADELOG.TRADE_DATE IS '거래 일자';
COMMENT ON COLUMN TB_TRADELOG.STOCK_ID IS '주식 이름';
COMMENT ON COLUMN TB_TRADELOG.TRADE_QTY IS '거래 수량';
COMMENT ON COLUMN TB_TRADELOG.TRADE_PRICE IS '거래 가격';
COMMENT ON COLUMN TB_TRADELOG.TRADE_STATUS IS '상태(판매/구매)';

CREATE TABLE "TB_BULLETIN" (
  "BULLETIN_ID" NUMBER CONSTRAINT TB_BULLETIN_PK PRIMARY KEY,
  "BULLETIN_VCOUNT" NUMBER DEFAULT 0,
  "BULLETIN_WRT_DATE" DATE DEFAULT SYSDATE,
  "MEMBER_UID" NUMBER,
  "BULLETIN_TITLE" VARCHAR2(90),
  "BULLETIN_CONTENT" VARCHAR2(1500),
  "BULLETIN_DLT_YN" CHAR(1) DEFAULT 'N' CONSTRAINT BULLETIN_DLT_YN_CK CHECK( BULLETIN_DLT_YN IN ('Y','N') )
);

COMMENT ON COLUMN TB_BULLETIN.BULLETIN_ID IS '게시글 번호(시퀀스)';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_VCOUNT IS '게시글 조회수';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_WRT_DATE IS '게시글 작성일자';
COMMENT ON COLUMN TB_BULLETIN.MEMBER_UID IS '멤버UID(시퀀스)';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_TITLE IS '게시글 제목';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_CONTENT IS '게시글 내용';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_DLT_YN IS '게시글 삭제여부(Y/N)';

CREATE TABLE "TB_COMMENT" (
  "BULLETIN_ID" NUMBER,
  "COMMENT_ID" NUMBER,
  "COMMENT_WRT_DATE" DATE DEFAULT SYSDATE,
  "MEMBER_UID" NUMBER,
  "COMMENT_CONTENT" VARCHAR2(300),
  "COMMENT_DLT_YN" CHAR(1) DEFAULT 'N' CONSTRAINT COMMENT_DLT_YN_CK CHECK( COMMENT_DLT_YN IN ('Y','N') ),
  CONSTRAINT TB_COMMENT_PK PRIMARY KEY("BULLETIN_ID","COMMENT_ID")
);

COMMENT ON COLUMN TB_COMMENT.BULLETIN_ID IS '게시글 번호(시퀀스)';
COMMENT ON COLUMN TB_COMMENT.COMMENT_ID IS '댓글 번호';
COMMENT ON COLUMN TB_COMMENT.COMMENT_WRT_DATE IS '댓글 작성일자';
COMMENT ON COLUMN TB_COMMENT.MEMBER_UID IS '멤버UID(시퀀스)';
COMMENT ON COLUMN TB_COMMENT.COMMENT_CONTENT IS '댓글 내용';
COMMENT ON COLUMN TB_COMMENT.COMMENT_DLT_YN IS '댓글 삭제여부(Y/N)';

CREATE TABLE "TB_ITEM" (
  "ITEM_ID" NUMBER CONSTRAINT TB_ITEM_PK PRIMARY KEY,
  "ITEM_NAME" VARCHAR2(30),
  "ITEM_PRICE" NUMBER DEFAULT 0,
  "ITEM_DESC" VARCHAR2(600)
);

COMMENT ON COLUMN TB_ITEM.ITEM_ID IS '아이템 번호(시퀀스)';
COMMENT ON COLUMN TB_ITEM.ITEM_NAME IS '아이템 이름';
COMMENT ON COLUMN TB_ITEM.ITEM_PRICE IS '아이템 가격';
COMMENT ON COLUMN TB_ITEM.ITEM_DESC IS '아이템 설명';

CREATE TABLE "TB_MEMBER_ITEM" (
  "MEMBER_UID" NUMBER,
  "ITEM_ID" NUMBER,
  "ITEM_QTY" NUMBER DEFAULT 0,
  CONSTRAINT TB_MEMBER_ITEM_PK PRIMARY KEY ("MEMBER_UID", "ITEM_ID")
);

COMMENT ON COLUMN TB_MEMBER_ITEM.MEMBER_UID IS '멤버UID(시퀀스)';
COMMENT ON COLUMN TB_MEMBER_ITEM.ITEM_ID IS '아이템 번호(시퀀스)';
COMMENT ON COLUMN TB_MEMBER_ITEM.ITEM_QTY IS '아이템 보유수량';

-- ==================== 외래키 설정 =======================

ALTER TABLE "TB_MEMBER" ADD CONSTRAINT MEMBER_RCODE_FK 
FOREIGN KEY ("MEMBER_RCODE") REFERENCES "TB_MEMBER_RANK" ("MEMBER_RCODE");

ALTER TABLE "TB_SHARE" ADD CONSTRAINT TB_SHARE_MEMBER_UID_FK 
FOREIGN KEY ("MEMBER_UID") REFERENCES "TB_MEMBER" ("MEMBER_UID")
ON DELETE CASCADE;

ALTER TABLE "TB_SHARE" ADD CONSTRAINT TB_SHARE_STOCK_ID_FK 
FOREIGN KEY ("STOCK_ID") REFERENCES "TB_STOCK" ("STOCK_ID")
ON DELETE CASCADE;

ALTER TABLE "TB_TRADELOG" ADD CONSTRAINT TB_TRADELOG_MEMBER_UID_FK 
FOREIGN KEY ("MEMBER_UID") REFERENCES "TB_MEMBER" ("MEMBER_UID")
ON DELETE CASCADE;

ALTER TABLE "TB_TRADELOG" ADD CONSTRAINT TB_TRADELOG_STOCK_ID_FK 
FOREIGN KEY ("STOCK_ID") REFERENCES "TB_STOCK" ("STOCK_ID")
ON DELETE CASCADE;

ALTER TABLE "TB_BULLETIN" ADD CONSTRAINT TB_BULLETIN_MEMBER_UID_FK 
FOREIGN KEY ("MEMBER_UID") REFERENCES "TB_MEMBER" ("MEMBER_UID")
ON DELETE CASCADE;

ALTER TABLE "TB_COMMENT" ADD CONSTRAINT TB_COMMENT_BULLETIN_ID_FK 
FOREIGN KEY ("BULLETIN_ID") REFERENCES "TB_BULLETIN" ("BULLETIN_ID")
ON DELETE CASCADE;

ALTER TABLE "TB_COMMENT" ADD CONSTRAINT TB_COMMENT_MEMBER_UID_FK 
FOREIGN KEY ("MEMBER_UID") REFERENCES "TB_MEMBER" ("MEMBER_UID")
ON DELETE CASCADE;

ALTER TABLE "TB_MEMBER_ITEM" ADD CONSTRAINT TB_MEMBER_ITEM_ITEM_ID_FK 
FOREIGN KEY ("ITEM_ID") REFERENCES "TB_ITEM" ("ITEM_ID")
ON DELETE CASCADE;

ALTER TABLE "TB_MEMBER_ITEM" ADD CONSTRAINT TB_MEMBER_ITEM_MEMBER_UID_FK 
FOREIGN KEY ("MEMBER_UID") REFERENCES "TB_MEMBER" ("MEMBER_UID")
ON DELETE CASCADE;

-- ================ 시퀀스 설정 ====================

DROP SEQUENCE MEMBER_UID_SEQ;
DROP SEQUENCE STOCK_ID_SEQ;
DROP SEQUENCE TRADE_ID_SEQ;
DROP SEQUENCE BULLETIN_ID_SEQ;
DROP SEQUENCE ITEM_ID_SEQ;

CREATE SEQUENCE MEMBER_UID_SEQ;
CREATE SEQUENCE STOCK_ID_SEQ;
CREATE SEQUENCE TRADE_ID_SEQ;
CREATE SEQUENCE BULLETIN_ID_SEQ;
CREATE SEQUENCE ITEM_ID_SEQ;
-- 댓글 SEQ는 트리거로 각 게시글마다 별도로 설정해준다

-- ================ 트리거 설정 ====================

-- 게시글 별 댓글 시퀀스 설정
CREATE OR REPLACE TRIGGER COMMENT_ID_TRG
BEFORE INSERT ON TB_COMMENT
FOR EACH ROW
DECLARE 
    SEQ_NUM NUMBER;
BEGIN
    SELECT NVL(MAX(COMMENT_ID),0) + 1 
    INTO SEQ_NUM
    FROM TB_COMMENT
    WHERE "BULLETIN_ID" = :NEW.BULLETIN_ID;
    
    :NEW.COMMENT_ID := SEQ_NUM;
END;
/

-- SET DEFAULT MEMBER_RCODE
CREATE OR REPLACE TRIGGER MEMBER_RANK_DEFAULT_TRG
BEFORE DELETE ON TB_MEMBER_RANK
FOR EACH ROW
BEGIN
    UPDATE TB_MEMBER
    SET MEMBER_RCODE = 'M1'
    WHERE MEMBER_RCODE = :OLD.MEMBER_RCODE;
END;
/


-- =============== 데이터 삽입 ===================

INSERT INTO TB_STOCK(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'LG전자');
INSERT INTO TB_STOCK(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'삼성전자');
INSERT INTO TB_STOCK(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'롯데케미칼');
INSERT INTO TB_STOCK(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'현대모비스');
INSERT INTO TB_STOCK(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'KB금융');


