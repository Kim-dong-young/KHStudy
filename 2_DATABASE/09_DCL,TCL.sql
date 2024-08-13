/*
    <DCL : 데이터 제어문>
    
    계정에 시스템 권한 또는 객체접근 권한을 부여하거나 회수하는 구문
    
    > 시스템 권한 : DB에 접근하는 권한, 객체를 생성할수 있는 권한 EX ) CONNECT
    > 객체 접근 권한 : 특정 객체들을 조작할 수 있는 권한 EX) RESOURCE
    
    -- 셤 무족권 나오는 부분!! 계정생성
    -- 관리자 계정으로 만들어 준다
    CREATE USER 계정명 IDENTIFIED BY 비밀번호; --> 비밀번호는 대소문자 구분
    GRANT 권한(CONNECT, RESOURCE) TO 계정;
*/

SELECT *
FROM ROLE_SYS_PRIVS;

/*
    <TCL : 트랜잭션 제어문>
    - 데이터베이스의 논리적 연산단위
    - 데이터의 변경사항(DML)등을 하나의 트랜잭션에 묶어서 처리
      DML문 한개를 수행할 때 트랜잭션이 존재하지 않는다면 트랜잭션을 만들어서 묶음
                          트랜잭션이 존재한다면 해당 트랜잭션에 묶어서 처리
    COMMIT하기 전까지의 변경사항들을 하나의 트랜잭션에 담는다.
    - 트랜잭션의 대상이 되는 SQL : INSERT, UPDATE, DELETE
    
    COMMIT(트랜잭션 종료 처리 후, 확정)
    ROLLBACK(트랜잭션에 있는 작업을 취소)
    SAVEPOINT(임시저장)
    
    - COMMIT : 한 트랜잭션에 담겨있는 변경사항들을 실제 DB에 반영시키겠다는 의미
    - ROLLBACK : 한 트랜잭션에 담겨있는 변경사항들을 삭제(취소)한 후 마지막 COMMIT 시점으로 돌아감
    - SAVEPOINT 포인트명 : 현재 시점에 해당 포인트명으로 임시저장 해주겠다.
*/

DROP TABLE EMP_01;

CREATE TABLE EMP_01
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID));

SELECT * FROM EMP_01;

-- 사번이 200, 201번인 사람 삭제
DELETE FROM EMP_01
WHERE EMP_ID IN (200, 201);

SELECT * FROM EMP_01;

ROLLBACK;

SELECT * FROM EMP_01;

---------------------------------------------------
-- 사번이 200, 201번인 사람 삭제
DELETE FROM EMP_01
WHERE EMP_ID IN (200, 201);

COMMIT; -- 이 시점에서 데이터베이스에 반영이 된다.
ROLLBACK; -- 즉, 롤백해도 사라진 데이터는 안돌아온다.
SELECT * FROM EMP_01;

----------------------------------------------------

DELETE FROM EMP_01 -- 트랜잭션에 하나 쌓였다. -- 217,216,214 삭제
WHERE EMP_ID IN (217,216,214);

SELECT * FROM EMP_01; -- 우리에게 보여주는 부분엔 없지만, DB에는 여전히 남아있는 상태

SAVEPOINT SP; -- 트랜잭션에 쌓인다

INSERT INTO EMP_01 VALUES(801,'김말동','기술지원부'); -- 트랜잭션에 하나 더 쌓인다 - 801 추가

DELETE FROM EMP_01
WHERE EMP_ID = 210; -- 트랜잭션에 계속 쌓인다 - 210 삭제

SELECT * FROM EMP_01;

ROLLBACK TO SP; -- 세이브포인트로 돌아간다 -> 210 삭제, 801 추가는 취소된다
COMMIT; -- 217,216,214 삭제가 반영된다.

----------------------------------------------------
-- DML 실행 후
DELETE FROM EMP_01
WHERE EMP_ID = 210;

-- DDL문 실행 -- 실행하는 순간 트랜잭션이 모두 COMMIT 된다.
CREATE TABLE TEST(
    TID NUMBER
);
-- DDL로 데이터 구조가 바뀌면, 지금까지 수행한 결과가 수행이 안될수도 있다
-- 따라서 일단 COMMIT한 후에 DDL을 실행한다.

ROLLBACK; -- 롤백해도 돌아오지 않는다

SELECT * FROM EMP_01 WHERE EMP_ID = 210; -- 210이 사라진걸 확인가능
-- DDL문(CREATE, ALTER, DROP)을 수행하는 순간 기존 트랜잭션에 있던 변경사항들은
-- 무조건 COMMIT이 된다. ( 실제 DB에 반영된다.)
-- 즉, DDL문 수행 전 변경사항들이 있다면 정확하게 픽스하고 진행해라.











