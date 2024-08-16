/*
    1. �迭 ������ ������ ī�װ� ���̺��� ������� �Ѵ�. ������ ���� ���̺��� �ۼ��Ͻÿ�.
    ���̺� �̸�
        TB_CATEGORY
    �÷�
        NAME VARCHAR2(10)
        USE_YN CHAR(1) �⺻�� Y
*/
CREATE TABLE TB_CATEGORY(
    NAME VARCHAR2(10),
    USE_YN CHAR(1) DEFAULT 'Y'
);

/*
    2. ���� ������ ������ ���̺��� ������� �Ѵ�. ������ ���� ���̺��� �ۼ��Ͻÿ�.
    ���̺� �̸�
        TB_CLASS_TYPE
    �÷�
        NO VARCHAR2(5) PRIMARY KEY
        NAME VARCHAR2(10)
*/
CREATE TABLE TB_CLASS_TYPE(
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);

/*
    3. TB_CATEGORY ���̺��� NAME �÷��� PRIMARY KEY�� �����Ͻÿ�.
    (KEY �̸��� �������� �ʾƵ� ������, ���� KEY �̸��� �����ϰ��� �Ѵٸ� �̸��� ������
    �˾Ƽ� ������ �̸��� ����Ѵ�.)
*/
ALTER TABLE TB_CATEGORY MODIFY NAME PRIMARY KEY;

/*
    4. TB_CLASS_TYPE ���̺��� NAME �÷��� NULL ���� ���� �ʵ��� �Ӽ��� �����Ͻÿ�.
*/
ALTER TABLE TB_CLASS_TYPE MODIFY NAME NOT NULL;

/*
    5. �� ���̺��� �÷� ���� NO �� ���� ���� Ÿ���� �����ϸ鼭 ũ��� 10����, �÷�����
    NAME�� ���� ���������� ���� Ÿ���� �����ϸ鼭 ũ�� 20���� �����Ͻÿ�.
*/
ALTER TABLE TB_CATEGORY MODIFY NO VARCHAR2(10);
ALTER TABLE TB_CLASS_TYPE MODIFY NO VARCHAR2(10);

ALTER TABLE TB_CATEGORY MODIFY NAME VARCHAR2(20);
ALTER TABLE TB_CLASS_TYPE MODIFY NAME VARCHAR2(20);

/*
    6. �� ���̺��� NO �÷��� NAME �÷��� �̸��� ���� TB_�� ������ ���̺� �̸��� �տ� ����
    ���·� �����Ѵ�. (EX. CATEGORY_NAME)
*/
ALTER TABLE TB_CATEGORY RENAME COLUMN NO TO CATEGORY_NO;
ALTER TABLE TB_CLASS_TYPE RENAME COLUMN NO TO CLASS_NO;

ALTER TABLE TB_CATEGORY RENAME COLUMN NAME TO CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE RENAME COLUMN NAME TO CLASS_NAME;

/*
    7. TB_CATEGORY ���̺�� TB_CLASS_TYPE ���̺��� PRIMARY KEY �̸��� ������ ����
    �����Ͻÿ�.
    
    PRIMARY KEY�� �̸��� "PK_ + �÷��̸�" ���� �����Ͻÿ�. EX) PK_CATEGORY_NAME
*/
ALTER TABLE TB_CATEGORY RENAME COLUMN CATEGORY_NAME TO PK_CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE RENAME COLUMN CLASS_NO TO PK_CLASS_NO;

/*
    8. ������ ���� INSERT ���� �����Ѵ�.
    INSERT INTO TB_CATEGORY VALUES('����','Y');
    INSERT INTO TB_CATEGORY VALUES('�ڿ�����','Y');
    INSERT INTO TB_CATEGORY VALUES('����','Y');
    INSERT INTO TB_CATEGORY VALUES('��ü��','Y');
    INSERT INTO TB_CATEGORY VALUES('�ι���ȸ','Y');
    COMMIT;
*/
INSERT INTO TB_CATEGORY VALUES('����','Y');
INSERT INTO TB_CATEGORY VALUES('�ڿ�����','Y');
INSERT INTO TB_CATEGORY VALUES('����','Y');
INSERT INTO TB_CATEGORY VALUES('��ü��','Y');
INSERT INTO TB_CATEGORY VALUES('�ι���ȸ','Y');
COMMIT;

/*
    9. TB_DEPARTMENT�� CATEGORY �÷��� TB_CATEGORY ���̺��� PK_CATEGORY_NAME �÷��� �θ�
    ������ �����ϵ��� FOREIGN KEY�� �����Ͻÿ�. �� �� KEY �̸���
    FK_���̺��̸�_�÷��̸����� �����Ѵ�. EX) FK_DEPARTMENT_CATEGORY
*/
ALTER TABLE TB_DEPARTMENT ADD CONSTRAINT FK_DEPARTMENT_CATEGORY 
FOREIGN KEY(CATEGORY) REFERENCES TB_CATEGORY(PK_CATEGORY_NAME);

