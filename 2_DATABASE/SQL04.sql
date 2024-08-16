/*
    1. 계열 정보를 저장할 카테고리 테이블을 만들려고 한다. 다음과 같은 테이블을 작성하시오.
    테이블 이름
        TB_CATEGORY
    컬럼
        NAME VARCHAR2(10)
        USE_YN CHAR(1) 기본값 Y
*/
CREATE TABLE TB_CATEGORY(
    NAME VARCHAR2(10),
    USE_YN CHAR(1) DEFAULT 'Y'
);

/*
    2. 과목 구분을 저장할 테이블을 만들려고 한다. 다음과 같은 테이블을 작성하시오.
    테이블 이름
        TB_CLASS_TYPE
    컬럼
        NO VARCHAR2(5) PRIMARY KEY
        NAME VARCHAR2(10)
*/
CREATE TABLE TB_CLASS_TYPE(
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);

/*
    3. TB_CATEGORY 테이블의 NAME 컬럼에 PRIMARY KEY를 생성하시오.
    (KEY 이름을 생성하지 않아도 무방함, 만약 KEY 이름을 지정하고자 한다면 이름은 본인이
    알아서 적당한 이름을 사용한다.)
*/
ALTER TABLE TB_CATEGORY MODIFY NAME PRIMARY KEY;

/*
    4. TB_CLASS_TYPE 테이블의 NAME 컬럼에 NULL 값이 들어가지 않도록 속성을 변경하시오.
*/
ALTER TABLE TB_CLASS_TYPE MODIFY NAME NOT NULL;

/*
    5. 두 테이블에서 컬럼 명이 NO 인 것은 기존 타입을 유지하면서 크기는 10으로, 컬럼명이
    NAME인 것은 마찬가지로 기존 타입을 유지하면서 크기 20으로 변경하시오.
*/
ALTER TABLE TB_CATEGORY MODIFY NO VARCHAR2(10);
ALTER TABLE TB_CLASS_TYPE MODIFY NO VARCHAR2(10);

ALTER TABLE TB_CATEGORY MODIFY NAME VARCHAR2(20);
ALTER TABLE TB_CLASS_TYPE MODIFY NAME VARCHAR2(20);

/*
    6. 두 테이블의 NO 컬럼과 NAME 컬럼의 이름을 각각 TB_를 제외한 테이블 이름이 앞에 붙은
    형태로 변경한다. (EX. CATEGORY_NAME)
*/
ALTER TABLE TB_CATEGORY RENAME COLUMN NO TO CATEGORY_NO;
ALTER TABLE TB_CLASS_TYPE RENAME COLUMN NO TO CLASS_NO;

ALTER TABLE TB_CATEGORY RENAME COLUMN NAME TO CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE RENAME COLUMN NAME TO CLASS_NAME;

/*
    7. TB_CATEGORY 테이블과 TB_CLASS_TYPE 테이블의 PRIMARY KEY 이름을 다음과 같이
    변경하시오.
    
    PRIMARY KEY의 이름은 "PK_ + 컬럼이름" 으로 지정하시오. EX) PK_CATEGORY_NAME
*/
ALTER TABLE TB_CATEGORY RENAME COLUMN CATEGORY_NAME TO PK_CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE RENAME COLUMN CLASS_NO TO PK_CLASS_NO;

/*
    8. 다음과 같은 INSERT 문을 수행한다.
    INSERT INTO TB_CATEGORY VALUES('공학','Y');
    INSERT INTO TB_CATEGORY VALUES('자연과학','Y');
    INSERT INTO TB_CATEGORY VALUES('의학','Y');
    INSERT INTO TB_CATEGORY VALUES('예체능','Y');
    INSERT INTO TB_CATEGORY VALUES('인문사회','Y');
    COMMIT;
*/
INSERT INTO TB_CATEGORY VALUES('공학','Y');
INSERT INTO TB_CATEGORY VALUES('자연과학','Y');
INSERT INTO TB_CATEGORY VALUES('의학','Y');
INSERT INTO TB_CATEGORY VALUES('예체능','Y');
INSERT INTO TB_CATEGORY VALUES('인문사회','Y');
COMMIT;

