/*
    1. �������� ���̺�(TB_CLASS_TYPE)�� �Ʒ��� ���� �����͸� �Է��Ͻÿ�.
*/
INSERT INTO TB_CLASS_TYPE VALUES('01','�����ʼ�');
INSERT INTO TB_CLASS_TYPE VALUES('02','��������');
INSERT INTO TB_CLASS_TYPE VALUES('03','�����ʼ�');
INSERT INTO TB_CLASS_TYPE VALUES('04','���缱��');
INSERT INTO TB_CLASS_TYPE VALUES('05','������');

/*
    2. �� ������б� �л����� ������ ���ԵǾ� �ִ� �л��Ϲ����� ���̺��� ������� �Ѵ�.
    �Ʒ� ������ �����Ͽ� ������ SQL ���� �ۼ��Ͻÿ�. (���������� �̿��Ͻÿ�)
    
    ���̺��̸�
        TB_�л��Ϲ�����
    �÷�
        �й�
        �л��̸�
        �ּ�
*/
CREATE TABLE TB_�л��Ϲ����� AS (
    SELECT
        STUDENT_NO,
        STUDENT_NAME,
        STUDENT_ADDRESS
    FROM TB_STUDENT
);

/*
    3. ������а� �л����� �������� ���ԵǾ� �ִ� �а����� ���̺��� ������� �Ѵ�.
    �Ʒ� ������ �����Ͽ� ������ SQL���� �ۼ��Ͻÿ�. (��Ʈ : ����� �پ���, �ҽŲ�
    �ۼ��Ͻÿ�)
    
    ���̺��̸�
        TB_������а�
    �÷�
        �й�
        �л��̸�
        ����⵵ <= ���ڸ� �⵵�� ǥ��
        �����̸�
*/
DROP TABLE TB_������а�;

CREATE TABLE TB_������а� AS(
    SELECT
        STUDENT_NO AS "�й�",
        STUDENT_NAME AS "�л��̸�",
        EXTRACT(YEAR FROM TO_DATE('19'||SUBSTR(STUDENT_SSN,1,2),'YYYY')) AS "����⵵",
        PROFESSOR_NAME AS "�����̸�"
    FROM
        TB_STUDENT S
    JOIN
        TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
    WHERE
        S.DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                          FROM TB_DEPARTMENT
                          WHERE DEPARTMENT_NAME = '������а�' )
);

/*
    4. �� �а����� ������ 10% ������Ű�� �Ǿ���. �̿� ����� SQL���� �ۼ��Ͻÿ�.
    (��, �ݿø��� ����Ͽ� �Ҽ��� �ڸ����� ������ �ʵ��� �Ѵ�)
*/
UPDATE
    TB_DEPARTMENT
SET
    CAPACITY = ROUND(CAPACITY * 1.1);

/*
    5. �й� A413042�� �ڰǿ� �л��� �ּҰ� "����� ���α� ���ε� 181-21"�� ����Ǿ��ٰ�
    �Ѵ�. �ּ����� �����ϱ� ���� ����� SQL ���� �ۼ��Ͻÿ�.
*/
UPDATE
    TB_STUDENT
SET
    STUDENT_ADDRESS = '����� ���α� ���ε� 181-21'
WHERE
    STUDENT_NO = 'A413042'
    AND
    STUDENT_NAME = '�ڰǿ�';

/*
    6. �ֹε�Ϲ�ȣ ������� ���� �л����� ���̺��� �ֹι�ȣ ���ڸ��� �������� �ʱ��
    �����Ͽ���. �� ������ �ݿ��� ������ SQL ������ �ۼ��Ͻÿ�.
    EX) 830530-2124663 => 830530
*/
UPDATE 
    TB_STUDENT
SET
    STUDENT_SSN = SUBSTR(STUDENT_SSN,1,6);

/*
    7. ���а� ����� �л��� 2005�� 1�б⿡ �ڽ��� ������ '�Ǻλ�����' ������
    �߸��Ǿ��ٴ� ���� �߰��ϰ�� ������ ��û�Ͽ���. ��� ������ Ȯ�� ���� ��� �ش�
    ������ ������ 3.5�� ����Ű�� �����Ǿ���. ������ SQL ���� �ۼ��Ͻÿ�.
*/

UPDATE
    TB_GRADE
SET
    POINT = 3.5
WHERE
    STUDENT_NO = ( SELECT STUDENT_NO
                   FROM TB_STUDENT
                   JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
                   WHERE STUDENT_NAME = '�����'
                         AND
                         DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                                          FROM TB_DEPARTMENT
                                          WHERE DEPARTMENT_NAME = '���а�')
                 )
    AND
    TERM_NO = '200501'
    AND
    CLASS_NO = ( SELECT CLASS_NO
                 FROM TB_CLASS
                 WHERE CLASS_NAME = '�Ǻλ�����' );

/*
    8. ���� ���̺�(TB_GRADE) ���� ���л����� �����׸��� �����Ͻÿ�.
*/
UPDATE
    ( SELECT *
      FROM TB_GRADE
      JOIN TB_STUDENT USING (STUDENT_NO) )
SET
    POINT = NULL
WHERE
    ABSENCE_YN = 'Y';
    



