/*
    1. �л��̸��� �ּ����� ǥ���Ͻÿ�. ��, ��� ����� "�л� �̸�", "�ּ���"�� �ϰ�,
    ������ �̸����� �������� ǥ���ϵ��� �Ѵ�.
*/
SELECT 
    STUDENT_NAME AS "�л� �̸�", 
    STUDENT_ADDRESS AS �ּ���
FROM 
    TB_STUDENT
ORDER BY 
    STUDENT_NAME;

/*
    2. �������� �л����� �̸��� �ֹι�ȣ�� ���̰� ���� ������ ȭ�鿡 ����Ͻÿ�.
*/
SELECT 
    STUDENT_NAME, 
    STUDENT_SSN
FROM 
    TB_STUDENT
WHERE 
    ABSENCE_YN = 'Y'
ORDER BY 
    TO_DATE(SUBSTR(STUDENT_SSN,1,6)) DESC;

/*
    3. �ּ����� �������� ��⵵�� �л��� �� 1900��� �й��� ���� �л����� �̸��� �й�,
    �ּҸ� �̸��� ������������ ȭ�鿡 ����Ͻÿ�. ��, ���������� "�л��̸�","�й�","������ �ּ�"��
    ��µǵ��� �Ѵ�.
*/
SELECT
    STUDENT_NAME AS "�л��̸�",
    STUDENT_NO AS "�й�",
    STUDENT_ADDRESS AS "������ �ּ�"
FROM 
    TB_STUDENT
WHERE 
    (STUDENT_ADDRESS LIKE '���%' OR
    STUDENT_ADDRESS LIKE '����%')
    AND
    STUDENT_NO NOT LIKE 'A%' -- 2000��� ���� �л��� �й��� A�� ����
ORDER BY 
    STUDENT_NAME;

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
SELECT 
    STUDENT_NO, 
    TO_CHAR(POINT, '9.99')
FROM 
    TB_GRADE
WHERE 
    CLASS_NO = 'C3118100'
    AND SUBSTR(TERM_NO,1,4) = '2004'
    AND SUBSTR(TERM_NO,5,2) = '02'
ORDER BY 
    POINT DESC, STUDENT_NO;

/*
    6. �л� ��ȣ, �л� �̸�, �а� �̸��� �л� �̸����� �������� �����Ͽ� ����ϴ�
    SQL���� �ۼ��Ͻÿ�.
*/
SELECT 
    STUDENT_NO, 
    STUDENT_NAME, 
    DEPARTMENT_NAME
FROM 
    TB_STUDENT
JOIN 
    TB_DEPARTMENT USING(DEPARTMENT_NO);
ORDER BY 
    STUDENT_NAME;

/*
    7. �� ������б��� ���� �̸��� ������ �а� �̸��� ����ϴ� SQL ������
    �ۼ��Ͻÿ�.
*/
SELECT 
    CLASS_NAME, 
    DEPARTMENT_NAME
FROM 
    TB_CLASS
JOIN 
    TB_DEPARTMENT USING (DEPARTMENT_NO);

/*
    8. ���� ���� �̸��� ã������ �Ѵ�. ���� �̸��� ���� �̸��� ����ϴ� 
    SQL���� �ۼ��Ͻÿ�.
*/
SELECT 
    CLASS_NAME, 
    PROFESSOR_NAME
FROM 
    TB_CLASS
JOIN 
    TB_CLASS_PROFESSOR USING (CLASS_NO)
JOIN
    TB_PROFESSOR USING (PROFESSOR_NO);

/*
    9. 8���� ��� �� '�ι���ȸ' �迭�� ���� ������ ���� �̸��� ã������ �Ѵ�. �̿�
    �ش��ϴ� ���� �̸��� ���� �̸��� ����ϴ� SQL���� �ۼ��Ͻÿ�.
*/
SELECT 
    CLASS_NAME, 
    PROFESSOR_NAME
FROM 
    TB_CLASS
JOIN 
    TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN 
    TB_CLASS_PROFESSOR USING (CLASS_NO)
