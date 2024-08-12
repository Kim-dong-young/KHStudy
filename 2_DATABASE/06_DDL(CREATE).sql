/*
    *������ ���� ���
    ����Ŭ���� �����ϴ� 
    ��ü�� ���� �����(CREATE),
    ������ �����ϰ�(ALTER),
    ���� ��ü�� ����(DELETE)�ϴ� ���
    ��, ���� �����Ͱ��� �ƴ� ��Ģ ��ü�� �����ϴ� ���
    
    ����Ŭ���� ��ü(����) : ���̺�, ��, ������
                         �ε���, ��Ű��, Ʈ����
                         ���ν���, �Լ�, ���Ǿ�, �����
*/

/*
    <CREATE>
    ��ü�� ���� �����ϴ� ����
    
    1. ���̺� ����
    - ���̺��̶� : ��� ���� �����Ǵ� ���� �⺻���� �����ͺ��̽� ��ü
                 ��� �����͵��� ���̺��� ���� �����
                 (DBMS��� �� �ϳ���, �����͸� ������ ǥ ���·� ǥ���� ��)
                 #DBMS : �����ͺ��̽� ������ ���� ����Ʈ����
    
    [ǥ����]
    CREATE TABLE ���̺��(
        �÷��� �ڷ���(ũ��),
        �÷��� �ڷ���,
        ...
    }
    
    *�ڷ���
        - ����( CHAR(����Ʈũ��) | VARCHAR2(����Ʈũ��) ) -> �ݵ�� ũ�� ������ ����� ��
            - CHAR : �ִ� 2000����Ʈ���� �������� / ��������(������ ���ڼ��� �����Ͱ� ��� ���)
            - VARCHAR2 : �ִ� 4000����Ʈ���� ���� ���� / ��������(������� �����Ͱ� ������ �𸣴� ���)
        - ����(NUMBER)
        - ��¥(DATE)
*/

/*
    �н��� ���� ����
    CREATE USER KH2 IDENTIFIED BY KH2;

    GRANT RESOURCE, CONNECT TO KH2;
*/

-- ȸ���� ���� �����͸� ������� ���̺� MEMBER ����
CREATE TABLE MEMBER(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20), -- �������� ���̵� �ٸ� ���̹Ƿ� �������� ���ڿ��� ����
    MEM_PWD VARCHAR2(20),
    MEM_NAME VARCHAR2(20),
    GENDER CHAR(3), -- ������ ��,��� �� ������ ������ CHAR ��� (��ȸ�� ���� ������)
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

SELECT * FROM MEMBER;
---------------------------------------------------------------------
/*
    2. �÷��� �ּ��ޱ� ( �÷��� ���� ������ ���� )
    
    [ǥ����]
    COMMENT ON COLUMN ���̺��.�÷��� IS '�ּ� ����';
    -> �߸� �ۼ� ��, ���� �����ϸ� �ȴ�.
*/

COMMENT ON COLUMN MEMBER.MEM_NO IS 'ȸ����ȣ';
COMMENT ON COLUMN MEMBER.MEM_ID IS 'ȸ�����̵�';
COMMENT ON COLUMN MEMBER.MEM_PWD IS 'ȸ����й�ȣ';
COMMENT ON COLUMN MEMBER.MEM_NAME IS 'ȸ����';
COMMENT ON COLUMN MEMBER.GENDER IS '����(��/��)';
COMMENT ON COLUMN MEMBER.PHONE IS '��ȭ��ȣ';
COMMENT ON COLUMN MEMBER.EMAIL IS '�̸���';
COMMENT ON COLUMN MEMBER.MEM_DATE IS 'ȸ��������';


-- ���̺��� �����ϰ��� �� �� : DROP TABLE ���̺��;
DROP TABLE MEMBER;

-- INSERT INTO ���̺�� VALUES(��, ��, ��.... (���� ���̺� �÷� ������� �ۼ�));

INSERT INTO MEMBER 
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'AAAA@NAVER.COM', '24/08/12');

INSERT INTO MEMBER 
VALUES(1, 'USER1', 'PASS1', NULL, NULL, '010-1111-2222', NULL, NULL);

--------------------------------------------------------
/*
    <���� ����>
    - ���ϴ� �����Ͱ�(��ȿ�� ������ ��)�� �����ϱ� ���ؼ� Ư�� �÷��� �����ϴ� ����
    - ������ ���Ἲ ������ �������� �Ѵ�.
    
    ���� : NOT NULL, UNIQUE(�ߺ��Ұ�), CHECK(�� OR ���� ������ �ֵ���), PRIMARY KEY, FOREIGN KEY
*/

