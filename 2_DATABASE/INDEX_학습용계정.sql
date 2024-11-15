/*
    <INDEX>
    - 인덱스 : 데이터를 빠르게 검색하기 위한, 
              데이터의 정렬과 탐색과 같은 DBMS의 성능 향상을 목적으로 생성하는 객체
              검색속도가 향상됨. 단, 모든 경우에 항상되는 것은 아님.
              데이터 변경이 빈번한 컬럼을 기준으로 생성시 오히려 성능이 저하될 수 있다.
*/

-- 전체 데이터 확인
SELECT COUNT(*)
FROM USER_MOCK_DATA;

-- USER_MOCK_DATA와 동일한 USER_INDEX_DATA 생성
CREATE TABLE USER_INDEX_DATA
AS SELECT * FROM USER_MOCK_DATA;

SELECT COUNT(*)
FROM USER_INDEX_DATA;

-- 제약조건 PK 추가 -> PK 추가하면 자동 인덱스 생성
ALTER TABLE USER_INDEX_DATA
ADD CONSTRAINT PK_USER_INDEX_ID PRIMARY KEY(ID);

-- 제약조건 UNIQUE 추가 -> UQ 값도 자동 인덱스가 생성
ALTER TABLE USER_INDEX_DATA
ADD CONSTRAINT UQ_USER_INDEX_EMAIL UNIQUE(EMAIL);

SELECT * FROM USER_INDEXES;

-- 인덱스 설정 안된 테이블(USER_MOCK_DATA)
/*
------------------------------------------------------------------------------------
| Id  | Operation         | Name           | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |                |     5 |   665 |   136   (0)| 00:00:02 |
|*  1 |  TABLE ACCESS FULL| USER_MOCK_DATA |     5 |   665 |   136   (0)| 00:00:02 |
------------------------------------------------------------------------------------
COST : 실행 예상 비용 -> 값이 낮을 수록 적은 비용으로 검색을 수행할 수 있다.
ROWS(CARDINALITY) : 실행 계획에서 ACCESS된 ROW 수(예상 결과값)
BYTES : 실행 계획에서 ACCESS된 BYTES 수
TABLE ACCESS FULL : 전체 테이블을 탐색하여 결과를 도출하게 될 것이다.
*/
EXPLAIN PLAN FOR
SELECT * FROM USER_MOCK_DATA WHERE ID = 30000;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

-- 인덱스 설정 된 테이블(USER_INDEX_DATA)
/*
------------------------------------------------------------------------------------------------
| Id  | Operation                   | Name             | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT            |                  |     1 |   133 |     2   (0)| 00:00:01 |
|   1 |  TABLE ACCESS BY INDEX ROWID| USER_INDEX_DATA  |     1 |   133 |     2   (0)| 00:00:01 |
|*  2 |   INDEX UNIQUE SCAN         | PK_USER_INDEX_ID |     1 |       |     1   (0)| 00:00:01 |
------------------------------------------------------------------------------------------------
    INDEX (UNIQUE) SCAN : 인덱스를 객체를 참조하여 탐색 후 결과를 도출하게 될 것을 예상
    TABLE ACCESS (BY INDEX ROWID) : 인덱스 객체로 참조한 INDEX_ROWID로 탐색하여 결과를 도출하게 될 것을 예상한다.
*/
EXPLAIN PLAN FOR
SELECT * FROM USER_INDEX_DATA WHERE ID = 30000;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

-- 인덱스 생성
-- CREATE INDEX USER_INDEX_FIRST_NAME ON USER_INDEX_DATA(FIRST_NAME);
-- 결합 인덱스 생성
CREATE INDEX USER_INDEX_FIRST_NAME_ID ON USER_INDEX_DATA(ID, FIRST_NAME);

-- 인덱스가 생성된 두 컬럼으로 조회
EXPLAIN PLAN FOR
SELECT *
FROM USER_INDEX_DATA
WHERE ID = 49977
AND FIRST_NAME = 'Gaston';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);