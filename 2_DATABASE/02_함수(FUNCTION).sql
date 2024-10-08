-- 쿼리 실행순서
SELECT EMP_ID, EMP_NAME, SALARY     -- 3 // 컬럼을 고른다
FROM EMPLOYEE                       -- 1 // 테이블은 먼저 불러오고
WHERE DEPT_CODE IS NOT NULL;        -- 2 // 필터링 한 뒤에
-- NULL을 비교할 때는 IS NULL 또는 IS NOT NULL로 해야한다. ( 등호사용 불가 )

/*
    <ORDER BY절>
    SELECT로 가장 마지막 줄에 작성, 실행순서 또한 가장 마지막에 실행한다.
    
    [표현법]
    SELECT 조회할 컬럼...
    FROM 테이블명
    WHERE 조건식
    ORDER BY (정렬기준이 될 컬럼 | 별칭 | 컬럼순번) [ ASC | DESC ] [ NULLS FIRST | NULLS LAST ]
    
    -ASC : 오름차순 [ 1,2,3...9,10 ] -> 기본값
    -DESC : 내림차순 [ 10,9,8...2,1 ]
    
    --NULL은 기본적으로 가장 큰 값으로 분류해서 정렬한다.
    - NULLS FIRST : 정렬하고자하는 컬럼 값에 NULL이 있을 경우 해당 데이터 맨 앞에 배치(DESC일 때 기본값)
    - NULLS LAST : 정렬하고자하는 컬럼 값에 NULL이 있을 경우 해당 데이터 맨 마지막에 배치(ASC일 때 기본값)
*/

SELECT *
FROM EMPLOYEE
-- ORDER BY BONUS; -- 기본값이 오름차순
-- ORDER BY BONUS ASC; -- 동일한 것을 확인 가능하다
-- ORDER BY BONUS ASC NULLS FIRST;
-- ORDER BY BONUS DESC; -- NULLS FIRST 기본값
ORDER BY BONUS DESC, SALARY ASC;
-- 정렬 기준의 컬럼값이 동일할 경우, 그 다음 차순을 위해서 여러개를 제시할 수 있다.

-- 전 사원의 사원명, 연봉(보너스제외) 조회( 이 때, 연봉별 내림차순 정렬)

SELECT EMP_NAME, SALARY * 12 AS 연봉
FROM EMPLOYEE
-- ORDER BY 2 DESC; -- 순번 사용가능, 오라클은 전부 1부터 시작, DB마다 다름
ORDER BY 연봉 DESC;

--===========================================================================
/*
    <함수 FUNCTION>
    전달된 컬럼값을 받아서 함수를 실행한 결과를 반환
    
    -단일행 함수 : N개의 값을 읽어들여서 N개의 결과값을 리턴(매 행마다 함수실행 결과를 반환)
    -그룹 함수 : N개의 값을 읽어들여서 1개의 결과값을 리턴(그룹을 지어서 그룹별로 함수실행 결과를 반환)
    
    >> SELECT 절에 단일행 함수랑 그룹함수를 함께 하지 못함
    -> 결과 행의 개수가 다르기 때문
    
    >> 함수를 사용할 수 있는 위치 : SELECT절 / WHERE절 / ORDER BY절 / HAVING절
*/
--=============================<단일행 함수>=====================================
----------------------------- <문자처리함수> ------------------------------------
/*
    * LENGTH(컬럼 | '문자열') : 해당 문자열의 글자수를 반환
    * LENGTHB(컬럼 | '문자열') : 해당 문자열의 바이트 수를 반환
    
    '최' '나' 'ㄱ' 한글은 글자당 3BYTE
    영문자, 숫자, 특수문자 글자당 1BYTE
*/

SELECT LENGTH('오라클'), LENGTHB('오라클'), 
       LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME)
FROM EMPLOYEE;

---------------------------------------------------------------------

/*
    * INSTR
    문자열로부터 특정 문자의 시작위치를 찾아서 반환
    
    INSTR(컬럼 | '문자열', '찾고자하는 문자', ['찾을 위치의 시작값, 순번']) -> 결과는 NUMBER
*/

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; -- 앞쪽에 있는 첫 B는 3번째에 위치해 있다.
-- 찾을 위치의 시작값 : 1, 순번 1 => 기본값
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- ( -1 ) : 뒤에서부터 찾고, 위치를 읽을 때는 앞에서부터 읽어줌
SELECT INSTR('AABAACAABBAA', 'B', 1,2) FROM DUAL; -- 앞에서 찾고, 두번째 B를 반환
SELECT INSTR('AABAACAABBAA', 'B', 1,3) FROM DUAL; -- 순번을 제시하려면 위치의 시작값을 표시해야한다

SELECT EMAIL, INSTR(EMAIL,'_',1,1), INSTR(EMAIL,'@',1,1)
FROM EMPLOYEE;

---------------------------------------------------------------------

/*
    * SUBSTR
    문자열에서 특정 문자열을 추출해서 반환
    
    [표현법]
    SUBSTR(STRING, POSITION, [LENGTH])
    - STRING : 문자타입 컬럼 | '문자열'
    - POSITION : 문자열 추출할 시작위치 값
    - LENGTH : 추출할 문자 갯수 ( 생략하면 끝까지 )
*/

SELECT SUBSTR('SHOWMETHEMONEY',7) FROM DUAL; -- 7번째 위치부터 끝까지 추출
SELECT SUBSTR('SHOWMETHEMONEY',5,2) FROM DUAL; -- ME
SELECT SUBSTR('SHOWMETHEMONEY',1,6) FROM DUAL; -- SHOWME
SELECT SUBSTR('SHOWMETHEMONEY',-8,3) FROM DUAL; -- 뒤에서부터 8번째부터, 3개를 가져옴 -> THE

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8,1) AS 성별
FROM EMPLOYEE;

-- 사원들중 여사원들만 EMP_NAME, EMP_NO 조회
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) = '2' OR SUBSTR(EMP_NO,8,1) = '4'
ORDER BY EMP_NAME;

-- 함수 중첩사용 가능
-- 이메일 아이디부분 추출
-- 사원목록에서 사원명, 이메일, 아이디 조회
SELECT EMP_NAME, SUBSTR(EMAIL, 1,INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;

---------------------------------------------------------------------

/*
    * LPAD / RPAD
    문자열을 조회할 때 통일감있게 조회하고자 할 때 사용
    
    [표현법]
    LPAD/RPAD(STRING, 최종적으로 반환할 문자열의 길이, [덧붙이고자 하는 문자])
    문자열에 덧붙이고자 하는 문자를 왼쪽 또는 오른쪽에 붙여서 최종 N길이만큼 문자열을 반환
*/
-- 20만큼의 길이중 EMAIL컬럼값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다

SELECT EMP_NAME, LPAD(EMAIL,20)
FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL,20,'#')
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(EMAIL,20,'#')
FROM EMPLOYEE;

-- 사원들의 사원명, 주민등록번호 조회("701011-1XXXXXX")
SELECT EMP_NAME, SUBSTR(EMP_NO,1,8) || 'XXXXXX'
-- SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO,1,8),14,'X')
FROM EMPLOYEE;

---------------------------------------------------------------------

/*
    * LTRIM / RTRIM
    문자열에서 특정 문자를 제거한 나머지를 반환
    LTRIM/RTRIM(STRING, [제거하고자하는 문자들])
    
    문자열의 왼쪽 혹은 오른쪽에서 제거하고자하는 문자들을 찾아서 제거한 나머지 문자열 반환
*/

SELECT LTRIM('     K    H     ') FROM DUAL;
SELECT LTRIM('ACBABCAABCKKH','A') FROM DUAL; -- 왼쪽부터 문자를 제거하다, 다른문자가 나오면 멈춤
SELECT LTRIM('ACBABCAABCKKH','ABC') FROM DUAL; -- 결과 : KKH, 해당하는 문자열이 아니라 문자 A, B, C를 전부 지운다.
SELECT RTRIM('513543213KH1543542', '0123456789') FROM DUAL;

---------------------------------------------------------------------

/*
    * TRIM
    문자열의 앞/뒤 양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
    TRIM([LEADING | TRAILING | BOTH] 제거하고자하는 문자열 FROM 문자열)
*/

