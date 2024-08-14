/*
    <VIEW 뷰>
    
    SELECT문(쿼리문)을 저장해둘 수 있는 객체
    (자주 사용하는 SELECT문을 저장해두면 긴 SELECT문을 매번 다시 기술할 필요 없이 사용할 수 있다.)
    임시테이블 같은 존재(실제 데이터가 담겨있는건 아님 -> 논리 테이블)
*/

-- 한국에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '한국';

-- 러시아에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '러시아';

-- 일본에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '일본';

/*
    1. VIEW 생성방법
    
    [표현식]
    CREATE VIEW 뷰명
    AS 서브쿼리
*/
-- 관리자 계정으로 권한을 부여해주자
-- GRANT CREATE VIEW TO KH;

-- 테이블과 뷰가 사용할 때 헷갈릴 수 있다.
-- 테이블명 : TB_~ ( 혹은 생략 )
-- 뷰명 : VW_~

CREATE VIEW VW_EMPLOYEE
AS ( SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
     FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
     JOIN NATIONAL USING (NATIONAL_CODE) );

SELECT * FROM VW_EMPLOYEE;

-- 실제 실행되는것은 아래와 같이 서브쿼리로 실행된다고 볼 수 있다.
SELECT *
FROM ( SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
       FROM EMPLOYEE
       JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
       JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
       JOIN NATIONAL USING (NATIONAL_CODE) );

-- 한국에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '한국';

-- 러시아에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '러시아';

-- 일본에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '일본';

-- CREATE OR REPLACE를 사용하면 VIEW가 없을 때는 생성, 이미 존재한다면 수정할 수 있다.
CREATE OR REPLACE VIEW VW_EMPLOYEE /* 없으면 CREATE 있으면 REPLACE */
AS ( SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS
     FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
     JOIN NATIONAL USING (NATIONAL_CODE) );

SELECT * FROM VW_EMPLOYEE;

------------------------------------------------------------------------------------
/*
    * 뷰 컬럼에 별칭 부여
    서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술되어있다면 반드시 별칭을 부여해야한다.
*/

CREATE OR REPLACE VIEW VW_EMP_JOB
AS ( SELECT 
         EMP_ID, 
         EMP_NAME, 
         JOB_NAME, 
         DECODE(SUBSTR(EMP_NO,8,1),
                 '1','남자',
                 '2','여자') AS "성별",
         EXTRACT( YEAR FROM SYSDATE ) - EXTRACT( YEAR FROM HIRE_DATE ) AS "근무년수"
     FROM EMPLOYEE
     JOIN JOB USING (JOB_CODE) );

SELECT * FROM VW_EMP_JOB;

SELECT * FROM VW_EMP_JOB
WHERE "근무년수" >= 20;

-- 뷰를 삭제하고 싶을 때
DROP VIEW VW_EMP_JOB;

----------------------------------------------------------------------------
-- 생성된 뷰를 통해서 DML(INSER, UPDATE, DELETE)사용 가능
-- 뷰를 통해서 조작하게되면 실제 데이터가 담겨있는 테이블에 반영이 된다.

CREATE OR REPLACE VIEW VW_JOB
AS ( SELECT JOB_CODE, JOB_NAME
     FROM JOB );

-- 결과는 동일하지만 
SELECT * FROM VW_JOB; -- 논리테이블 ( 실제 데이터가 담겨있지 않다 )
SELECT * FROM JOB;

-- 뷰를 통해서 INSERT
INSERT INTO VW_JOB VALUES('J8','인턴');

-- 뷰를 통해서 UPDATE
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8';

---------------------------------------------------------------------------
/*
    * DML 명령어로 조작이 불가능한 경우가 많다
    
    1) 뷰에 정의되어있지 않은 컬럼을 조작하려고 하는 경우
    2) 뷰에 정의되어있지 않은 컬럼 중에 베이스테이블 상에 NOT NULL 제약조건이 지정되어있는 경우
    3) 산술연산식이나 함수식을 사용한 경우
    4) 그룹함수나 GROUP BY절을 포함한 경우
    5) DISTINCT 구문이 포함된 경우
    6) JOIN을 이용햐서 여러테이블을 연결시켜놓은 경우
    => 그냥 VIEW로 DML 하지마라!! 거의 안쓴다!!
    
    대부분 뷰는 조회를 목적으로 생성한다. 그냥 뷰를 통한 DML은 안쓰는게 좋다.
*/

/*
    VIEW 옵션
    
    [상세표현식]
    CREATE [ OR REPLACE ] [ FORCE | NOFORCE ] VIEW 뷰명
    AS 서브쿼리
    [ WITH CHECK OPTION ]
    [ WITH READ ONLY ];
    
    1) OR REPLACE : 기존에 동일한 뷰가 있을 경우 갱신, 없을 경우 새로 생성
    2) FORCE | NOFORCE
        > FORCE : 서브쿼리에 기술된 테이블이 존재하지 않아도 뷰가 생성되도록해라
        > NOFORCES : 서브쿼리에 기술된 테이블이 존재하는 테이블이어야만 한다( 기본값 )
    3) WITH CHECK OPTION : DML 시 서브쿼리에 기술된 조건에 부합한 값으로만 DML이 가능하도록
    4) WITH READ ONLY : 뷰에 대해서 조회만 가능하도록 ( 수정 X )
*/

-- 2) FORCE | NOFORCE

CREATE OR REPLACE NOFORCE VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
    FROM TT;

-- 서브쿼리에 기술된 테이블이 존재하지 않아도 뷰가 우선은 생기게 된다.

CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
    FROM TT;
    
SELECT * FROM VW_EMP; -- 당연히 안불러와진다

CREATE TABLE TT( -- 뷰를 만들고 테이블 생성을 한다
    TCODE NUMBER,
    TNAME VARCHAR(20),
    TCONTENT VARCHAR2(30)
);

SELECT * FROM VW_EMP; -- 이제 불러와진다

-- 3) WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정시 오류 발생
-- WITH CHECK OPTION 안쓰고

CREATE OR REPLACE VIEW VW_EMP
AS (SELECT *
    FROM EMPLOYEE
    WHERE SALARY >= 3000000);

SELECT * FROM VW_EMP;

-- 200번 사원 급여를 200만원으로 변경( WHERE SALARY >= 3000000 조건에 부합하지 않는 변경 )
UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;

ROLLBACK;

-- WITH CHECK OPTION

CREATE OR REPLACE VIEW VW_EMP
AS (SELECT *
    FROM EMPLOYEE
    WHERE SALARY >= 3000000)
WITH CHECK OPTION;

-- 200번 사원 급여를 200만원으로 변경불가( WHERE SALARY >= 3000000 조건에 부합하지 않는 변경 )
UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;

-- 4) WITH READ ONLY : 뷰에 대해 조회만 가능하도록
CREATE OR REPLACE VIEW VW_EMP
AS SELECT EMP_ID, EMP_NAME, BONUS
    FROM EMPLOYEE
    WHERE BONUS IS NOT NULL
WITH READ ONLY;

SELECT * FROM VW_EMP; -- 가져오는건 가능
DELETE FROM VW_EMP WHERE EMP_ID = 200; -- 수정은 불가능




