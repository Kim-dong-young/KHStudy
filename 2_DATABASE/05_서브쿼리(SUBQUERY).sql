/*
    * ��������
    - �ϳ��� SQL�� �ȿ� ���Ե� �� �ٸ� SELECT��
    - ���� SQL���� ���� ���� ������ �ϴ� ����
*/

-- �������� ����1) ���ö ����� ���� �μ��� ���� ����� ��ȸ

SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- ���ö����� ��μ��ϱ�?

SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';

-- ���� �� ������ �ϳ��� ������ ��������

SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = ( SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '���ö')
    AND EMP_NAME != '���ö';
    
-- �������� ����2)
-- �� ������ ��ձ޿����� �� ���� �޿��� �޴� ������� ���, �̸�, �����ڵ�, �޿� ��ȸ
-- 1) �� ������ ��ձ޿��� ���ϱ�?

SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

-- 2) 3047663���� �޿��� ���� ������� ���,�̸�, �����ڵ�, �޿� ��ȸ

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3047663;

-- �� ������ �ϳ��� ���غ���.

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= ( SELECT ROUND(AVG(SALARY))
                  FROM EMPLOYEE );
                    
/*
    * ���������� ����
    ���������� ������ ������� ���� ��� �������Ŀ� ���� �з�
    
    -- ������ �������� : ���������� ��ȸ ������� ���� 1���� ��
    -- ������ �������� : ���������� ��ȸ ������� ���� ���� ��( ���� ��, �� �� )
    -- ���߿� �������� : ���������� ��ȸ ������� �� �������� �÷��� ������ �� ��
    -- ������ ���߿� �������� : ���������� ��ȸ ������� ���� �� ���� �÷��� ��
    
    >> ���������� ������� ���� �������� �� �ʿ� �����ڰ� �޶�����.
*/

/*
    1. ������ ��������
    ���������� ��ȸ ������� ������ 1���� ��( �� ��, �� �� )
    �Ϲ� �񱳿����� ��� ����
    =, !=, >, <= ....
*/

-- 1) �� ������ ��� �޿����� �޿��� �� ���Թ޴� ������� �����, �����ڵ�, �޿� ��ȸ

SELECT EMP_NAME,JOB_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY < ( SELECT AVG(SALARY)
                 FROM EMPLOYEE );
                    
-- 2) �����޿��� �޴� ����� ���, �̸�, �޿�, �Ի��� ��ȸ

SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = ( SELECT MIN(SALARY)
                 FROM EMPLOYEE );

-- 3) ���ö ����� �޿����� ���̹޴� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > ( SELECT SALARY
                 FROM EMPLOYEE
                 WHERE EMP_NAME = '���ö' );

-- 4) ���ö ����� �޿����� ���̹޴� ������� ���, �̸�, �μ���, �޿� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE SALARY > ( SELECT SALARY
                 FROM EMPLOYEE
                 WHERE EMP_NAME = '���ö' );

-- 5) �μ��� �޿����� ���� ū �μ��� �μ��ڵ�, �޿���

SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = ( SELECT MAX(SUM(SALARY))
                       FROM EMPLOYEE
                       GROUP BY DEPT_CODE );

-- 6) '������'����� ���� �μ��� ������� ���, �����, ��ȭ��ȣ, �Ի���, �μ��� ��ȸ
-- ��, ��������� ����

SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = ( SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������' )
    AND EMP_NAME != '������';

-----------------------------------------------------------------------------
/*
    2. ������ ��������
    ���������� ������ ������� ���� ���� ��( �÷��� �� �� )
    
    IN (��������) : ���������� ����� �� �Ѱ��� ��ġ�ϴ� ���� �ִٸ� ��ȸ;
    
    > ANY (��������) : �������� ����� �߿��� �Ѱ��� Ŭ ��� ��ȸ
    < ANY (��������) : �������� ����� �߿��� �Ѱ��� ���� ��� ��ȸ
        �񱳴�� > ANY ( ���������� ����� -> ��1, ��2, ��3... )
        
    > ALL (��������) : �������� ��� ������� ���� Ŭ ��� ��ȸ
    < ALL (��������) : �������� ��� ������� ���� ���� ��� ��ȸ
*/

-- 1) ����� �Ǵ� ������ ����� ���� ������ ������� ���, �����, �����ڵ�, �޿� ��ȸ
-- 1_1. ����� �Ǵ� ������ ����� ������?

SELECT JOB_CODE 
FROM EMPLOYEE
WHERE EMP_NAME = '�����' OR EMP_NAME = '������';

-- 1_2. ������ J3, J7�� ������� ���, �����, �����ڵ�, �޿� ��ȸ

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN ('J3','J7');

-- �� ������ �ϳ��� ���ĺ���

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN( SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN ('�����','������') );

-- 2) �븮�����ӿ��� ���� ���� �޿��� �� �ּ� �޿����� ���̹޴� ������� ���, �̸�, ����, �޿� ��ȸ
-- 2_1. ���� ���� �޿���

SELECT SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '����';

