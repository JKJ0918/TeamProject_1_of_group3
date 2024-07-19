select * from shop;


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