SELECT TRIM('      K      H      ') FROM DUAL; -- 양쪽에있는 공백 제거, 기본 BOTH
SELECT TRIM('Z' FROM 'ZZZZZKHZZZZZZ') FROM DUAL;

SELECT TRIM(LEADING 'Z' FROM 'ZZZZZKHZZZZZZ') FROM DUAL; -- LTRIM
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZKHZZZZZZ') FROM DUAL; -- RTRIM

---------------------------------------------------------------------

/*
    * LOWER / UPPER / INITCAP
    LOWER : 다 소문자로 변경한 문자열 반환
    UPPER : 다 대문자로 변경한 문자열 반환
    INITCAP : 띄어쓰기 기준 첫글자마다 대문자로 변경한 문자열 반환
*/

SELECT LOWER('Welcome To My KH') FROM DUAL;
SELECT UPPER('Welcome To My KH') FROM DUAL;
SELECT INITCAP('welcome to my kH') FROM DUAL;

---------------------------------------------------------------------

/*
    * CONACAT
    문자열 두개 전달받아 하나로 합친 후 반환
    CONCAT(STRING1, STRING2)
*/

SELECT CONCAT('가나다','ABC') FROM DUAL;
SELECT '가나다' || 'ABC' FROM DUAL;

---------------------------------------------------------------------

/*
    * REPLACE
    특정 문자열에서 특정 부분을 다른 부분으로 교체
    REPLACE(문자열, 찾을 문자열, 변경할 문자열)
*/

SELECT EMAIL, REPLACE(EMAIL,'KH.or.kr', 'gmail.com')
FROM EMPLOYEE;

--==============================================================================
------------------------------ <숫자 처리 함수> ----------------------------------
/*
    * ABS
    숫자의 절대값을 구해주는 함수
*/
SELECT ABS(-10), ABS(-6.3) FROM DUAL;

---------------------------------------------------------------------

/*
    * MOD
    두 수를 나눈 나머지값을 반환
    MOD(NUMBER, NUMBER)
*/

SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;

---------------------------------------------------------------------

/*
    * ROUND
    반올림한 결과를 반환
    ROUND(NUMBER, [위치])
*/

SELECT ROUND(123.456) FROM DUAL; -- 기본 자리수는 소수점 첫번째 자리에서 반올림
SELECT ROUND(123.456,1) FROM DUAL; -- 양수로 증가할수록 소수점 뒤로 한칸씩 이동
SELECT ROUND(123.456,-1) FROM DUAL; -- 음수로 감소할수록 소수점 앞자리로 이동 -> 3 반올림해서 120

---------------------------------------------------------------------

/*
    * CEIL
    올림처리를 위한 함수
    CEIL(NUMBER)
*/

SELECT CEIL(123.456) FROM DUAL;

---------------------------------------------------------------------

/*
    TRUNC, FLOOR
    버림처리함수
    TRUNC(NUMBER, [위치])
    FLOOR(NUMBER) // 위치조절이 안됨
*/

SELECT TRUNC(123.952) FROM DUAL;
SELECT TRUNC(123.952, 1) FROM DUAL;
SELECT TRUNC(123.952, -1) FROM DUAL;

-------------------- 문제 ----------------------

-- 검색하고자 하는 내용
-- JOB_CODE가 J7이거나 J6이면서 SALARY값이 200만원 이상이고
-- BONUS가 있고 여자이며, 이메일 주소는 _앞에 3글자만 있는 사원의
-- 이름, 주민등록번호, 직급코드, 부서코드, 급여, 보너스를 조회하고싶다

SELECT EMP_NAME, EMP_NO, JOB_CODE, DEPT_CODE, SALARY, BONUS
FROM EMPLOYEE
WHERE ( JOB_CODE = 'J7' OR JOB_CODE = 'J6' ) -- AND 연산자 우선순위가 높기 때문에, OR은 괄호를 쳐주자
    AND SALARY >= 2000000
    AND BONUS IS NOT NULL
    AND (SUBSTR(EMP_NO,8,1) = '2' OR SUBSTR(EMP_NO,8,1) = '4')
    AND LENGTH(SUBSTR( EMAIL, 1, INSTR(EMAIL,'_') - 1 )) = 3;

--=============================================================================
------------------------------ <날짜 처리 함수> ----------------------------------