-- 2_2) �븮�����̸鼭 ���� ��������� �ϳ��� ū ���

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮'
    AND SALARY > ANY ( 3760000, 2200000, 2500000 );
    
-- �� ������ ���ĺ���

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮'
    AND SALARY > ANY ( SELECT SALARY
                       FROM EMPLOYEE
                       JOIN JOB USING (JOB_CODE)
                       WHERE JOB_NAME = '����' );

--------------------------------------------------------------------------
/*
    3. ���߿� ��������
    ������� �� ��������, ������ �÷����� �������� ���
*/

-- 1) ������ ����� ���� �μ��ڵ�, ���� �����ڵ忡 �ش��ϴ� ����� ��ȸ
-- (�����, �μ��ڵ�, �����ڵ�, �Ի���)
--> ������ ���������� �غ���

SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = ( SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������' )
    AND JOB_CODE = ( SELECT JOB_CODE
                     FROM EMPLOYEE
                     WHERE EMP_NAME = '������' );
                     
--> ���߿� ��������

SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = ( SELECT DEPT_CODE, JOB_CODE -- ������ ���缭 ���Ѵ�
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '������' );

-- �ڳ��� ����� ���� ���� �ڵ�, ���� ����� ������ �ִ� ������� ���, �����, �����ڵ�, �����ȣ ��ȸ

SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = ( SELECT JOB_CODE, MANAGER_ID
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '�ڳ���' )
    AND EMP_NAME != '�ڳ���';

--------------------------------------------------------------------------
/*
    4. ������ ���߿� ��������
    ���������� ��ȸ ������� ������ �������� ���
*/
-- 1) �� ���޺� �ּұ޿��� �޴� ��� ��ȸ(���, �����, �����ڵ�, �޿�)
--> �� ���޺� �ּұ޿���?

SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

--> �� ���޺� �ּұ޿��� �޴� ��� ��ȸ(���, �����, �����ڵ�, �޿�)

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J2' AND SALARY = 3700000
   OR JOB_CODE = 'J7' AND SALARY = 1380000
   OR JOB_CODE = 'J3' AND SALARY = 3400000
   OR JOB_CODE = 'J6' AND SALARY = 2000000
   OR JOB_CODE = 'J5' AND SALARY = 2200000
   OR JOB_CODE = 'J1' AND SALARY = 8000000
   OR JOB_CODE = 'J4' AND SALARY = 1550000;

--> �� ������ �ϳ��� ���ĺ���

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN ( SELECT JOB_CODE, MIN(SALARY)
                              FROM EMPLOYEE
                              GROUP BY JOB_CODE );

-- �� �μ��� �ְ�޿��� �޴� ������� ���, �����, �μ��ڵ�, �޿� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE,SALARY) IN ( SELECT DEPT_CODE, MAX(SALARY)
                              FROM EMPLOYEE
                              GROUP BY DEPT_CODE );

-- <�������� ��������>
-- 1. �μ� �� �޿� �հ谡 ��ü �޿� �� ���� 20%���� ���� �μ��� �μ� ��, �μ� �� �޿� �հ� ��ȸ

SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) >= ( SELECT SUM(SALARY) * 0.2
                        FROM EMPLOYEE );

-- 2. ���� �� ���� ������ ��� �ڵ�, ��� ��, ����, �μ� ��, ���� �� ��ȸ

SELECT EMP_ID, EMP_NAME,
    EXTRACT(YEAR FROM SYSDATE) - 
    CASE
        WHEN SUBSTR(EMP_NO, 1,2) <= TO_CHAR(SYSDATE, 'YY') THEN
            2000 + TO_NUMBER(SUBSTR(EMP_NO,1,2))
        ELSE
            1900 + TO_NUMBER(SUBSTR(EMP_NO,1,2))
    END + 1 AS "����",
    DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE EXTRACT(YEAR FROM SYSDATE) - 
    CASE
        WHEN SUBSTR(EMP_NO, 1,2) <= TO_CHAR(SYSDATE, 'YY') THEN
            2000 + TO_NUMBER(SUBSTR(EMP_NO,1,2))
        ELSE
            1900 + TO_NUMBER(SUBSTR(EMP_NO,1,2))
    END + 1 = (SELECT MIN(EXTRACT(YEAR FROM SYSDATE) - 
                    CASE
                        WHEN SUBSTR(EMP_NO, 1,2) <= TO_CHAR(SYSDATE, 'YY') THEN
                            2000 + TO_NUMBER(SUBSTR(EMP_NO,1,2))
                        ELSE
                            1900 + TO_NUMBER(SUBSTR(EMP_NO,1,2))
                    END + 1)
                FROM EMPLOYEE);

-- WITH�� ���

WITH EMP_AGE AS (
    SELECT
        EMP_ID,
        EMP_NAME,
        EXTRACT(YEAR FROM SYSDATE) - CASE
        WHEN SUBSTR(EMP_NO, 1,2) <= TO_CHAR(SYSDATE, 'YY') THEN
            2000 + TO_NUMBER(SUBSTR(EMP_NO,1,2))
        ELSE
            1900 + TO_NUMBER(SUBSTR(EMP_NO,1,2))
        END + 1 AS "����",
        DEPT_TITLE,
        JOB_NAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN JOB USING (JOB_CODE)
)
SELECT *
FROM EMP_AGE
WHERE ���� = ( SELECT MIN(����)
                FROM EMP_AGE );

-- RR ���

SELECT EMP_ID, 
    EMP_NAME,
    FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) / 12) + 1 AS ����,
    DEPT_TITLE,
    JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) / 12) + 1 = 
    ( SELECT MIN(FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) / 12) + 1)
      FROM EMPLOYEE );

--==========================================================================
/*
    5. �ζ��� ��
    FROM���� ���������� �ۼ��ϴ� ��
    ���������� ������ ����� ��ġ ���̺�ó�� ���
*/

-- ������� ���, �̸�, ���ʽ����� ����, �μ��ڵ� ��ȸ
-- ��, ���ʽ� ���� ������ NULL�� �Ǹ� �ȵȴ�.
-- ��, ���ʽ� ���� ������ 3000���� �̻��� ����鸸 ��ȸ

SELECT EMP_ID,
    EMP_NAME,
    SALARY * ( 1 + NVL(BONUS,0) ) * 12 AS "����",
    DEPT_CODE
FROM EMPLOYEE
WHERE ( SALARY + ( SALARY * NVL(BONUS,0) )) * 12  >= 30000000
ORDER BY ���� DESC;

-- ROWNUM : ����Ŭ���� �����ϴ� �÷�, ��ȸ�� ������� 1���� ������ �ο��Ѵ�.
-- ������ ������, ����Ŭ�� �׻� �ҷ����� �ڵ����� �ο����ش�.
-- FROM���� �������� ���� �ٷ� �ο��Ѵ�.
-- ���� �������� ORDER BY�� �����ϸ� ���̰� �ȴ�.

SELECT ROWNUM,
    EMP_ID,
    EMP_NAME,
    SALARY * ( 1 + NVL(BONUS,0) ) * 12 AS "����",
    DEPT_CODE
FROM EMPLOYEE
WHERE ( SALARY + ( SALARY * NVL(BONUS,0) )) * 12  >= 30000000
ORDER BY ���� DESC;

--> �� ���� �� �޿��� ���� ���� 5�� ��ȸ
-- ROWNUM�� �̿��� ����

SELECT ROWNUM, EMP_NAME, SALARY
FROM ( 
        SELECT EMP_NAME,
            SALARY
        FROM EMPLOYEE
        ORDER BY SALARY DESC 
     )
WHERE ROWNUM <= 5;

--> �ζ��� �並 �ַ� ����ϴ� �� >> TOP-N �м� : ���� ��� ��ȸ
--> ORDER BY ���� ����� ����� ������ ROWNUM �ο� -> ���� 5�� ��ȸ

-- ���� �ֱٿ� �Ի��� ��� 5�� ��ȸ(�����, �޿�, �Ի���)

SELECT *
FROM (
        SELECT EMP_NAME, SALARY, HIRE_DATE
        FROM EMPLOYEE
        ORDER BY HIRE_DATE DESC
     )
WHERE ROWNUM <= 5;

-- �μ��� ��� �޿��� ���� 3���� �μ� ��ȸ

SELECT *
FROM (
        SELECT 
            DEPT_TITLE,
            ROUND(AVG(SALARY)) AS "��� �޿�"
        FROM 
            EMPLOYEE
        JOIN
            DEPARTMENT ON ( DEPT_CODE = DEPT_ID )
        GROUP BY 
            DEPT_TITLE
        ORDER BY 
            "��� �޿�" DESC
     )
WHERE ROWNUM <= 3;

----------------------------------------------------------------------------
/*
    *������ �ű�� �Լ� ( WINDOW FUNCTION )
    RANK() OVER(���ı���) | DENSE_RANK() OVER(���ı���)
    RANK() OVER(���ı���) : ������ ���� ������ ����� ������ �ο��� ��ŭ �ǳʶٰ� ���� ���
    DANSE_RANK() OVER(���ı���) : ������ ������ �ִٰ� �ص�, �� ���� ����� ������ 1�� ����
    
    ������ SELECT�������� ���
*/
-- �޿��� ���� ������� ������ �Űܼ� ��ȸ

SELECT 
    EMP_NAME, 
    SALARY, 
    RANK() OVER(ORDER BY SALARY DESC) AS "����"
FROM EMPLOYEE;

SELECT 
    EMP_NAME, 
    SALARY, 
    DENSE_RANK() OVER(ORDER BY SALARY DESC) AS "����"
FROM EMPLOYEE;

-- �޿��� ���� ������� 5��

SELECT *
FROM (
        SELECT 
            EMP_NAME, 
            SALARY, 
            RANK() OVER(ORDER BY SALARY DESC) AS "����"
        FROM 
            EMPLOYEE
    )
WHERE ���� <= 5;


