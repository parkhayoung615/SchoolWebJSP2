select * from book;

CREATE TABLE book(
	book_id NUMBER(4) CONSTRAINT book_id_pk PRIMARY KEY,
	book_name VARCHAR2(20),
	book_loc VARCHAR2(20)
);

CREATE SEQUENCE book_seq;

INSERT INTO book values(BOOK_SEQ.NEXTVAL, 'book1', '001-00001');
INSERT INTO book values(BOOK_SEQ.NEXTVAL, 'book2', '001-00002');
INSERT INTO book values(BOOK_SEQ.NEXTVAL, 'book3', '001-00003');
INSERT INTO book values(BOOK_SEQ.NEXTVAL, 'book4', '001-00004');
INSERT INTO book values(BOOK_SEQ.NEXTVAL, 'book5', '001-00005'); 

DROP TABLE book;
DROP SEQUENCE book_seq;