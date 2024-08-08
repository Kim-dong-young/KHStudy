/*
    <GROUP BY��>
    �׷� ������ ������ �� �ִ� ���� (�ش� �׷� ���غ��� ���� �׷����� ���� �� ����)
    �������� ������ �ϳ��� �׷����� ��� ó���ϴ� �������� ���
*/

SELECT SUM(SALARY)
FROM EMPLOYEE; -- ��ü ����� �ϳ��� �׷����� ���, �� ���� ���� ��

-- �� �μ����� �޿� ����
-- �� �μ����� ���� �׷�

SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �� �μ��� ��� ��

SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- ###���� ������ ���� ������ �ִٸ� ������?###

SELECT DEPT_CODE, COUNT(*), SUM(SALARY) -- 3
FROM EMPLOYEE -- 1
GROUP BY DEPT_CODE -- 2
ORDER BY DEPT_CODE; -- 4, ������ ������ ������ ���� -> ������ �������� ���ִ� ���� �ƴϸ� �ǹ̰� X

-- �� ���޺� �� �����, ���ʽ��� �޴� ��� ��, �޿� ��, ��� �޿�, ���� �޿�, �ְ� �޿�( ���� = ���� ��������)

SELECT 
    JOB_CODE AS "����",
    COUNT(*) AS "�� �����",
    COUNT(BONUS) AS "���ʽ��� �޴� ��� ��",
    SUM(SALARY) AS "�޿� ��",
    ROUND(AVG(SALARY)) AS "��� �޿�",
    MIN(SALARY) AS "���� �޿�",
    MAX(SALARY) AS "�ְ� �޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- GROUP BY���� �Լ��� ��� ����

SELECT 
    DECODE( 
        SUBSTR(EMP_NO,8,1),
        1,'��',
        2,'��'
    ) AS ����
    , COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO,8,1);

-- GROUP BY���� ���� �÷��� ����� �� �ִ�.
-- ���� �÷� ��� ��, DEPT_CODE, JOB_CODE �� ������ ���ո�ŭ �׷��� ������ ��

SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

--===========================================================================
/*
    [HAVING ��]
    �׷쿡 ���� ������ ������ �� ���Ǵ� ����(�ַ� �׷��Լ����� ������ ������ �����.)
*/

-- �� �μ��� ��� �޿�(�μ��ڵ�, ��ձ޿�)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �� �μ��� ��� �޿��� 300���� �̻��� �μ��鸸 ��ȸ
/*
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE ROUND(AVG(SALARY)) >= 3000000;
GROUP BY DEPT_CODE
���� ������ �����غ���. FROM->WHERE->GROUP �̹Ƿ�
���� ��ü�� �ȵ�����, ����ȴ� �ѵ� �������� ������ 300������ ����鸸 �̾�
�׷����� ����� ���̴�.
*/

SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING ROUND(AVG(SALARY)) >= 3000000;

-- ���޺� �����ڵ�, �ѱ޿���(��, ���޺� �޿����� 1000���� �̻��� ���޸� ��ȸ)

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

-- �μ��� ���ʽ��� �޴� ����� ���� �μ��� �ڵ�

SELECT DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

------------------------------------------------------------------------------
/*
    ���ݱ��� ���͵��� �����غ���.
                                                                     [ ������� ]
    SELECT * | ��ȸ�ϰ���� �÷��� | �Լ��� | �������                        -5
    FROM ��ȸ�ϰ���� ���̺� | DUAL                                        -1
    WHERE ���ǽ�                                                         -2
    GROUP BY �׷��� ������ �Ǵ� �÷� | �Լ���                                -3
    HAVING �׷��� ���ǽ�                                                  -4
    ORDER BY �÷� | ��Ī | ���� [ ASC | DESC ] [NULLS FIRST | NULLS LAST] -6
*/

------------------------------------------------------------------------------
/*
    ���տ�����
    �������� �������� �ϳ��� ���������� ����� ������
    - UNION : OR | ������( �� ������ ������ ������� ���Ѵ� )
    - INTERSECT : AND | ������( �� ������ ������ ������� ������ �κ��� ���Ѵ� )
    - UNION ALL : ������ + ������ ( �ߺ� ������� ���� ���ϱ� )
    - MINUS : ������( ���� ������� ���� ������� �� ������ )
*/

-- 1. UNION

-- �μ��ڵ尡 D5�� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- �޿��� 3000000�� �ʰ��� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- �μ��ڵ尡 D5�� ����Ǵ� �޿��� 3000000�� �ʰ��� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

/*
����� ����������, ������ ���߿� ���������ٸ� UNION���� �̹� �ۼ��� ������ ������ ���°� ����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
    OR SALARY > 3000000;
*/

-- 2. INTERSECT(������)
-- �μ��ڵ尡 D5�̸鼭�� �޿��� 300���� �ʰ��� ������� ���,�̸�,�μ��ڵ�,�޿� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

------------------------------------------------------------------------------
-- ���տ����� ���� ���ǻ���
/*
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY > 3000000;

=> �÷��� ������ �����ؾ��Ѵ�, ������� ����

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, SALARY, DEPT_CODE, EMP_NAME
FROM EMPLOYEE
WHERE SALARY > 3000000;

=> �÷� �ڸ����� ������ Ÿ���� �;��Ѵ�, ����
=> Ÿ�Ը� �����ϸ� �׳� ���Ĺ����⿡, ����

+ �����ϰ�ʹٸ�, ORDER BY�� �������� ����Ѵ�.
*/

-- 3. UNION ALL : �������� ���� ����� ������ �� ���Ѵ�(�ߺ� ���X)

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 4. MINUS : ���� SELECT ������� ���� SELECT ����� �� ������

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;



