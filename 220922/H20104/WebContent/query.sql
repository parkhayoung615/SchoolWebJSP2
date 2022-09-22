-- 도서관 사용자 테이블 : lib_member
drop table lib_member;
create table lib_member(
	member_id VARCHAR2(20) constraint member_id_pk primary key,
	member_pwd VARCHAR2(20),
	member_name VARCHAR2(20),
	member_addr VARCHAR2(50),
	member_age NUMBER(3)
);

INSERT INTO lib_member VALUES('test', '1234', 'yangyoung', '경기도 성남시 서현동', 18);
INSERT INTO lib_member VALUES('test2', '5678', '양영2', '경기도 성남시 서현동', 17);
INSERT INTO lib_member VALUES('candy', 'candy1234', '캔디', '경기도 성남시 불정로 386번길', 20);
INSERT INTO lib_member VALUES('admin', 'admin1234', '관리자', '양영 도서관', 50);

-- 도서 테이블 : lib_book, 도서번호는  book_seq로 자동 생성함
drop table lib_book;
create table lib_book(
	book_no NUMBER(6) constraint book_no_pk primary key,
	title VARCHAR2(40),
	author VARCHAR2(20),
	company VARCHAR2(50),
	price NUMBER(6),
	rentaled CHAR(1)
);

drop sequence book_seq;
CREATE sequence book_seq;

INSERT INTO lib_book VALUES(book_seq.nextval, '모모', '미하엘 엔데', '비룡소', 11000, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '장미의 이름', '움베르트 에코', '열린책들', 25000, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '수레바퀴 밑에서', '헤르만 헤세', '어문각', 10000, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '모리와 함께한 화요일', '미치 엘봄', '살림', 10800, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '연금술사', '파울로 코엘료', '문학동네', 9500, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '앵무새 죽이기', '하퍼 리', '열린책들', 13000, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '작은 아씨들', '루이자 메이', '윌북', 15800, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '라틴어 수업', '한동일', '흐름출판', 15000, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '좁은문', '앙드레 지드', '열린책들', 10800, 'f');
INSERT INTO lib_book VALUES(book_seq.nextval, '페르마의 마지막 정리', '사이먼 싱', '경문사', 10000, 'f');

select * from lib_book order by book_no asc;
select * from lib_book where title like '%장미%'; -- title 내용 중 장미가 포함된 레코드를 검색

-- 도서대여 테이블 : rent_book, 대여번호는 rent_seq로 자동 생성함.
drop table rent_book;
drop sequence rent_seq;

create sequence rent_seq;
create table rent_book(
	rent_no NUMBER(6) primary key,
	member_id VARCHAR2(20),
	book_no NUMBER(6),
	member_name VARCHAR2(20),
	title VARCHAR2(40)
);

-- 사용자가 도서(모모 : book_no = 1)를 대여하는 경우,
-- rent_book 테이블에는 대여정보 추가하고, lib_book 테이블에는 1번 도서의 rentaled 필드 정보를 수정해야 함.

INSERT INTO rent_book VALUES(rent_seq.nextval, 'candy', 1, '캔디', '모모');
SELECT * FROM rent_book ORDER BY rent_no asc;