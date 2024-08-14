/*
    <시퀀스 SEQUENCE>
    자동으로 번호를 발생시켜주는 역할을 하는 객체
    정수값을 순차적으로 일정하게 증가시키면서 생성해준다.
    
    EX) 회원번호, 사원번호, 게시글번호... 등등 PRIMARY KEY로 사용
*/

/*
    1. 시퀀스 객체 생성
    
    [표현식]
    CREATE SEQUENCE 시퀀스명
    [START WITH 시작순서] -> 처음 발생시킬 시작값 지정(기본값 1)
    [INCREMENT BY 숫자] -> 몇씩 증가시킬 건지(기본값 1)
    [MAXVALUE 숫자] -> 최대값 지정(기본값은 매우크다)
    [MINVLAUE 숫자] -> 최소값 지정(기본값 1)
    [CYCLE | NOCYCLE] -> 값 순환 여부 ( 기본값 NOCYCLE , MAX 도달했을 때, 다시 MIN부터 순환할건지 )
    [CACHE 바이트크기 | NOCACHE] -> 캐시메모리 할당( 기본값 CACHE 20 )
    
    * 캐시메모리 : 미리 발생될 값들을 생성해서 저장해두는 공간
                 매번 호출될때마다 새로운 번호를 생성하는게 아니라
                 캐시메모리공간에 미리 생성된 값들을 가져다 쓸 수 있다. ( 속도가 빨라진다 )
    
    테이블명 : TB_ ( 혹은 생략 )
    뷰명 : VW_
    시퀀스 : SEQ_
    트리거 : TRG_
*/

CREATE SEQUENCE SEQ_TEST;

-- [참고] 현재 계정이 소유한 시퀀스들의 구조를 보고싶을때
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

/*
    2. 시퀀스 사용
    
    시퀀스명.CURRVAL : 현재 시퀀스값(마지막으로 성공한 NEXTVAL의 수행값)
    시퀀스명.NEXTVAL : 시퀀스값에 일정할 값을 증가시켜 발생한 값
                     현재 시퀀스 값에 INCREMENT BY 값 만큼 증가한 값
*/

SELECT * FROM USER_SEQUENCES;
-- 한번도 NEXTVAL이 수행된적 없으면 CURRVAL를 할 수 없음.
-- 왜? CURRVAL은 현재 값이 아닌 마지막으로 성공한 NEXVAL 한 값을 저장해서 보여주는 임시 값
SELECT SEQ_EMPNO.CURRVAL FROM DUAL;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 마지막으로 수행된 값 = 300
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 315로 최대값 310 초과 => 에러

/*
    3. 시퀀스의 구조 변경
    ALTER SEQUENCE 시퀀스
    [INCREMENT BY 숫자]
    [MAXVALUE 숫자]
    [MINVALUE 숫자]
    [CYCLE | NOCYCLE]
    [CACHE 바이트크기 | NOCACHE]
    
    * START WITH는 변경불가 => 이미 시작했으니까
*/

ALTER SEQUENCE SEQ_EMPNO
INCREMENT BY 10
MAXVALUE 400;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 320이 잘 나온다

-- 4. 시퀀스 삭제
DROP SEQUENCE SEQ_EMPNO;

------------------------------------------------------------------------
-- 사원번호로 사용할 시퀀스
CREATE SEQUENCE SEQ_EID
START WITH 400
NOCACHE;

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
            VALUES(SEQ_EID.NEXTVAL, '김말똥', '111111-2111111', 'J6', SYSDATE);

SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
            VALUES(SEQ_EID.NEXTVAL, '최지원', '111111-2111111', 'J6', SYSDATE);

SELECT * FROM EMPLOYEE;





