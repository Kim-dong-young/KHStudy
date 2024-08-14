/*
    1. �л��̸��� �ּ����� ǥ���Ͻÿ�. ��, ��� ����� "�л� �̸�", "�ּ���"�� �ϰ�,
    ������ �̸����� �������� ǥ���ϵ��� �Ѵ�.
*/
SELECT 
    STUDENT_NAME AS "�л� �̸�", 
    STUDENT_ADDRESS AS �ּ���
FROM TB_STUDENT
ORDER BY STUDENT_NAME;

/*
    2. �������� �л����� �̸��� �ֹι�ȣ�� ���̰� ���� ������ ȭ�鿡 ����Ͻÿ�.
*/
SELECT STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
ORDER BY TO_DATE(SUBSTR(STUDENT_SSN,1,6)) DESC;

/*
    3. �ּ����� �������� ��⵵�� �л��� �� 1900��� �й��� ���� �л����� �̸��� �й�,
    �ּҸ� �̸��� ������������ ȭ�鿡 ����Ͻÿ�. ��, ���������� "�л��̸�","�й�","������ �ּ�"��
    ��µǵ��� �Ѵ�.
*/
SELECT
    STUDENT_NAME AS "�л��̸�",
    STUDENT_NO AS "�й�",
    STUDENT_ADDRESS AS "������ �ּ�"
FROM TB_STUDENT
WHERE 
    (STUDENT_ADDRESS LIKE '���%' OR
    STUDENT_ADDRESS LIKE '����%')
    AND
    STUDENT_NO NOT LIKE 'A%' -- 2000��� ���� �л��� �й��� A�� ����
ORDER BY STUDENT_NAME;

/*
    4. ���� ���а� ���� �� ���� ���̰� ���� ������� �̸��� Ȯ���� �� �ִ� SQL ������
    �ۼ��Ͻÿ�. ( ���а��� '�а��ڵ�'�� �а� ���̺�(TB_DEPARTMENT)�� ��ȸ�ؼ� ã�Ƴ����� ����)
*/
SELECT 
    PROFESSOR_NAME,
    PROFESSOR_SSN
FROM 
    TB_PROFESSOR
WHERE 
    DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                        FROM TB_DEPARTMENT
                        WHERE DEPARTMENT_NAME = '���а�' )
ORDER BY -- ������ ��� 2000�� ���� ����̴�
    TO_DATE('19'||SUBSTR(PROFESSOR_SSN,1,6));
    
/*
    5. 2004�� 2�б⿡ 'C3118100' ������ ������ �л����� ������ ��ȸ�Ϸ��� �Ѵ�.
    ������ ���� �л����� ǥ���ϰ�, ������ ������ �й��� ���� �л����� ǥ���ϴ� ������
    �ۼ��غ��ÿ�.
*/