JOIN 
    TB_PROFESSOR USING (PROFESSOR_NO)
WHERE 
    CATEGORY = '�ι���ȸ';

/*
    10. '�����а�' �л����� ������ ���Ϸ��� �Ѵ�. �����а� �л����� "�й�", "�л� �̸�",
    "��ü ����" �� ����ϴ� SQL ������ �ۼ��Ͻÿ�. ( ��, ������ �Ҽ��� 1�ڸ������� �ݿø�
    �Ͽ� ǥ���Ѵ�.)
*/
SELECT 
    STUDENT_NO AS "�й�", 
    STUDENT_NAME AS "�л� �̸�", 
    ROUND(AVG(POINT),1) AS "��ü ����"
FROM 
    TB_STUDENT
JOIN 
    TB_GRADE USING(STUDENT_NO)
WHERE 
    DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                      FROM TB_DEPARTMENT
                      WHERE DEPARTMENT_NAME = '�����а�' )
GROUP BY 
    STUDENT_NO, STUDENT_NAME
ORDER BY 
    STUDENT_NO;

/*
    11. �й��� A313047�� �л��� �б��� ������ ���� �ʴ�. ���� �������� ������ �����ϱ�
    ���� �а� �̸�, �л� �̸��� ���� ���� �̸��� �ʿ��ϴ�. �̶� ����� SQL����
    �ۼ��Ͻÿ�. ��, �������� "�а��̸�", "�л��̸�", "���������̸�" ����
    ��µǵ��� �Ѵ�.
*/
SELECT 
    DEPARTMENT_NAME,
    STUDENT_NAME, 
    PROFESSOR_NAME
FROM 
    TB_STUDENT
JOIN
    TB_DEPARTMENT USING ( DEPARTMENT_NO )
JOIN
    TB_PROFESSOR ON ( COACH_PROFESSOR_NO = PROFESSOR_NO )
WHERE
    STUDENT_NO = 'A313047';

/*
    12. 2007 �⵵�� '�ΰ������' ������ ������ �л��� ã�� �л��̸��� �����б⸦ ǥ���ϴ�
    SQL ������ �ۼ��Ͻÿ�.
*/
SELECT 
    STUDENT_NAME, 
    TERM_NO AS TERM_NAME
FROM 
    TB_STUDENT
JOIN
    TB_GRADE USING ( STUDENT_NO )
WHERE
    TERM_NO LIKE '2007%'
    AND CLASS_NO = ( SELECT CLASS_NO
                     FROM TB_CLASS
                     WHERE CLASS_NAME = '�ΰ������' );

/*
    13. ��ü�� �迭 ���� �� ���� ��米���� �� �� �������� ���� ������ ã�� �� ����
    �̸��� �а� �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�.
*/
SELECT 
    CLASS_NAME, DEPARTMENT_NAME
FROM 
    TB_CLASS
JOIN 
    TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE
    CATEGORY = '��ü��'
    AND CLASS_NO NOT IN ( SELECT CLASS_NO
                     FROM TB_CLASS_PROFESSOR );

/*
    14. �� ������б� ���ݾƾ��а� �л����� ���������� �Խ��ϰ��� �Ѵ�. �л��̸���
    �������� �̸��� ã�� ���� ���� ������ ���� �л��� ��� "�������� ������"����
    ǥ���ϵ��� �ϴ� SQL���� �ۼ��Ͻÿ�. ��, �������� "�л��̸�", "��������"�� ǥ���ϸ�
    ���й� �л��� ���� ǥ�õǵ��� �Ѵ�.
*/
SELECT 
    STUDENT_NAME AS "�л��̸�",
    NVL(PROFESSOR_NAME,'�������� ������') AS "��������"
FROM 
    TB_STUDENT S
LEFT JOIN
    TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE
    S.DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                      FROM TB_DEPARTMENT
                      WHERE DEPARTMENT_NAME = '���ݾƾ��а�' )
ORDER BY
    STUDENT_NO;

