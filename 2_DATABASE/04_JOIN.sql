/*
    <JOIN>
    두 개 이상의 테이블에서 데이터를 조회하고자 할 때, 사용되는 구문
    조회 결과는 하나의 결과(RESULT SET)를 반환한다.
    
    #RESULT SET : 데이터베이스의 결과,
    
    관계형 데이터베이스에서는 최소한의 데이터를 각각의 테이블에 담고 있음
    (무작정 다 조회해 오는게 아니라, 각 테이블간 연결고리(외래키)를 통해 데이터를 매칭시켜 조회해야한다.
    
    JOIN은 크게 "오라클 전용구문" "ANSI 구문" 으로 나뉜다.
    
    [용어정리]
                오라클 전용 구문        |          ANSI 구문
    -------------------------------------------------------------------
                등가 조인              |        내부조인
                (EQUAL JOIN)          |       (INNER JOIN)
    -------------------------------------------------------------------
                포괄조인               |        외부조인    
                LEFT, RIGHT           |        LEFT, RIGHT, FULL
    -------------------------------------------------------------------
                자체조인(비등가조인)     |        JOIN ON
*/

-- 전체 사원들의 사번, 사원명, 부서코드, 부서명 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;

SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;
-- 이 두개를 합쳐보자.

/*
    1. 등가조인(EQUALS JOIN) / 내부조인(INNER JOIN)
    연결시키는 컬럼의 값이 일치하는 행들만 조회(일치하는 값이 없는 행은 조회에서 제외)
*/

-----> ANSI 구문
-- FROM절에 기준이되는 테이블 하나 기술
-- JOIN절에 같이 조인하고자하는 테이블 기술 + 매칭시킬 컬럼에대한 조건 기술
-- JOIN USING / JOIN ON

-- 1. 연결할 두 컬럼명이 다른 경우(EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID)
-- JOIN ON 사용
-- 전체 사원들의 사번, 사원명, 부서코드, 부서명 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 2. 연결할 두 컬럼명이 동일한 경우
-- JOIN USING도 사용
-- 전체 사원들의 사번, 사원명, 직급코드, 직급명 조회

SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);

SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE);

--> 오라클 전용 구문
-- FROM절에 조회하고자하는 테이블들 나열(,로 구분)
-- WHERE절에 매칭시킬 컬럼에대한 조건을 제시

-- 1. 연결할 두 컬럼명이 다른 경우(EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID)
-- 전체 사원들의 사번, 사원명, 부서코드, 부서명 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

-- 2. 연결할 두 컬럼명이 동일한 경우
-- 전체 사원들의 사번, 사원명, 직급코드, 직급명 조회
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

-- 추가적인 조건 제시
-- 직급이 대리인 사원의 사번, 사원명, 직급명, 급여 조회
-- 오라클

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
    AND JOB_NAME = '대리'; -- JOIN 조건과 다른 조건의 구분이 잘 가지 않음

-- ANSI
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';

--============================= 실습 ===================================
-- 1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회

SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE DEPT_TITLE = '인사관리부';

-- 2. DEPARTMENT와 LOCATION 테이블을 참고하여 전체 부서의
--    부서코드, 부서명, 지역코드, 지역명 조회

SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID);

-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회

SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL;

-- 4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON ( DEPT_CODE = DEPT_ID )
WHERE DEPT_TITLE != '총무부';

----------------------------------------------------------------------------
/*
    2. 포괄 조인 / 외부 조인(OUTER JOIN)
    두 테이블 간의 JOIN시, 일치하지 않는 행도 포함시켜 조회 가능
    단, 반드시 LEFT/RIGHT를 지정해야 된다.( 어떤 테이블이 기준이냐 )
*/

-- 외부조인과 비교할만한 내부조인
-- 사원명, 부서명, 급여, 연봉
-- 부서배치를 받지않은 2명의 사원정보 누락됨

-- 1) LEFT [OUTER] JOIN : 두 테이블 중 왼편에 기술된 테이블을 기준으로 JOIN
-- ANSI

SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
LEFT /*OUTER 생략가능*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 오라클

SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);

-- 2) RIGHT [OUTER] JOIN : 두 테이블 중 오른편에 기술된 테이블들을 기준으로 JOIN
--ANSI

SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
RIGHT /*OUTER 생략가능*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 오라클 

SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- FULL [OUTER] JOIN : 두 테이블이 가진 모든 행을 조회할 수 있다.

SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
FULL /*OUTER 생략가능*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

----------------------------------------------------------------------------
/*
    3. 비등가조인(NON EQUAL JOIN)
    매칭시킬 컬럼에 대한 조건 작성시 "="를 사용하지 않는 조인문
    ANSI구문 사용시 JOIN ON만 사용 가능
    주로 이미 완성된 DB에 없는 컬럼을 사용해 조회가 필요할 때 쓴다
*/

-- 사원명, 급여, 급여레벨 조회
-- ANSI
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON (/*조건절 자리*/ SALARY >= MIN_SAL AND SALARY <= MAX_SAL);

-- 오라클
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE, SAL_GRADE
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

----------------------------------------------------------------------------
/*
    4. 자체조인
    같은 테이블을 다시한번 조인하는 경우
*/

-- 전체사원의 사원사번, 사원명, 사원부서코드 --> EMPLOYEE E
--          사수사번, 사수명, 사수부서코드 --> EMPLOYEE M
-- ANSI
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE,
        M.EMP_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID);

--오라클
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE,
        M.EMP_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID(+);

----------------------------------------------------------------------------
/*
    <다중 조인>
    2개 이상의 테이블을 가지고 JOIN할 수 있다.
*/
-- 사번, 사원명, 부서명, 직급명 조회
-- ANSI

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);

-- 오라클

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE E.DEPT_CODE = DEPT_ID
    AND E.JOB_CODE = J.JOB_CODE;

-- 사번, 사원명, 부서명, 지역명 조회

SELECT * FROM EMPLOYEE;   -- DEPT_CODE
SELECT * FROM DEPARTMENT; -- DEPT_ID    LOCATION_ID
SELECT * FROM LOCATION;              -- LOCAL_CODE

-- ANSI
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

----------------------- 실습 ---------------------------
-- 1. 사번, 사원명, 부서명, 지역명, 국가명 조회

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAl_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE);

-- 2. 사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조회

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, SAL_LEVEL
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
JOIN SAL_GRADE ON ( SALARY BETWEEN MIN_SAL AND MAX_SAL );