/*
    * NOT NULL
    �ش� �÷��� �ݵ�� ���� �����ؾ߸� �� ���( ��, ���� NULL�� ������ �ȵǴ� ��� )
    ����/������ NULL���� ������� �ʵ��� ����
    
    ���������� �ο��ϴ� ����� ũ�� 2������ �ִ�. (�÷����� ���, ���̺��� ���)
    NOT NULL ���������� ������ �÷����� ������θ� �����ϴ�.

    
*/

CREATE TABLE MEM_NOTNULL(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL, -- �������� ���̵� �ٸ� ���̹Ƿ� �������� ���ڿ��� ����
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3), -- ������ ��,��� �� ������ ������ CHAR ��� (��ȸ�� ���� ������)
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

INSERT INTO MEM_NOTNULL 
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'ONE@NAVER.COM', '24/08/12');

SELECT * FROM MEM_NOTNULL;

INSERT INTO MEM_NOTNULL 
VALUES(2, 'USER2', 'PASS2', 'ȫ���', NULL, NULL, NULL, NULL);

INSERT INTO MEM_NOTNULL
VALUES(3, NULL, 'PASS3', 'ȫ���', NULL, NULL, NULL, NULL);
-- �ǵ��ߴ���� ������ �߻��Ѵ�.(NOT NULL �������� ����)

INSERT INTO MEM_NOTNULL 
VALUES(3, 'USER2', 'PASS3', 'ȫ���', NULL, NULL, NULL, NULL);
-- ���̵� �ߺ��Ǿ������� �ұ��ϰ� �� �߰��� �ȴ�.

-----------------------------------------------------------------------
/*
    * UNIQUE ��������
    �ش� �÷��� �ߺ��� ���� ������ �ȵ� ��� ����Ѵ�.
    �÷����� �ߺ����� �����ϴ� ���������̴�.
    ����/���� �� ������ �ִ� �����Ͱ� �� �ߺ����� ���� ��� ������ �߻���Ų��.
*/

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷����� ���
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
    --UNIQUE(MEM_ID) ���̺��� ���
);

INSERT INTO MEM_UNIQUE
VALUES(1,'USER1','PASS1','ȫ�浿','��','010-1111-2222','AAAA@NAVER.COM','24/01/01');

SELECT * FROM MEM_UNIQUE;

INSERT INTO MEM_UNIQUE
VALUES(2,'USER1','PASS2','ȫ���','��','010-1111-3333','BBBBB@NAVER.COM','24/01/02');
-- ���̺� Ŭ�� -> �������� -> �������� ��ȣ�� ���� ���� ��� �������� Ȯ�� ����
-- ���� ���ǿ� ����Ǿ����Ƿ� INSERT ����
--> ���ޱ����� �������Ǹ����� �˷��ش�.
--> ���� �ľ��ϱⰡ ��ƴ�.
--> �������� �ο��� �������Ǹ��� ������ �� �ִ�(�������� ������ �ý��ۿ��� �ڵ����� �ο���)

-------------------------------------------------------------------------
/*
    �������� �ο��� �������Ǹ���� �ο��ϴ� ��
    > �÷����� ���
    CREATE TABLE ���̺��(
        �÷��� �ڷ��� (CONSTRAINT �������Ǹ�) ��������
    )
    > ���̺��� ���
    CREATE TABLE ���̺��(
        �÷��� �ڷ���,
        �÷��� �ڷ���,
        (CONSTRAINT �������Ǹ�)��������(�÷���)
    )
*/

DROP TABLE MEM_UNIQUE;

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
    MEM_ID VARCHAR2(20) CONSTRAINT MEMID_NT NOT NULL, -- �÷����� ���
    MEM_PWD VARCHAR2(20) CONSTRAINT MEMPWD_NT NOT NULL,
    MEM_NAME VARCHAR2(20) CONSTRAINT MEMNM_NT NOT NULL,
    GENDER CHAR(3), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    CONSTRAINT MEMID_UQ UNIQUE(MEM_ID) -- ���̺��� ���
);

INSERT INTO MEM_UNIQUE
VALUES(1,'USER1','PASS1','ȫ�浿','��','010-1111-2222','AAAA@NAVER.COM','24/01/01');

SELECT * FROM MEM_UNIQUE;

INSERT INTO MEM_UNIQUE
VALUES(2,'USER1','PASS2','ȫ���','��',NULL,NULL,NULL);

INSERT INTO MEM_UNIQUE
VALUES(3,'USER3','PASS3','ȫ���',NULL,NULL,NULL,NULL);

