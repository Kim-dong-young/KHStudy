/*
    1. 학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고,
    정렬은 이름으로 오름차순 표시하도록 한다.
*/
SELECT 
    STUDENT_NAME AS "학생 이름", 
    STUDENT_ADDRESS AS 주소지
FROM TB_STUDENT
ORDER BY STUDENT_NAME;

/*
    2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오.
*/
SELECT STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
ORDER BY TO_DATE(SUBSTR(STUDENT_SSN,1,6)) DESC;

/*
    3. 주소지가 강원도나 경기도인 학생들 중 1900년대 학번을 가진 학생들의 이름과 학번,
    주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름","학번","거주지 주소"가
    출력되도록 한다.
*/
SELECT
    STUDENT_NAME AS "학생이름",
    STUDENT_NO AS "학번",
    STUDENT_ADDRESS AS "거주지 주소"
FROM TB_STUDENT
WHERE 
    (STUDENT_ADDRESS LIKE '경기%' OR
    STUDENT_ADDRESS LIKE '강원%')
    AND
    STUDENT_NO NOT LIKE 'A%' -- 2000년대 이후 학생은 학번이 A로 시작
ORDER BY STUDENT_NAME;

/*
    4. 현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQL 문장을
    작성하시오. ( 법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아내도록 하자)
*/
SELECT 
    PROFESSOR_NAME,
    PROFESSOR_SSN
FROM 
    TB_PROFESSOR
WHERE 
    DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
                        FROM TB_DEPARTMENT
                        WHERE DEPARTMENT_NAME = '법학과' )
ORDER BY -- 교수는 모두 2000년 이전 출생이다
    TO_DATE('19'||SUBSTR(PROFESSOR_SSN,1,6));
    
/*
    5. 2004년 2학기에 'C3118100' 과목을 수강한 학생들의 학점을 조회하려고 한다.
    학점이 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을
    작성해보시오.
*/





