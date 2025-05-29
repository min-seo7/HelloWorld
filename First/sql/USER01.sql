/*=================================================05/29*/

drop table emp;  
drop table stock_t;
drop table product_t;


CREATE TABLE emp(
    emp_no number primary key,
    emp_name varchar2(30),
    emp_pw varchar2(20) not null,
    emp_level varchar(30)
);


CREATE TABLE stock_t (  /*입_출고&재고 테이블 생성*/
    count_number number GENERATED ALWAYS AS IDENTITY PRIMARY key,
    p_code VARCHAR2(20),
    In_Out VARCHAR2(20) not null,
    in_out_date varchar2(20) not null,
    ea number(10) not null,
    location varchar2(20), 
    register_date varchar2(20) default to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'),
    emp_no number(10),
    total number(20),
    updateCheck varchar2(10),
    memo varchar2(50)
);


CREATE TABLE product_t ( /*상품테이블 생성*/
    p_code VARCHAR2(20) PRIMARY KEY,
    p_name VARCHAR2(50) not null,
    price NUMBER(10) not null,
    partner VARCHAR2(30),
    re_date varchar2(20) default to_char(sysdate, 'YYYY-MM-DD'),
    memo VARCHAR2(50)
);    


insert into emp (emp_no, emp_name, emp_pw, emp_level)
values (1001, '홍길동', '1111', 'manager');

insert into emp (emp_no, emp_name, emp_pw, emp_level)
values (1002, '강민호', '1111', 'staff');
