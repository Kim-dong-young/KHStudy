/* SELECT * FROM ALL_USERS; */
-- �����ּ�

/* 
    ���� ���� ��� 
    CREATE USER �����̸� IDENTIFIED BY ��й�ȣ;
    GRANT ����,����,.... TO ������;
*/

CREATE USER KH IDENTIFIED BY KH;
-- KH������ �ּ����� ������ �ο�(����, ������ ����)
GRANT CONNECT, RESOURCE TO KH; /* DB����, ���̺� CRUD ���� */