INSERT INTO MEM_UNIQUE
VALUES(4,'USER4','PASS4',NULL,NULL,NULL,NULL,NULL);

------------------------------------------------------------------------------
/*
    * CHECK(���ǽ�)
    �ش� �÷��� ���� �� �ִ� ���� ���� ������ ������ �� �� �ִ�.
    ���� ���ǿ� �����ϴ� �����Ͱ��� ��� �� ����
*/

CREATE TABLE MEM_CHECK(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷����� ���
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��','��')), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
    -- ���̺��� ���
    -- CHECK(GENDER IN ('��','��')) 
);

INSERT INTO MEM_CHECK
VALUES(1,'USER1','PASS1','ȫ�浿','��','010-1111-2222','AAAA@NAVER.COM','24/01/01');

SELECT * FROM MEM_CHECK;

-- ���������� �־������� NULL�� �����ϴ� ( �����Ͱ� ���ٴ� �� )
INSERT INTO MEM_CHECK
VALUES(2,'USER2','PASS2','ȫ���', NULL, NULL, NULL, NULL);

INSERT INTO MEM_CHECK
VALUES(2,'USER2','PASS2','��', NULL, NULL, NULL, NULL);
--> CHECK �������� ������ ���ܰ� �߻��Ѵ�.
--> GENDER �÷����� CHECK ���������� �����ϴ� ���� �־���Ѵ�.
--> �� NULL�� ���� ���ٴ� ���̱� ������ �����ϴ�...

------------------------------------------------------------------------
/*
    PRIMARY KEY(�⺻Ű) ��������
    ���̺��� �� ��(ROW)�� �ĺ��ϱ� ���� ����, �÷��� �ο��ϴ� ��������(�ĺ��� ����)
    
    EX) ȸ����ȣ, �й�, ����, �μ��ڵ�, �����ڵ�, �ֹι�ȣ, �ֹ���ȣ, �ù������ȣ, �����ȣ....
    PRIMARY KEY -> NOT NULL + UNIQUE �� �⺻�̴�.
    
    �� ���̺� �� ���� �Ѱ��� ���� ����
*/