/*
    10. �� ������б� �л����� �������� ���ԵǾ� �ִ� �л��Ϲ����� VIEW�� ������� �Ѵ�.
    �Ʒ� ������ �����Ͽ� ������ SQL���� �ۼ��Ͻÿ�.
    
    �� �̸�
        VW_�л��Ϲ�����
    �÷�
        �й�
        �л��̸�
        �ּ�
*/
CREATE VIEW VW_�л��Ϲ����� AS(
    SELECT 
        STUDENT_NO,
        STUDENT_NAME,
        STUDENT_ADDRESS
    FROM
        TB_STUDENT
);

/*
    11. �� ������б��� 1�⿡ �ι� �� �а����� �л��� ���������� ���� ����� �����Ѵ�.
    �̸� ���� ����� �л��̸�, �а��̸�, ��米���̸� ���� �����Ǿ� �ִ� VIEW�� ����ÿ�.
    �̶� ���� ������ ���� �л��� ���� �� ������ ����Ͻÿ� ( �� �� VIEW�� �ܼ� SELECT
    ���� �� ��� �а����� ���ĵǾ� ȭ�鿡 �������� ����ÿ�. )
    
    �� �̸�
        VW_�������
    �÷�
        �л��̸�
        �а��̸�
        ���������̸�
*/
CREATE OR REPLACE VIEW VW_������� AS(
    SELECT *
    FROM (
            SELECT
                STUDENT_NAME,
                DEPARTMENT_NAME,
                PROFESSOR_NAME
            FROM
                TB_STUDENT
            JOIN
                TB_DEPARTMENT USING (DEPARTMENT_NO)
            LEFT JOIN
                TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
            ORDER BY
                DEPARTMENT_NAME
        )
);

/*
    12. ��� �а��� �а��� �л� ���� Ȯ���� �� �ֵ��� ������ VIEW �� �ۼ��� ����.
    
    �� �̸�
        VW_�а����л���
    �÷�
        DEPARTMENT_NAME
        STUDENT_COUNT
*/
CREATE VIEW VW_�а����л��� AS (
    SELECT
        DEPARTMENT_NAME,
        COUNT(*) AS STUDENT_COUNT
    FROM
        TB_STUDENT
    JOIN
        TB_DEPARTMENT USING (DEPARTMENT_NO)
    GROUP BY
        DEPARTMENT_NAME
);

/*
    13. ������ ������ �л��Ϲ����� VIEW�� ���ؼ� �й��� A213046�� �л��� �̸���
    ���� �̸����� �����ϴ� SQL ���� �ۼ��Ͻÿ�.
*/
UPDATE 
    TB_STUDENT
SET
    STUDENT_NAME = '�赿��'
WHERE
    STUDENT_NO = 'A213046';

/*
    14. 13�������� ���� VIEW�� ���ؼ� �����Ͱ� ����� �� �ִ� ��Ȳ�� �������� VIEW��
    ��� �����ؾ� �ϴ��� �ۼ��Ͻÿ�.
*/
-- VIEW ������ WITH READ ONLY �ɼ��� �����Ѵ�.

/*
    15. �� ������б��� �ų� ������û �Ⱓ�� �Ǹ� Ư�� �α� ����鿡 ���� ��û�� ����
    ������ �ǰ� �ִ�. �ֱ� 3���� �������� �����ο��� ���� ���Ҵ� 3 ������ ã�� ������
    �ۼ��غ��ÿ�.
*/
SELECT *
FROM (
    SELECT 
        CLASS_NO AS "�����ȣ", 
        CLASS_NAME AS "�����̸�",
        COUNT(*) AS "������������(��)"
    FROM
        TB_CLASS
    JOIN
        TB_GRADE USING ( CLASS_NO )
    WHERE
        SUBSTR(TERM_NO ,1,4) IN ( 
        SUBSTR((SELECT MAX(TERM_NO) AS MAX_YEAR FROM TB_GRADE) ,1,4) , 
        SUBSTR((SELECT MAX(TERM_NO) AS MAX_YEAR FROM TB_GRADE) ,1,4) -1, 
        SUBSTR((SELECT MAX(TERM_NO) AS MAX_YEAR FROM TB_GRADE) ,1,4) -2 )
    GROUP BY
        CLASS_NO, CLASS_NAME
    ORDER BY
        "������������(��)" DESC
) 
WHERE ROWNUM <=3;