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