/*
    15. ���л��� �ƴ� �л� �� ������ 4.0 �̻��� �л��� ã�� �� �л��� �й�, �̸�, �а�
    �̸�, ������ ����ϴ� SQL ���� �ۼ��Ͻÿ�.
*/
SELECT 
    STUDENT_NO AS "�й�", 
    STUDENT_NAME AS "�̸�", 
    DEPARTMENT_NAME AS "�а� �̸�", 
    AVG(POINT) AS "����"
FROM
    TB_STUDENT
JOIN
    TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN
    TB_GRADE USING (STUDENT_NO)
WHERE
    ABSENCE_YN = 'N'
GROUP BY 
    STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING
    AVG(POINT) >= 4
ORDER BY
    STUDENT_NO;

/*
    16. ȯ�������а� ����������� ���� �� ������ �ľ��� �� �ִ� SQL ���� �ۼ��Ͻÿ�.
*/ 
SELECT
    CLASS_NO,
    CLASS_NAME,
    AVG(POINT)
FROM
    TB_CLASS
JOIN
    TB_GRADE USING (CLASS_NO)
WHERE
    DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                      FROM TB_DEPARTMENT
                      WHERE DEPARTMENT_NAME = 'ȯ�������а�')
    AND
    CLASS_TYPE LIKE '����%'
GROUP BY
    CLASS_NO,CLASS_NAME
ORDER BY
    CLASS_NO;

/*
    17. �� ������б��� �ٴϰ� �ִ� �ְ��� �л��� ���� �� �л����� �̸��� �ּҸ� ����ϴ�
    SQL ���� �ۼ��Ͻÿ�.
*/
SELECT
    STUDENT_NAME,
    STUDENT_ADDRESS
FROM
    TB_STUDENT
WHERE
    DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                     FROM TB_STUDENT
                     WHERE STUDENT_NAME = '�ְ���');

/*
    18. ������а����� �� ������ ���� ���� �л��� �̸��� �й��� ǥ���ϴ� SQL����
    �ۼ��Ͻÿ�.
*/
SELECT
    STUDENT_NO,
    STUDENT_NAME
FROM
    TB_STUDENT
WHERE
    DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                      FROM TB_DEPARTMENT
                      WHERE DEPARTMENT_NAME = '������а�' )
    AND
    STUDENT_NO IN ( SELECT STUDENT_NO
                    FROM (
                        SELECT STUDENT_NO,
                               AVG(POINT) AS "AVG_SCORE"
                        FROM TB_GRADE
                        JOIN TB_CLASS USING (CLASS_NO)
                        WHERE DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                                                FROM TB_DEPARTMENT
                                                WHERE DEPARTMENT_NAME = '������а�' )
                       GROUP BY STUDENT_NO 
                    )
                    WHERE AVG_SCORE = ( SELECT MAX(AVG(POINT))
                                        FROM TB_GRADE
                                        JOIN TB_CLASS USING (CLASS_NO)
                                        WHERE DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                                                                FROM TB_DEPARTMENT
                                                                WHERE DEPARTMENT_NAME = '������а�' )
                                       GROUP BY STUDENT_NO  )
                  );

/*
    19. �� ������б��� "ȯ�������а�"�� ���� ���� �迭 �а����� �а� �� �������� ������
    �ľ��ϱ� ���� ������ SQL���� ã�Ƴ��ÿ�. �� �������� "�迭 �а���",
    "��������"���� ǥ�õǵ��� �ϰ�, ������ �Ҽ��� �� �ڸ� ������ �ݿø��Ͽ� ǥ�õǵ��� �Ѵ�.
*/
SELECT 
    DEPARTMENT_NAME AS "�迭 �а���",
    ROUND(AVG(POINT),1) AS "��������"
FROM 
    TB_STUDENT
JOIN
    TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN
    TB_GRADE USING(STUDENT_NO)
WHERE CATEGORY = ( SELECT CATEGORY
                    FROM TB_DEPARTMENT
                    WHERE DEPARTMENT_NAME = 'ȯ�������а�' )
GROUP BY DEPARTMENT_NAME
ORDER BY DEPARTMENT_NAME;




 