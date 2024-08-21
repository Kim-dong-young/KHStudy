DROP TABLE TB_SHARE;
DROP TABLE TB_COMMENT;
DROP TABLE TB_BULLETIN;
DROP TABLE TB_MEMBER_ITEM;
DROP TABLE TB_ITEM;
DROP TABLE TB_TRADELOG;
DROP TABLE TB_MEMBER_STOCK;
DROP TABLE TB_MEMBER;
DROP TABLE TB_MEMBER_RANK;
DROP TABLE TB_STOCK_LIST;

--================== ���̺� ����  ======================
CREATE TABLE "TB_MEMBER" (
  "MEMBER_UID" NUMBER CONSTRAINT TB_MEMBER_PK PRIMARY KEY,
  "MEMBER_NAME" VARCHAR2(30),
  "MEMBER_ID" VARCHAR2(20) CONSTRAINT MEMBER_ID_UQ UNIQUE CONSTRAINT MEMBER_ID_NN NOT NULL,
  "MEMBER_PWD" VARCHAR2(30) CONSTRAINT MEMBER_PWD_NN NULL,
  "MEMBER_RCODE" VARCHAR2(5) DEFAULT 'M1',
  "ENROLL_DATE" DATE DEFAULT SYSDATE,
  "WITHDRAW_YN" CHAR(1) DEFAULT 'N' CONSTRAINT WITHDRAW_YN_CK CHECK(WITHDRAW_YN IN ('Y','N')),
  "PLAY_DAY" NUMBER DEFAULT 0,
  "BALANCE" NUMBER DEFAULT 1000000
);

COMMENT ON COLUMN TB_MEMBER.MEMBER_UID IS '���UID(������)';
COMMENT ON COLUMN TB_MEMBER.MEMBER_NAME IS '��� �̸�';
COMMENT ON COLUMN TB_MEMBER.MEMBER_ID IS '��� ���̵�';
COMMENT ON COLUMN TB_MEMBER.MEMBER_PWD IS '��� ��й�ȣ';
COMMENT ON COLUMN TB_MEMBER.MEMBER_RCODE IS '��� ��޹�ȣ';
COMMENT ON COLUMN TB_MEMBER.ENROLL_DATE IS '��� ������';
COMMENT ON COLUMN TB_MEMBER.WITHDRAW_YN IS '��� Ż�𿩺�';
COMMENT ON COLUMN TB_MEMBER.PLAY_DAY IS '���� �� ��¥';
COMMENT ON COLUMN TB_MEMBER.BALANCE IS '��� ���(����)';

CREATE TABLE "TB_MEMBER_RANK" (
  "MEMBER_RCODE" VARCHAR2(5) CONSTRAINT TB_MEMBER_RANK_PK PRIMARY KEY,
  "MEMBER_RNAME" VARCHAR2(30)
);

COMMENT ON COLUMN TB_MEMBER_RANK.MEMBER_RCODE IS '��� ��޹�ȣ';
COMMENT ON COLUMN TB_MEMBER_RANK.MEMBER_RNAME IS '��� ����̸�';

CREATE TABLE "TB_STOCK_LIST" (
  "STOCK_ID" NUMBER CONSTRAINT TB_STOCK_LIST_PK PRIMARY KEY,
  "STOCK_NAME" VARCHAR2(50) CONSTRAINT STOCK_NAME_UQ UNIQUE,
  "DELIST_YN" CHAR(1) DEFAULT 'N' CONSTRAINT DELIST_YN_CK CHECK(DELIST_YN IN('Y','N'))
);

COMMENT ON COLUMN TB_STOCK_LIST.STOCK_ID IS '�ֽ� ��ȣ(������)';
COMMENT ON COLUMN TB_STOCK_LIST.STOCK_NAME IS '�ֽ� �̸�';

-- �����ֽ� "����"����, �ֽİ����� ������� �������� �ʴ´�.
CREATE TABLE "TB_MEMBER_STOCK"(
    "STOCK_ID" NUMBER,
    "MEMBER_UID" NUMBER,
    "MAX_QTY" NUMBER DEFAULT 0,
    "STOCK_QTY" NUMBER DEFAULT 0,
    "STOCK_PRICE" NUMBER DEFAULT 0,
    "NEXT_FLUCT" NUMBER DEFAULT 0,
    CONSTRAINT TB_MEMBER_STOCK_PK PRIMARY KEY(STOCK_ID, MEMBER_UID)
);

