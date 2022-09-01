CREATE TABLE bookshop (
	isbn varchar2(15) primary key not null,
	title varchar2(50) not null,
	author varchar2(50) not null,
	company varchar2(50),
	price number
);

INSERT INTO bookshop VALUES('88-90-11', '오라클 3일완성', '이오라', '야메루출판사', 15000);
INSERT INTO bookshop VALUES('90-10-12', 'JSP 달인되기', '송JP', '공갈닷컴', 20000);
INSERT INTO bookshop VALUES('87-90-33', '자바루따기', '김자바', '디지탈 박스', 35000);

SELECT * FROM bookshop;

CREATE TABLE member(
userid varchar2(30),
userpwd varchar2(30));

insert into member values('yydh','1234');