-- * SYSDATE : 시스템의 현재 날짜 및 시간을 반환
SELECT SYSDATE FROM DUAL;

---------------------------------------------------------------------

-- * MONTHS_BETWEEN : 두 날짜 사이의 개월 수
-- 사원들의 사원명, 입사일, 근무일수, 근무개월 수 조회
SELECT EMP_NAME, 
    HIRE_DATE, 
    FLOOR(SYSDATE - HIRE_DATE),  -- 기본적으로 날짜간 계산의 결과는 일 수
    FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
FROM EMPLOYEE;

---------------------------------------------------------------------

-- * ADD_MONTHS : 특정 날짜에 NUMBER개월수를 더해서 반환
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL;

-- 근로자 테이블에서 사원명, 입사일, 입사후 3개월의 날짜 조회
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 3)
FROM EMPLOYEE;
    
---------------------------------------------------------------------

-- * NEXT_DAY(DATE, 요일(문자 | 숫자)) : 특정날짜 이후 가장 가까운 요일의 날짜를 반환
SELECT NEXT_DAY(SYSDATE, '토요일') FROM DUAL; -- 데이터베이스 설정언어가 한국어라 한국어만 입력 가능
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;

SELECT NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL; -- 언어를 변경하지 않으면 오류가 난다. 변경하면 미국 날짜로 출력됨.

-- 1: 일, ~ 7 : 토
SELECT NEXT_DAY(SYSDATE, 7) FROM DUAL;

-- 언어변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;

----------------------------------------------------------------------

-- * LAST_DAY(DATE) : 해당월의 마지막 날짜 구해서 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

----------------------------------------------------------------------

/*
    * EXTRACT : 특정 날짜로부터 년|월|일 값을 추출해서 반환하는 함수
    
    [표현법]
    EXTRACT(YEAR FROM DATE) : 연도만 추출
    EXTRACT(MONTH FROM DATE) : 월만 추출
    EXTRACT(DAY FROM DATE) : 일만 추출
*/

-- 사원의 사원명, 입사년도, 입사월, 입사일을 조회

SELECT EMP_NAME, 
    EXTRACT(YEAR FROM HIRE_DATE) AS 입사년도,
    EXTRACT(MONTH FROM HIRE_DATE) AS 입사월,
    EXTRACT(DAY FROM HIRE_DATE) AS 입사일
FROM EMPLOYEE
ORDER BY 입사년도, 입사월, 입사일;

--=============================================================================

/*
    [형변환 함수]
    *TO_CHAR : 숫자타입 또는 날짜타입의 값을 문자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_CHAR(숫자|문자, [포맷])
*/
-- 숫자 -> 문자 ( 형식은 대부분 프론트에서 처리해준다 )

SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(12, '99999') FROM DUAL; -- 9의 자리수만큼 공간 확보, 오른쪽 정렬, 자릿수가 쓴 숫자보다 부족하면 깨짐
SELECT TO_CHAR(12, '00000') FROM DUAL; -- 0의 자리수만큼 공간 확보, 빈칸은 0으로 채운다
SELECT TO_CHAR(2000000, 'L9999999') FROM DUAL; -- 현재 설정된 나라의 로컬 화폐단위로 나타냄

SELECT TO_CHAR(3500000, 'L9,999,999') FROM DUAL;

-- 날짜타입 -> 문자타입 ( 꽤 사용한다 )

SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') FROM DUAL; -- HH : 시, MI : 분, SS : 초
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL; -- AM, PM 어떤걸 써도 관계없다, 동일한 결과
SELECT TO_CHAR(SYSDATE, 'PM HH:MI:SS') FROM DUAL; -- 오전인지 오후인지 나타내달라는 형식
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL; -- 시간을 24시간 단위로 표시 ( 1시 -> 13시 )
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY DY') FROM DUAL; -- YYYY: 년, MM : 월, DD : 일, DAY: 수요일, DY : 수(앞글자만)
SELECT TO_CHAR(SYSDATE, 'MON, YYYY') FROM DUAL; -- 포맷을 대체해서 출력할 뿐, 자유롭게 형태를 작성 가능하다
SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일"') FROM DUAL; -- 포맷과 문자를 구분해주기 위해 "" 사용