COMMENT ON COLUMN TB_MEMBER_STOCK.STOCK_ID IS '�ֽ� ��ȣ(������)';
COMMENT ON COLUMN TB_MEMBER_STOCK.MAX_QTY IS '�ֽ� �ִ� ����';
COMMENT ON COLUMN TB_MEMBER_STOCK.STOCK_QTY IS '���忡 ���� ���� �ֽ� ����';
COMMENT ON COLUMN TB_MEMBER_STOCK.STOCK_PRICE IS '�ֽ� ����';
COMMENT ON COLUMN TB_MEMBER_STOCK.NEXT_FLUCT IS '������ ���� ������';

CREATE TABLE "TB_SHARE" (
  "MEMBER_UID" NUMBER,
  "STOCK_ID" NUMBER,
  "SHARE_QTY" NUMBER DEFAULT 0,
  "PURCHASE_PRICE" NUMBER DEFAULT 0,
  CONSTRAINT TB_SHARE_PK PRIMARY KEY ("MEMBER_UID", "STOCK_ID")
);

COMMENT ON COLUMN TB_SHARE.MEMBER_UID IS '���UID(������)';
COMMENT ON COLUMN TB_SHARE.STOCK_ID IS '�ֽ� ��ȣ(������)';
COMMENT ON COLUMN TB_SHARE.SHARE_QTY IS '�ֽ� ������';
COMMENT ON COLUMN TB_SHARE.PURCHASE_PRICE IS '�ֽ� ���԰�';

CREATE TABLE "TB_TRADELOG" (
  "TRADE_ID" NUMBER CONSTRAINT TB_TRADELOG_PK PRIMARY KEY,
  "MEMBER_UID" NUMBER,
  "TRADE_DATE" DATE DEFAULT SYSDATE,
  "STOCK_ID" NUMBER,
  "TRADE_QTY" NUMBER CONSTRAINT TRADE_QTY_NN NOT NULL,
  "TRADE_PRICE" NUMBER CONSTRAINT TRADE_PRICE_NN NOT NULL,
  "TRADE_STATUS" VARCHAR2(9) CONSTRAINT TRADE_STATUS NOT NULL
);

COMMENT ON COLUMN TB_TRADELOG.TRADE_ID IS '�ŷ� ��ȣ(������)';
COMMENT ON COLUMN TB_TRADELOG.MEMBER_UID IS '���UID(������)';
COMMENT ON COLUMN TB_TRADELOG.TRADE_DATE IS '�ŷ� ����';
COMMENT ON COLUMN TB_TRADELOG.STOCK_ID IS '�ֽ� �̸�';
COMMENT ON COLUMN TB_TRADELOG.TRADE_QTY IS '�ŷ� ����';
COMMENT ON COLUMN TB_TRADELOG.TRADE_PRICE IS '�ŷ� ����';
COMMENT ON COLUMN TB_TRADELOG.TRADE_STATUS IS '����(�Ǹ�/����)';

CREATE TABLE "TB_BULLETIN" (
  "BULLETIN_ID" NUMBER CONSTRAINT TB_BULLETIN_PK PRIMARY KEY,
  "BULLETIN_VCOUNT" NUMBER DEFAULT 0,
  "BULLETIN_WRT_DATE" DATE DEFAULT SYSDATE,
  "MEMBER_UID" NUMBER,
  "BULLETIN_TITLE" VARCHAR2(90),
  "BULLETIN_CONTENT" VARCHAR2(1500),
  "BULLETIN_DLT_YN" CHAR(1) DEFAULT 'N' CONSTRAINT BULLETIN_DLT_YN_CK CHECK( BULLETIN_DLT_YN IN ('Y','N') )
);

COMMENT ON COLUMN TB_BULLETIN.BULLETIN_ID IS '�Խñ� ��ȣ(������)';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_VCOUNT IS '�Խñ� ��ȸ��';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_WRT_DATE IS '�Խñ� �ۼ�����';
COMMENT ON COLUMN TB_BULLETIN.MEMBER_UID IS '���UID(������)';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_TITLE IS '�Խñ� ����';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_CONTENT IS '�Խñ� ����';
COMMENT ON COLUMN TB_BULLETIN.BULLETIN_DLT_YN IS '�Խñ� ��������(Y/N)';