CREATE TABLE MEM_PRI(
    MEM_NO NUMBER CONSTRAINT MEMNO_PK PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷����� ���
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��','��')), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

INSERT INTO MEM_PRI
VALUES(1,'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222','AAA@NAVER.COM','24/08/12');

INSERT INTO MEM_PRI
VALUES(1,'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL, NULL);
--> �⺻Ű�� �ߺ����� �������� �� ��(UNIQUE �������� ����)

INSERT INTO MEM_PRI
VALUES(NULL,'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL, NULL);
--> �⺻Ű�� NULL�� ������ ��(NOT NULL �������� ����)

INSERT INTO MEM_PRI
VALUES(2,'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL, NULL);

---------------------------------------------------------------------------

CREATE TABLE MEM_PRI2(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷����� ���
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��','��')), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE,
    PRIMARY KEY(MEM_NO, MEM_ID)
);
-- ����Ű : �ΰ��� �÷��� ���ÿ� �ϳ��� PRIMARY KEY�� �����ϴ� ��
-- �� Ű�� �ϳ��� ��ġ�°� �������. ���ÿ� ��ġ�°� �ȵȴ�.

INSERT INTO MEM_PRI2
VALUES(1,'USER1', 'PASS1', 'ȫ�浿', '��', NULL, NULL, NULL);

INSERT INTO MEM_PRI2
VALUES(1,'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL, NULL);
--> �� �÷��� ��ġ�Ƿ� �����ϴ�

INSERT INTO MEM_PRI2
VALUES(2,'USER3', 'PASS3', 'ȫ���', '��', NULL, NULL, NULL);

INSERT INTO MEM_PRI2
VALUES(2,'USER3', 'PASS3', 'ȫ���', '��', NULL, NULL, NULL);
--> �� �÷� ��� ���ļ� �ȵȴ�.

-- ����Ű ��� ����(�ȷο�, ���ϱ� ��)
-- � ȸ���� � ��ǰ�� ���ߴ����� ���� �����͸� �����ϴ� ���̺�)

CREATE TABLE TB_LIKE(
    MEM_NO NUMBER,
    PRODUCT_NAME VARCHAR2(10),
    LIKE_DATE DATE,
    PRIMARY KEY(MEM_NO, PRODUCT_NAME)
);

-- ȸ���� 2��(1��, 2��) ����
-- ��ǰ�� 2��(A24, I14PRO)

INSERT INTO TB_LIKE VALUES(1,'A24',SYSDATE);
INSERT INTO TB_LIKE VALUES(1,'I14PRO',SYSDATE);
-- INSERT INTO TB_LIKE VALUES(1,'A24',SYSDATE);

SELECT * FROM TB_LIKE;

---------------------------------------------------------------------------
-- ȸ����޿� ���� �����͸� �����ϴ� ���̺�

DROP TABLE MEM_GRADE;

CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO MEM_GRADE VALUES(10, '�Ϲ�ȸ��');
INSERT INTO MEM_GRADE VALUES(20, '���ȸ��');
INSERT INTO MEM_GRADE VALUES(30, 'Ư��ȸ��');

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷����� ���
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��','��')), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', 'ȫ�浿', '��', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', 'ȫ���', '��', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS03', '������', '��', NULL, NULL, 20);
INSERT INTO MEM VALUES(4, 'USER4', 'PASS04', '�����', '��', NULL, NULL, 30);

INSERT INTO MEM VALUES(5, 'USER5', 'PASS05', '������', '��', NULL, NULL, 40);
SELECT * FROM MEM;
-- ���� ȸ�����(40) ������, �� ����ȴ�. JOIN�� �����ϰ����� ���Ἲ ����

---------------------------------------------------------------------------
/*
    FOREIGN KEY(�ܷ�Ű) ��������
    �ٸ� ���̺� �����ϴ� ���� ���;��ϴ� Ư�� �÷��� �ο��ϴ� ��������
    -> �ٸ� ���̺��� �����Ѵٰ� ǥ��
    -> �ַ� FOREIGN KEY ������������ ���� ���̺� ���谡 �����ȴ�.
    
    > �÷��������
    �÷��� �ڷ��� REFERENCES ���������̺��[������ �÷���]
    
    > ���̺������
    FOREIGN KEY(�÷���) REFERENCES ���������̺��[������ �÷���]
    
    -> ������ �÷��� ���� ��, ������ ���̺��� PRIMARY KEY�� �ڵ�����
*/

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷����� ���
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��','��')), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER, -- REFERENCES MEM_GRADE(GRADE_CODE)
    FOREIGN KEY(GRADE_ID) REFERENCES MEM_GRADE--(GRADE_CODE) ���� ����, �ڵ����� �ش����̺� �⺻Ű�� ��Ī������
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', 'ȫ�浿', '��', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', 'ȫ���', '��', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS03', '������', '��', NULL, NULL, 20);
INSERT INTO MEM VALUES(4, 'USER4', 'PASS04', '�����', '��', NULL, NULL, 30);

INSERT INTO MEM VALUES(5, 'USER5', 'PASS05', '������', '��', NULL, NULL, 40);
-- PARENT KEY�� ã�� �� ���ٴ� ���� �߻�

SELECT * FROM MEM;
-- MEM�� MEM_GRADE�� ����� ��� �ɱ�??
-- MEM_GRADE(�θ����̺�) -|---------<- MEM(�ڽ����̺�)
-- ����� ���� ȸ���� �ش��� �� ������, ����� ����� �ѹ��� �ϳ��� ���� �� ���� -> 1�� N ����
-- ������(��ް���)�� ���� ���̺��� ������ 1
-- KEY�� 1�� �ʿ��� �������� �Ѵ� ( 1 ���� �θ�, N�� �ڽ� ���̺� )

-- N �� N�� �߰� ���̺��� ���� ���踦 �ε��� �Ѵ�
-- EX) ��ǰ(N) -- (N)��� ���踦 ǥ���Ϸ���
-- ��ǰ(N) -- (1)���(1) -- (N) ��� ó�� ���踦 �ξ��ش�

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;
-- �ڽ����̺�(MEM)���� 10�� ����ϰ��ֱ� ������, ������ �ȵ�

DELETE FROM MEM WHERE GRADE_ID = 30;

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 30;
-- MEM���̺��� 30�̶�� ���� ����ϰ� ���� �ʱ� ������ ������ �ȴ�.

-- �ڽ����̺��� �̹� ����ϰ��ִ� ���� ���� ���
-- �θ����̺�κ��� ������ ������ �ȵǴ� "��������" �ɼ��� �ɷ�����

ROLLBACK;

---------------------------------------------------------------------
/*
    �ڽ����̺� ���� �� �ܷ�Ű �������� �ο��� �� �����ɼ� ��������
    * �����ɼ� : �θ����̺��� ������ ������ �� �����͸� ����ϰ� �ִ� �ڽ����̺��� ���� ��� �� ���ΰ�?
    
    - ON DELETE RESTRICTED(�⺻��) : ���� ���� �ɼ�, �ڽĵ����ͷκ��� �����Ǵ� �θ����ʹ� ���� �Ұ�
    - ON DELETE SET NULL : �θ����� ������ �ش� �����͸� ����ϰ��ִ� �ڽ� �������� ���� NULL�� ����
    - ON DELETE CASCADE : �θ����� ������ �ش� �����͸� ����ϰ��ִ� �ڽ� �����͵� ���� ���� ����
*/
-- SET NULL

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷����� ���
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��','��')), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER, -- REFERENCES MEM_GRADE(GRADE_CODE)
    FOREIGN KEY(GRADE_ID) REFERENCES MEM_GRADE ON DELETE SET NULL
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', 'ȫ�浿', '��', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', 'ȫ���', '��', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS03', '������', '��', NULL, NULL, 20);
INSERT INTO MEM VALUES(4, 'USER4', 'PASS04', '�����', '��', NULL, NULL, 30);

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;

SELECT * FROM MEM;

-- CASCACE

DROP TABLE MEM;
DROP TABLE MEM_GRADE;

CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO MEM_GRADE VALUES(10, '�Ϲ�ȸ��');
INSERT INTO MEM_GRADE VALUES(20, '���ȸ��');
INSERT INTO MEM_GRADE VALUES(30, 'Ư��ȸ��');

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷����� ���
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��','��')), -- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER, -- REFERENCES MEM_GRADE(GRADE_CODE)
    FOREIGN KEY(GRADE_ID) REFERENCES MEM_GRADE ON DELETE CASCADE
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', 'ȫ�浿', '��', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', 'ȫ���', '��', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS03', '������', '��', NULL, NULL, 20);
INSERT INTO MEM VALUES(4, 'USER4', 'PASS04', '�����', '��', NULL, NULL, 30);

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 30;

SELECT * FROM MEM;

-----------------------------------------------------------------------------
/*
    <DEFAULT �⺻��> *���������� �ƴϴ�.
    �÷��� ���������ʰ� INSERT�� NULL�� �ƴ� �⺻���� INSERT�ϰ��� �Ѵ�.
    �̶� ������ �� �� �ִ� ��
    
    �÷��� �ڷ��� DEFAULT �⺻��
*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_NAME VARCHAR2(20) NOT NULL,
    MEM_AGE NUMBER,
    HOBBY VARCHAR2(20) DEFAULT '����',
    ENROLL_DATE DATE DEFAULT SYSDATE
);

-- INSERT INTO ���̺�� VALUES(��1, ��2, ...)
INSERT INTO MEMBER VALUES(1,'������', 20, '�', '20/01/01');
INSERT INTO MEMBER VALUES(2,'����', 20, NULL, NULL);
INSERT INTO MEMBER VALUES(3,'������', 20, DEFAULT, DEFAULT);

-- INSERT INTO ���̺�� (�÷�1, �÷�2....) VALUES(�÷�1��, �÷�2��...)
INSERT INTO MEMBER(MEM_NO, MEM_NAME) VALUES(4,'�̰���');
--> ���õ��� ���� �÷����� �⺻������ NULL�� �� ( AGE )
--> ��, �ش� �÷��� DEFAULT���� �ο��Ǿ� ���� ��� NULL�� �ƴ� DEFAULT���� �� ) ( HOBBY, ENROLL_DATE )

-----------------------------------------------------------------------------
-- ���̺��� ������ �� �ִ�. ���⼭���� KH�����̿�
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE);

DROP TABLE EMPLOYEE_COPY;
-----------------------------------------------------------------------------
/*
    ���̺��� �� ������ �Ŀ� �ڴʰ� ���������� �߰��ϴ� ���
    ALTER TABLE ���̺�� �����ҳ���
    
    - PRIMARY KEY : ALTER TABLE ���̺�� ADD PRIMARY KEY(�÷���);
    - FOREIGN KEY : ALTER TABLE ���̺�� ADD FOREIGN KEY(�÷���) REFERENCES ���������̺��[�÷���];
    - UNIQUE : ALTER TABLE ���̺�� ADD UNIQUE(�÷���);
    - CHECK : ALTER TABLE ���̺�� ADD CHECK(�÷��� ���� ���ǽ�);
    - NOT NULL : ALTER TABLE ���̺�� MODIFY �÷��� NOT NULL;
*/

ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID);

-- ALTER TABLE EMPLOYEE MODIFY EMP_NO NOT NULL;