-- 사원들의 이름, 입사날짜(0000년 00월 00일) 조회

SELECT EMP_NAME, TO_CHAR(HIRE_DATE,'YYYY"년" MON FMDD"일"') AS 입사날짜 -- FM 뒤로 날짜 0 다 제거
FROM EMPLOYEE;

-- 년도와 관련된 포맷

SELECT TO_CHAR(SYSDATE, 'YYYY'),
    TO_CHAR(SYSDATE, 'YY'),
    TO_CHAR(SYSDATE, 'RRRR'), -- RR룰이 따로 존재한다 -> 00~49 => 2000~2049, 50~99 => 1950~1999
    TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

SELECT HIRE_DATE, TO_CHAR(HIRE_DATE, 'YYYY'), TO_CHAR(HIRE_DATE, 'RRRR') FROM EMPLOYEE;

-- 월과 관련된 포맷

SELECT TO_CHAR(SYSDATE,'MM'),
    TO_CHAR(SYSDATE, 'MON'),
    TO_CHAR(SYSDATE, 'MONTH')
FROM DUAL;

-- 일에 관련된 포맷

SELECT TO_CHAR(SYSDATE, 'DDD'), -- 오늘이 이번년도에 몇번째 일수( EX) 8월 7일 -> 365일중에 220일 )
    TO_CHAR(SYSDATE,'DD'), -- 오늘 일자
    TO_CHAR(SYSDATE,'D') -- 요건 요일을 숫자로 1:일 ~ 7:토
FROM DUAL;

-- 요일을 나타내는 포맷

SELECT TO_CHAR(SYSDATE,'DAY'), -- 수요일
    TO_CHAR(SYSDATE,'DY') -- 수 ( 요일 앞글자만 가져옴 )
FROM DUAL;

----------------------------------------------------------------------

/*
    TO_DATE : 숫자타입 또는 문자타입을 날짜타입으로 변경하는 함수
    
    TO_DATE(숫자 | 문자, [포맷]) -> DATE
*/

SELECT TO_DATE(20100101)FROM DUAL;
SELECT TO_DATE(240807) FROM DUAL; -- 주의 : 년도 축약시, 50 넘어가면 1950년으로 표시됨. 걍 년도는 다 써주자

-- SELECT TO_DATE(020505) FROM DUAL; -- 오류 : 숫자는 0으로 시작할 수 없다
SELECT TO_DATE('020505') FROM DUAL; -- 이런 경우는 문자로 써주자

-- SELECT TO_DATE('020505 120500') FROM DUAL -- 포맷을 정해줘야 시,분,초를 표시할 수 있다.
SELECT TO_DATE('020505 120500', 'YYMMDD HH24MISS') FROM DUAL;

----------------------------------------------------------------------

/*
    TO_NUMBER : 문자타입의 데이터를 숫자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_NUMBER(문자, [포맷])
*/
SELECT TO_NUMBER('05123456789') FROM DUAL;

SELECT '100000' + '55000' FROM DUAL; -- 문자로 더해도 자동형변환이 된다.
-- SELECT '100,000' + '55,000' FROM DUAL; 쉼표가 들어가면 완전 문자열이라 판단해 연산 불가능
SELECT TO_NUMBER('100,000','999,999') + TO_NUMBER('55,000','99,999') FROM DUAL; -- 포맷을 지정해줘야한다

--=============================================================================
/*
    [NULL 처리 함수]
*/

-- * NVL(컬럼, 해당컬럼이 NULL일 경우 보여줄 값)
SELECT EMP_NAME, NVL(BONUS,0)
FROM EMPLOYEE;

-- 전 사원의 이름, 보너스포함 연봉 조회
SELECT EMP_NAME,( SALARY * ( 1 + NVL(BONUS,0) )) * 12 AS 연봉
FROM EMPLOYEE;

----------------------------------------------------------------------

-- * NVL2(컬럼, 반환값1, 반환값2)
-- 반환값1 : 해당컬럼이 존재할 경우 보여줄 값
-- 반환값2 : 해당컬럼이 NULL일 경우 보여줄 값

SELECT EMP_NAME, BONUS, NVL2(BONUS, 'O','X')
FROM EMPLOYEE;

----------------------------------------------------------------------

