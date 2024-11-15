/*
    <INDEX>
    - �ε��� : �����͸� ������ �˻��ϱ� ����, 
              �������� ���İ� Ž���� ���� DBMS�� ���� ����� �������� �����ϴ� ��ü
              �˻��ӵ��� ����. ��, ��� ��쿡 �׻�Ǵ� ���� �ƴ�.
              ������ ������ ����� �÷��� �������� ������ ������ ������ ���ϵ� �� �ִ�.
*/

-- ��ü ������ Ȯ��
SELECT COUNT(*)
FROM USER_MOCK_DATA;

-- USER_MOCK_DATA�� ������ USER_INDEX_DATA ����
CREATE TABLE USER_INDEX_DATA
AS SELECT * FROM USER_MOCK_DATA;

SELECT COUNT(*)
FROM USER_INDEX_DATA;

-- �������� PK �߰� -> PK �߰��ϸ� �ڵ� �ε��� ����
ALTER TABLE USER_INDEX_DATA
ADD CONSTRAINT PK_USER_INDEX_ID PRIMARY KEY(ID);

-- �������� UNIQUE �߰� -> UQ ���� �ڵ� �ε����� ����
ALTER TABLE USER_INDEX_DATA
ADD CONSTRAINT UQ_USER_INDEX_EMAIL UNIQUE(EMAIL);

SELECT * FROM USER_INDEXES;

-- �ε��� ���� �ȵ� ���̺�(USER_MOCK_DATA)
/*
------------------------------------------------------------------------------------
| Id  | Operation         | Name           | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |                |     5 |   665 |   136   (0)| 00:00:02 |
|*  1 |  TABLE ACCESS FULL| USER_MOCK_DATA |     5 |   665 |   136   (0)| 00:00:02 |
------------------------------------------------------------------------------------
COST : ���� ���� ��� -> ���� ���� ���� ���� ������� �˻��� ������ �� �ִ�.
ROWS(CARDINALITY) : ���� ��ȹ���� ACCESS�� ROW ��(���� �����)
BYTES : ���� ��ȹ���� ACCESS�� BYTES ��
TABLE ACCESS FULL : ��ü ���̺��� Ž���Ͽ� ����� �����ϰ� �� ���̴�.
*/
EXPLAIN PLAN FOR
SELECT * FROM USER_MOCK_DATA WHERE ID = 30000;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

-- �ε��� ���� �� ���̺�(USER_INDEX_DATA)
/*
------------------------------------------------------------------------------------------------
| Id  | Operation                   | Name             | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT            |                  |     1 |   133 |     2   (0)| 00:00:01 |
|   1 |  TABLE ACCESS BY INDEX ROWID| USER_INDEX_DATA  |     1 |   133 |     2   (0)| 00:00:01 |
|*  2 |   INDEX UNIQUE SCAN         | PK_USER_INDEX_ID |     1 |       |     1   (0)| 00:00:01 |
------------------------------------------------------------------------------------------------
    INDEX (UNIQUE) SCAN : �ε����� ��ü�� �����Ͽ� Ž�� �� ����� �����ϰ� �� ���� ����
    TABLE ACCESS (BY INDEX ROWID) : �ε��� ��ü�� ������ INDEX_ROWID�� Ž���Ͽ� ����� �����ϰ� �� ���� �����Ѵ�.
*/
EXPLAIN PLAN FOR
SELECT * FROM USER_INDEX_DATA WHERE ID = 30000;

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);

-- �ε��� ����
-- CREATE INDEX USER_INDEX_FIRST_NAME ON USER_INDEX_DATA(FIRST_NAME);
-- ���� �ε��� ����
CREATE INDEX USER_INDEX_FIRST_NAME_ID ON USER_INDEX_DATA(ID, FIRST_NAME);

-- �ε����� ������ �� �÷����� ��ȸ
EXPLAIN PLAN FOR
SELECT *
FROM USER_INDEX_DATA
WHERE ID = 49977
AND FIRST_NAME = 'Gaston';

SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY);