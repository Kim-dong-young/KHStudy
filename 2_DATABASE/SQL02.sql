/*
    1. ������а�(�а��ڵ� 002) �л����� �й��� �̸�, ���г⵵�� ���� �⵵�� ����
    ������ ǥ���ϴ� SQL ������ �ۼ��Ͻÿ�.( ��, ����� "�й�", "�̸�", "���г⵵" ��
    ǥ�õǵ��� �Ѵ�.)
*/
SELECT STUDENT_NO AS "�й�", 
    STUDENT_NAME AS "�̸�",
    TO_CHAR(ENTRANCE_DATE,'YYYY-MM-DD') AS "���г⵵"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY ENTRANCE_DATE;

/*
    2. �� ������б��� ���� �� �̸��� �� ���ڰ� �ƴ� ������ �� �� �ִٰ� �Ѵ�.
    �� ������ �̸��� �ֹι�ȣ�� ȭ�鿡 ����ϴ� SQL ������ �ۼ��� ����.
    (* �̶�, �ùٸ��� �ۼ��� SQL ������ ��� ���� ����� �ٸ��� ���� �� �ִ�. ������ �������� �����غ� ��)
*/
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE PROFESSOR_NAME NOT LIKE '___';

/*
    3. �� ������б��� ���� �������� �̸��� ���̸� ����ϴ� SQL ������ �ۼ��Ͻÿ�. ��
    �̶� ���̰� ���� ������� ���� ��� ������ ȭ�鿡 ��µǵ��� ����ÿ�.( ��, ���� ��
    2000�� ���� ����ڴ� ������ ��� ����� "�����̸�", "����"�� �Ѵ�. ���̴� '��'����
    ����Ѵ�.)
*/
WITH PRO_AGE AS (
    SELECT
        PROFESSOR_NAME AS "�����̸�",
        TRUNC((MONTHS_BETWEEN(SYSDATE,TO_DATE('19'||SUBSTR(PROFESSOR_SSN,1,6))) / 12)) AS "����"
    FROM TB_PROFESSOR
) SELECT *
FROM PRO_AGE
ORDER BY "����";

/*
    4. �������� �̸� �� ���� ������ �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�. ��� �����
    "�̸�" �� �������� �Ѵ�. (���� 2���� ������ ���ٰ� �����Ͻÿ�)
*/
SELECT SUBSTR(PROFESSOR_NAME,2)
FROM TB_PROFESSOR;

/*
    5. �� ������б��� ����� �����ڸ� ���Ϸ��� �Ѵ�. ��� ã�Ƴ� ���ΰ�? �̶�,
    19�쿡 �����ϸ� ����� ���� ���� ������ �����Ѵ�.
*/
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE MONTHS_BETWEEN(ENTRANCE_DATE,TO_DATE(SUBSTR(STUDENT_SSN,1,6))) / 12 > 19;

/*
    6. 2020�� ũ���������� ���� �����ΰ�?
*/
SELECT TO_CHAR(TO_DATE('20201225'),'DAY')
FROM DUAL;

/*
    7. TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD') �� ����
    �� �� �� �� �� ���� �ǹ��ұ�? �� TO_DATE('99/10/11', 'RR/MM/DD'),
    TO_DATE('49/10/11', 'RR/MM/DD') �� ���� �� �� �� �� �� ���� �ǹ��ұ�?
*/
-- TO_DATE('99/10/11','YY/MM/DD') : 2099�� 10�� 11��
-- TO_DATE('49/10/11','YY/MM/DD') : 2049�� 10�� 11��
-- TO_DATE('99/10/11', 'RR/MM/DD') : 1999�� 10�� 11��
-- TO_DATE('49/10/11', 'RR/MM/DD') : 2049�� 10�� 11��

/*
    8. �� ������б��� 2000�⵵ ���� �����ڵ��� �й��� A�� �����ϰ� �Ǿ��ִ�. 2000�⵵
    ���� �й��� ���� �л����� �й��� �̸��� �����ִ� SQL ������ �ۼ��Ͻÿ�.
*/
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO NOT LIKE 'A%';

/*
    9. �й��� A517178�� �ѾƸ� �л��� ���� �� ������ ���ϴ� SQL ���� �ۼ��Ͻÿ�. ��,
    �̶� ��� ȭ���� ����� "����" �̶�� ������ �ϰ�, ������ �ݿø��Ͽ� �Ҽ��� ����
    ���ڸ� ������ ǥ���Ѵ�.
*/
SELECT ROUND(AVG(POINT),1) AS "����"
FROM TB_GRADE
GROUP BY STUDENT_NO
HAVING STUDENT_NO = 'A517178';

/*
    10. �а��� �л����� ���Ͽ� "�а���ȣ", "�л���(��)" �� ���·� ����� �����
    ������� ��µǵ��� �Ͻÿ�.
*/
SELECT 
    DEPARTMENT_NO AS "�а���ȣ", 
    COUNT(*) AS "�л���(��)"
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

/*
    11. ���� ������ �������� ���� �л��� ���� �� �� ���� �Ǵ��� �˾Ƴ��� SQL ���� �ۼ��Ͻÿ�.
*/
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

/*
    12. �й��� A112113�� ���� �л��� �⵵ �� ������ ���ϴ� SQL���� �ۼ��Ͻÿ�. ��,
    �̶� ��� ȭ���� ����� "�⵵", "�⵵ �� ����" �̶�� ������ �ϰ�, ������ �ݿø��Ͽ�
    �Ҽ��� ���� �� �ڸ� ������ ǥ���Ѵ�.
*/
SELECT 
    SUBSTR(TERM_NO,1,4) AS "�⵵", 
    ROUND(AVG(POINT),1) AS "�⵵ �� ����"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY SUBSTR(TERM_NO,1,4);

/*
    13. �а� �� ���л� ���� �ľ��ϰ��� �Ѵ�. �а� ��ȣ�� ���л� ���� ǥ���ϴ� SQL ������
    �ۼ��Ͻÿ�.
*/
-- 0�� ���� ǥ���� ��
SELECT DEPARTMENT_NO, COUNT(*)
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

/*
    14. �� ���б��� �ٴϴ� �������� �л����� �̸��� ã���� �Ѵ�. � SQL ������ ����ϸ�
    �����ϰڴ°�?
*/
SELECT 
    STUDENT_NAME AS "�����̸�", 
    COUNT(*) AS "������ ��"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(*) > 1
ORDER BY STUDENT_NAME;

/*
    15. �й��� A112113 �� ���� �л��� �⵵, �б⺰ ������ �⵵ �� ���� ����, �� ������
    ���ϴ� SQL���� �ۼ��Ͻÿ�. ( ��, ������ �Ҽ��� 1�ڸ������� �ݿø��Ͽ� ǥ���Ѵ�.)
*/

SELECT -- �б⺰ ����
    SUBSTR(TERM_NO,1,4) AS "�⵵",
    SUBSTR(TERM_NO,5,2) AS "�б�",
    ROUND(AVG(POINT),1) AS "����"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY (SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2))

UNION

SELECT -- �⵵ �� ���� ����
    SUBSTR(TERM_NO,1,4) AS "�⵵",
    NULL AS "�б�",
    ROUND(AVG(POINT),1) AS "����"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)

UNION

SELECT -- �� ����
    NULL AS "�⵵",
    NULL AS "�б�",
    ROUND(AVG(POINT),1) AS "����"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113';
    