-- * NULLIF(비교대상1, 비교대상2)
-- 두 값이 일치하면 NULL, 일치하지 않으면 비교대상1 반환
SELECT NULLIF('123','123') FROM DUAL; -- NULL 반환
SELECT NULLIF('123','456') FROM DUAL; -- 123 반환

--=============================================================================
/*
    [선택함수]
    * DECODE(비교하고자하는 대상(컬럼, 연산식, 함수식), 비교값1, 결과값1, 비교값2, 결과값2... , DEFAULT )
*/
-- 사번, 사원명, 주민번호, 성별

SELECT EMP_ID, 
    EMP_NAME, 
    EMP_NO, 
    DECODE(SUBSTR(EMP_NO,8,1), -- 비교대상 
        '1','남', -- 1이면 남
        '2','여', -- 2면 여
        '3','남', -- 3이면 남
        '4','여', -- 4면 여
        '외계인') AS "성별" -- 다 해당하지 않을 경우의 DEFAULT값
FROM EMPLOYEE;

-- 직원의 성명, 기존급여, 인상된 급여 조회 * 각 직급별로 인상해서 조회
-- J7인 사원은 급여를 10%인상 ( SALARY * 1.1 )
-- J6인 사원은 급여를 15%인상 ( SALARY * 1.15 )
-- J5인 사원은 급여를 20%인상 ( SALARY * 1.2 )
-- 그외 사원들은 급여를 5%인상 ( SALARY * 1.05 )

SELECT EMP_NAME,
    SALARY AS "인상 전 급여",
    DECODE(JOB_CODE,
        'J7', SALARY * 1.1,
        'J6', SALARY * 1.15,
        'J5', SALARY * 1.2,
        SALARY * 1.05) AS "인상 후 급여"
FROM EMPLOYEE;

----------------------------------------------------------------------

/*
    * CASE WHEN THEN
    
    CASE
        WHEN 조건식 1 THEN 결과값1
        WHEN 조건식 1 THEN 결과값1
        ...
        ELSE 결과값
    END
*/

SELECT EMP_NAME, SALARY,
    CASE
        WHEN SALARY >= 5000000 THEN '고급'
        WHEN SALARY >= 3000000 THEN '중급'
        ELSE '초급'
    END AS "등급"
FROM EMPLOYEE;

--=============================<그룹 함수>=====================================
-- 1. SUM(숫자타입컬럼) : 해당 컬럼 값들의 총 합계를 구해서 반환해주는 함수

-- 근로자 테이블의 전 사원의 총 급여를 구해라

SELECT SUM(SALARY) -- , EMP_NAME : 오류, 그룹함수와 단일행 함수를 같이 쓸순 없다
FROM EMPLOYEE;

-- 남자사원들의 총 급여

SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('1','3');

-- 부서코드가 D5인 사원들의 총 연봉(급여 * 12)

SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

----------------------------------------------------------------------
-- 2. AVG(NUMBER) : 해당 컬럼값들의 평균을 구해서 반환

SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

----------------------------------------------------------------------
-- 3. MIN(모든타입가능) : 해당 컬럼값 중 가장 작은 값을 구해서 반환

SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE)
FROM EMPLOYEE;

----------------------------------------------------------------------
-- 4. MAX(모든타입가능) : 해당 컬럼값 중 가장 큰 값을 구해서 반환

SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

----------------------------------------------------------------------
-- 5. COUNT(* | 컬럼 | DISTINCT 컬럼) : 해당 조건에 맞는 행의 갯수를 세서 반환
-- COUNT(*) : 조회된 결과에 모든 행의 갯수를 세서 반환
-- COUNT(컬럼) : NULL이 아닌 컬람값만 세서 반환
-- COUNT(DISTINCT 컬럼) : 해당 컬럼값 중복을 제거한 후 행의 갯수를 세서 반환

-- 전체 사원 수

SELECT COUNT(*) FROM EMPLOYEE;

-- 여자 사원 수

SELECT COUNT(*)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('2','4');

-- 보너스를 받는 사원 수

SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

SELECT COUNT(BONUS) -- 둘다 동일하다.
FROM EMPLOYEE;

-- 현재 사원들이 총 몇개의 부서에 분포되어 있는지를 구해라

SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;