CREATE TABLE "TB_COMMENT" (
  "BULLETIN_ID" NUMBER,
  "COMMENT_ID" NUMBER,
  "COMMENT_WRT_DATE" DATE DEFAULT SYSDATE,
  "MEMBER_UID" NUMBER,
  "COMMENT_CONTENT" VARCHAR2(300),
  "COMMENT_DLT_YN" CHAR(1) DEFAULT 'N' CONSTRAINT COMMENT_DLT_YN_CK CHECK( COMMENT_DLT_YN IN ('Y','N') ),
  CONSTRAINT TB_COMMENT_PK PRIMARY KEY("BULLETIN_ID","COMMENT_ID")
);

COMMENT ON COLUMN TB_COMMENT.BULLETIN_ID IS '�Խñ� ��ȣ(������)';
COMMENT ON COLUMN TB_COMMENT.COMMENT_ID IS '��� ��ȣ';
COMMENT ON COLUMN TB_COMMENT.COMMENT_WRT_DATE IS '��� �ۼ�����';
COMMENT ON COLUMN TB_COMMENT.MEMBER_UID IS '���UID(������)';
COMMENT ON COLUMN TB_COMMENT.COMMENT_CONTENT IS '��� ����';
COMMENT ON COLUMN TB_COMMENT.COMMENT_DLT_YN IS '��� ��������(Y/N)';

CREATE TABLE "TB_ITEM" (
  "ITEM_ID" NUMBER CONSTRAINT TB_ITEM_PK PRIMARY KEY,
  "ITEM_NAME" VARCHAR2(30),
  "ITEM_PRICE" NUMBER DEFAULT 0,
  "ITEM_DESC" VARCHAR2(600)
);

COMMENT ON COLUMN TB_ITEM.ITEM_ID IS '������ ��ȣ(������)';
COMMENT ON COLUMN TB_ITEM.ITEM_NAME IS '������ �̸�';
COMMENT ON COLUMN TB_ITEM.ITEM_PRICE IS '������ ����';
COMMENT ON COLUMN TB_ITEM.ITEM_DESC IS '������ ����';

CREATE TABLE "TB_MEMBER_ITEM" (
  "MEMBER_UID" NUMBER,
  "ITEM_ID" NUMBER,
  "ITEM_QTY" NUMBER DEFAULT 0,
  CONSTRAINT TB_MEMBER_ITEM_PK PRIMARY KEY ("MEMBER_UID", "ITEM_ID")
);

COMMENT ON COLUMN TB_MEMBER_ITEM.MEMBER_UID IS '���UID(������)';
COMMENT ON COLUMN TB_MEMBER_ITEM.ITEM_ID IS '������ ��ȣ(������)';
COMMENT ON COLUMN TB_MEMBER_ITEM.ITEM_QTY IS '������ ��������';

-- ==================== �ܷ�Ű ���� =======================

ALTER TABLE "TB_MEMBER" ADD CONSTRAINT MEMBER_RCODE_FK 
FOREIGN KEY ("MEMBER_RCODE") REFERENCES "TB_MEMBER_RANK" ("MEMBER_RCODE");

ALTER TABLE "TB_SHARE" ADD CONSTRAINT TB_SHARE_MEMBER_UID_FK 
FOREIGN KEY ("MEMBER_UID") REFERENCES "TB_MEMBER" ("MEMBER_UID")
ON DELETE CASCADE;

ALTER TABLE "TB_SHARE" ADD CONSTRAINT TB_SHARE_STOCK_ID_FK 
FOREIGN KEY ("STOCK_ID") REFERENCES "TB_STOCK_LIST" ("STOCK_ID")
ON DELETE CASCADE;

ALTER TABLE "TB_TRADELOG" ADD CONSTRAINT TB_TRADELOG_MEMBER_UID_FK 
FOREIGN KEY ("MEMBER_UID") REFERENCES "TB_MEMBER" ("MEMBER_UID")
ON DELETE CASCADE;

ALTER TABLE "TB_TRADELOG" ADD CONSTRAINT TB_TRADELOG_STOCK_ID_FK 
FOREIGN KEY ("STOCK_ID") REFERENCES "TB_STOCK_LIST" ("STOCK_ID")
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

ALTER TABLE "TB_MEMBER_STOCK" ADD CONSTRAINT TB_MEMBER_STOCK_MEMBER_UID_FK
FOREIGN KEY ("MEMBER_UID") REFERENCES "TB_MEMBER" ("MEMBER_UID")
ON DELETE CASCADE;

ALTER TABLE "TB_MEMBER_STOCK" ADD CONSTRAINT TB_MEMBER_STOCK_STOCK_ID_FK
FOREIGN KEY ("STOCK_ID") REFERENCES "TB_STOCK_LIST" ("STOCK_ID")
ON DELETE CASCADE;

-- ================ ������ ���� ====================

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
-- COMMENT_ID �������� Ʈ���ŷ� �Խñ� ���� �ٸ��� �����Ѵ�.

-- ================ Ʈ���� ���� ====================

-- COMMENT_ID ������ ���� ( �Խñ۸��� 1���� ���� )
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

-- ����� �ֽ� ���� ����
CREATE OR REPLACE TRIGGER MEMBER_STOCK_TRG
AFTER INSERT ON TB_MEMBER
FOR EACH ROW
BEGIN
    FOR STOCK IN ( SELECT STOCK_ID FROM TB_STOCK_LIST )
    LOOP
        INSERT INTO TB_MEMBER_STOCK VALUES(STOCK.STOCK_ID, :NEW.MEMBER_UID, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
    END LOOP;
END;
/

-- =============== ���ν��� ���� ======================
-- https://m.blog.naver.com/hj_kim97/222842014255

CREATE OR REPLACE PROCEDURE PURCHASE_STOCK_PROC (
    p_member_uid IN NUMBER,
    p_stock_id IN NUMBER,
    p_purchase_qty IN NUMBER,
    p_purchase_price IN NUMBER
) AS
BEGIN
    -- 1. TB_SHARE���� ����ڰ� ������ �ֽ��� ��Ͻ�Ű��, ���� �̹� �ִٸ� �ֽ��� ���� STOCK_QTY�� ����
    MERGE
    INTO TB_SHARE
    USING (SELECT p_stock_id , p_member_uid FROM DUAL)
    ON (TB_SHARE.STOCK_ID = p_stock_id AND TB_SHARE.MEMBER_UID = p_member_uid)
    WHEN MATCHED THEN
        UPDATE SET TB_SHARE.SHARE_QTY = TB_SHARE.SHARE_QTY + p_purchase_qty
    WHEN NOT MATCHED THEN
        INSERT VALUES(p_member_uid, p_stock_id, p_purchase_qty, p_purchase_price);
        
     -- 2. p_purchase_qty ��ŭ p_stock_id�� TB_MEMBER_STOCK.STOCK_QTY�� ����
    UPDATE TB_MEMBER_STOCK
    SET STOCK_QTY = STOCK_QTY - p_purchase_qty
    WHERE MEMBER_UID = p_member_uid AND STOCK_ID = p_stock_id;
    
    -- 3. ���� ����� TB_TRADELOG�� ���
    INSERT INTO TB_TRADELOG VALUES(TRADE_ID_SEQ.NEXTVAL,p_member_uid, DEFAULT,
                                    p_stock_id, p_purchase_qty, p_purchase_price, '����');
        
    -- 4. p_purchase_price ��ŭ p_member_uid�� TB_MEMBER.BALANCE�� ����
    UPDATE TB_MEMBER
    SET BALANCE = BALANCE - p_purchase_price
    WHERE MEMBER_UID = p_member_uid;
    
END;
/

-- =============== �⺻ ������ ���� ===================

INSERT INTO TB_STOCK_LIST(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'LG����');
INSERT INTO TB_STOCK_LIST(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'�Ｚ����');
INSERT INTO TB_STOCK_LIST(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'�Ե��ɹ�Į');
INSERT INTO TB_STOCK_LIST(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'������');
INSERT INTO TB_STOCK_LIST(STOCK_ID, STOCK_NAME) VALUES(STOCK_ID_SEQ.NEXTVAL,'KB����');

INSERT INTO TB_MEMBER_RANK VALUES('M1','�ű�ȸ��');
INSERT INTO TB_MEMBER_RANK VALUES('M2','�Ϲ�ȸ��');
INSERT INTO TB_MEMBER_RANK VALUES('M3','���ȸ��');
INSERT INTO TB_MEMBER_RANK VALUES('AD','������');

COMMIT;

-- ==========================
-- VO�� ���� ������ �̾Ƴ� ����
SELECT *
FROM TB_MEMBER_STOCK
JOIN TB_STOCK_LIST USING(STOCK_ID)
WHERE MEMBER_UID = 1;

SELECT *
FROM TB_SHARE
JOIN TB_STOCK_LIST USING(STOCK_ID)
WHERE MEMBER_UID = 1;