/*
    9. TB_DEPARTMENT의 CATEGORY 컬럼이 TB_CATEGORY 테이블의 PK_CATEGORY_NAME 컬럼을 부모
    값으로 참조하도록 FOREIGN KEY를 지정하시오. 이 때 KEY 이름은
    FK_테이블이름_컬럼이름으로 지정한다. EX) FK_DEPARTMENT_CATEGORY
*/
ALTER TABLE TB_DEPARTMENT ADD CONSTRAINT FK_DEPARTMENT_CATEGORY 
FOREIGN KEY(CATEGORY) REFERENCES TB_CATEGORY(PK_CATEGORY_NAME);

/*
    10. 춘 기술대학교 학생들의 정보만이 포함되어 있는 학생일반정보 VIEW를 만들고자 한다.
    아래 내용을 참고하여 적절한 SQL문을 작성하시오.
    
    뷰 이름
        VW_학생일반정보
    컬럼
        학번
        학생이름
        주소
*/
CREATE VIEW VW_학생일반정보 AS(
    SELECT 
        STUDENT_NO,
        STUDENT_NAME,
        STUDENT_ADDRESS
    FROM
        TB_STUDENT
);

/*
    11. 춘 기술대학교는 1년에 두번 씩 학과별로 학생과 지도교수가 지도 면담을 진행한다.
    이를 위해 사용할 학생이름, 학과이름, 담당교수이름 으로 구성되어 있는 VIEW를 만드시오.
    이때 지도 교수가 없는 학생이 있을 수 있음을 고려하시오 ( 단 이 VIEW는 단순 SELECT
    만을 할 경우 학과별로 정렬되어 화면에 보여지게 만드시오. )
    
    뷰 이름
        VW_지도면담
    컬럼
        학생이름
        학과이름
        지도교수이름
*/
CREATE OR REPLACE VIEW VW_지도면담 AS(
    SELECT *
    FROM (
            SELECT
                STUDENT_NAME,
                DEPARTMENT_NAME,
                PROFESSOR_NAME
            FROM
                TB_STUDENT
            JOIN
                TB_DEPARTMENT USING (DEPARTMENT_NO)
            LEFT JOIN
                TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
            ORDER BY
                DEPARTMENT_NAME
        )
);

/*
    12. 모든 학과의 학과별 학생 수를 확인할 수 있도록 적절한 VIEW 를 작성해 보자.
    
    뷰 이름
        VW_학과별학생수
    컬럼
        DEPARTMENT_NAME
        STUDENT_COUNT
*/
CREATE VIEW VW_학과별학생수 AS (
    SELECT
        DEPARTMENT_NAME,
        COUNT(*) AS STUDENT_COUNT
    FROM
        TB_STUDENT
    JOIN
        TB_DEPARTMENT USING (DEPARTMENT_NO)
    GROUP BY
        DEPARTMENT_NAME
);

/*
    13. 위에서 생성한 학생일반정보 VIEW를 통해서 학번이 A213046인 학생의 이름을
    본인 이름으로 변경하는 SQL 문을 작성하시오.
*/
UPDATE 
    TB_STUDENT
SET
    STUDENT_NAME = '김동영'
WHERE
    STUDENT_NO = 'A213046';

/*
    14. 13번에서와 같이 VIEW를 통해서 데이터가 변경될 수 있는 상황을 막으려면 VIEW를
    어떻게 생성해야 하는지 작성하시오.
*/
-- VIEW 생성시 WITH READ ONLY 옵션을 설정한다.

/*
    15. 춘 기술대학교는 매년 수강신청 기간만 되면 특정 인기 과목들에 수강 신청이 몰려
    문제가 되고 있다. 최근 3년을 기준으로 수강인원이 가장 많았던 3 과목을 찾는 구문을
    작성해보시오.
*/
SELECT *
FROM (
    SELECT 
        CLASS_NO AS "과목번호", 
        CLASS_NAME AS "과목이름",
        COUNT(*) AS "누적수강생수(명)"
    FROM
        TB_CLASS
    JOIN
        TB_GRADE USING ( CLASS_NO )
    WHERE
        SUBSTR(TERM_NO ,1,4) IN ( 
        SUBSTR((SELECT MAX(TERM_NO) AS MAX_YEAR FROM TB_GRADE) ,1,4) , 
        SUBSTR((SELECT MAX(TERM_NO) AS MAX_YEAR FROM TB_GRADE) ,1,4) -1, 
        SUBSTR((SELECT MAX(TERM_NO) AS MAX_YEAR FROM TB_GRADE) ,1,4) -2 )
    GROUP BY
        CLASS_NO, CLASS_NAME
    ORDER BY
        "누적수강생수(명)" DESC
) 
WHERE ROWNUM <=3;