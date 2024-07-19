
insert into SHOP (sname, slocation, sno, sdesigner, sopen, sclose)
	values ('하움', '강남구', '2', '하능원장', '12:00', '18:00');
insert into SHOP (sname, slocation, sno, sdesigner, sopen, sclose)
	values ('리안', '청라', '3', '가을점장', '13:00', '18:00');

select * from shop; -- shop 테이블 조회


SELECT * FROM all_sequences where sequence_owner='ANN'; -- 시퀀스 전체 조회

drop sequence shop_seq; -- 자동생성번호 삭제

create sequence sCode_seq
increment by 1 
start with 1 
nocycle 
nocache ;

create sequence sNo_seq
increment by 1 
start with 1 
nocycle 
nocache ;




