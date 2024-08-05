/*
    <SELECT>
    SELECT 가져오고싶은 정보(컬럼) FROM 테이블;
    SELECT (*) 또는 컬럼1, 컬럼2, 컬럼3.... FROM 테이블;
    
*/

-- 모든 사원의 모든 정보를 보여줘

SELECT * FROM EMPLOYEE;

-- 모든 사원의 이름, 주민번호, 핸드폰번호

SELECT EMP_NAME, EMP_NO, PHONE FROM EMPLOYEE;

------------ 실습 --------------
-- JOB 테이블의 직급명만 조회

SELECT JOB_NAME FROM JOB;

-- DEPARTMENT 테이블의 모든 컬럼 조회

SELECT * FROM DEPARTMENT;

-- DEPARTMENT 테이블의 부서코드, 부서명 조회

SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT;

-- EMPLOYEE 테이블의 사원명, 이메일, 전화번호, 입사일, 급여 조회

SELECT EMP_ID,EMAIL,PHONE,HIRE_DATE,SALARY FROM EMPLOYEE;

--------------------------------
-- < 컬럼값을 통한 산술 연산 >
-- SELECT절 컬럼명 작성부분에 산술연산을 할 수 있다.
-- EMPLOYEE테이블의 사원명, 사원의 연봉(SALARY * 12)을 조회

SELECT EMP_NAME,SALARY * 12 FROM EMPLOYEE;

-- EMPLOYEE테이블의 사원명, 급여, 보너스, 연봉, 보너스포함연봉( 급여 + (급여 * 보너스) ) * 12

SELECT EMP_NAME, SALARY, BONUS, SALARY * 12 AS YEAR_SALARY, ( SALARY + ( SALARY * BONUS ) ) * 12 AS BONUS_YEAR_SALARY 
FROM EMPLOYEE;

-- 산술연산 과정중에 NULL데이터가 포함되어 있다면 무조건 결과값은 NULL

-- 사원명, 입사일, 근무일수를 조회하자
-- 현재시간 - 입사일 = 근무한 기간
-- DATE - DATE => 결과는 무조건 일로 표기된다
-- 코드실행 시 현재시간을 표시하는 상수 : SYSDATE

SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE FROM EMPLOYEE;

-- SELECT 하려면 반드시 WHERE을 써야한다.
-- 하지만 SYSDATE는 테이블의 변수가 아니다.
-- DUAL : 오라클에서 제공해주는 가상 데이터 테이블

SELECT SYSDATE FROM DUAL;

/*
    <컬럼명에 별칭 지정하기>
    산술연산을 하게 되면 컬럼명이 지저분해진다. 이 때 컬럼명에 별칭을 부여해서 깔끔하게 가져올 수 있다.
    [ 표현법 ]
    컬럼명 별칭 / 컬럼명 AS 별칭 / 컬럼명 "별칭" / 컬럼명 AS "별칭"
*/

SELECT EMP_NAME, 
    (SALARY) AS "급여", 
    BONUS "보너스", 
    SALARY * 12 연봉, 
    ( SALARY + ( SALARY * BONUS ) ) * 12 AS BONUS_YEAR_SALARY 
FROM EMPLOYEE;

/*
    <리터럴>
    임의로 지정한 문자열('')
    조회된 결과의 모든 행에 반복적으로 출력
*/
-- EMPLOYEE 테이블의 사번, 사원명, 급여

SELECT EMP_ID, EMP_NAME, SALARY, '원' AS "단위" FROM EMPLOYEE;

/*
    <연결연산자 : ||>
    여러 컬럼값들을 마치 하나의 컬럼처럼 연결할 수 있다.
*/

-- 사번, 이름, 급여를 하나의 컬럼으로 조회

SELECT EMP_ID || EMP_NAME || SALARY FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 모든 사원의 월급을 조회한다.
-- 다음과 같은 결과가 나오도록 출력해라
-- XX의 월급은 XX원입니다.

SELECT EMP_NAME || '의 월급은' || SALARY || '원입니다.' AS "급여" 
FROM EMPLOYEE;

/*
    <DISTINCT>
    중복제거 - 컬럼에 표시된 값들을 한번씩만 조회하고자 할 때 사용
*/
-- EMPLOYEE의 직급코드 조회

SELECT DISTINCT JOB_CODE FROM EMPLOYEE ORDER BY JOB_CODE;

-- EMPLOYEE의 부서코드 조회(중복 제거)

SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;

-- SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE
-- 위처럼 작성 시 에러가 발생한다. DISTINCT는 한번만 사용 가능하다.

SELECT DISTINCT JOB_CODE, DEPT_CODE 
FROM EMPLOYEE 
ORDER BY JOB_CODE DESC, DEPT_CODE ASC;

-- 위처럼 사용시, (JOB_CODE, DEPT_CODE) 를 쌍으로 묶어서 중복을 제거한 값을 보여준다.
-- 즉, JOB_CODE가 겹치거나 DEPT_CODE가 겹치는건 괜찮지만, JOB_CODE + DEPT_CODE 둘다 겹치는 것은 제거한다

-- ======================================================

/*
    <WHERE 절>
    조회하고자 하는 테이블로부터 특정 조건에 만족하는 데이터만 조회 할 때 사용
    조건식에서도 다양한 연산자 사용이 가능하다.
    [표현법]
    SELECT 컬럼,컬럼,컬럼 연산 등등...
    FROM 테이블
    WHERE 조건;
    
    >>비교연산<<
    >, <, >=, <= : 대소비교
    = : 양쪽이 같다. 등호
    !=, ^=, <> : 양쪽이 다르다. 부등호
*/

-- EMPLOYEE에서 부서코드가 'D5'인 사람들만 조회(모든 컬럼)

SELECT *
FROM EMPLOYEE
WHERE dept_code = 'D5';

-- EMPLOYEE에서 부서코드가 'D9'인 사원들만 조회(모든 컬럼)

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE에서 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회

SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

-- EMPLOYEE에서 부서코드가 'D1'이 아닌 사원들의 사원명, 급여, 부서코드 조회

SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE <> 'D1';

-- 월급이 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회

SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

--------------------------- 실습 ----------------------------
-- 1. 급여가 300만원 이상인 사원들의 사원명, 급여, 입사일, 연봉(별칭 -> 연봉) 조회

SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY * 12 AS 연봉
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. 연봉이 5천만원 이상인 사원들의 사원명, 급여, 연봉(별칭 -> 연봉), 부서코드 조회

SELECT EMP_NAME, SALARY, SALARY * 12 AS 연봉, DEPT_CODE
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000;

-- 3. 직급 코드가 'J3'가 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회

SELECT EMP_ID, EMP_NAME, JOB_CODE, EMP_YN
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';

-- 4. 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
    -- TIP : AND, OR 로 조건을 연결할 수 있다.
    
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;



















