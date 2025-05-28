CREATE TABLE product_t ( /*상품테이블 생성*/
    p_code VARCHAR2(20) PRIMARY KEY,
    p_name VARCHAR2(50) not null,
    price NUMBER(10) not null,
    enterprise VARCHAR2(30),
    re_date DATE,
    memo VARCHAR2(50)
);    

CREATE TABLE stock_t (  /*입_출고&재고 테이블 생성*/
    p_code VARCHAR2(20) PRIMARY KEY,
    In_Out VARCHAR2(20) not null,
    in_out_date DATE not null,
    ea number(10) not null,
    total number(20),
    register_date DATE,
    employee number(10) not null,
    updateCheck varchar2(10),
    memo varchar2(50)
);

CREATE TABLE emp(
    employee number(10) primary key,
    emp_name varchar2(30),
    emp_pw varchar2(20) not null,
    emp_level varchar(30)
);

