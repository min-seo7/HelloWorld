/*=================================================05/29*/

drop table emp;  
drop table stock_t;
drop table product_t;



CREATE TABLE emp(
    emp_no number primary key,
    emp_name varchar2(30),
    emp_pw varchar2(20) not null,
    emp_level varchar2(30)
);


CREATE TABLE stock_t (  /*입_출고&재고 테이블 생성*/
    order_number number GENERATED ALWAYS AS IDENTITY PRIMARY key,   
    p_code VARCHAR2(20)not null,
    In_Out VARCHAR2(20) not null,
    ea number(10) not null,
    location varchar2(20), 
    emp_no number(10), 
    issue_date varchar2(20) default to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'),
    modifyCheck varchar2(10) default '-',
    modify_emp NUMBER(10) ,
    memo varchar2(80) default '-'    
);


CREATE TABLE product_t ( /*상품테이블 생성*/
    p_code VARCHAR2(20) PRIMARY KEY,
    p_name VARCHAR2(50) not null,
    price NUMBER(10) not null,
    total number(20) not null,
    partner VARCHAR2(30),
    re_date varchar2(20) default to_char(sysdate, 'YYYY-MM-DD'),
    info VARCHAR2(100) default '-'
);    

/*테이블조인*/
select *
from emp e join stock_t s
           on (e.emp_no = s.emp_no)
           join product_t p 
           on(p.p_code = s.p_code);


/*마지막행 출력*/
select total 
from stock_t
where register_date in(select MAX(register_date)
from stock_t);








/*데이터*/
-- emp 테이블에 데이터 삽입
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (1, 'John Doe', '1111', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (2, 'Jane Smith', 'password456', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (3, 'Robert Johnson', 'password789', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (4, 'Emily Davis', 'password101', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (5, 'Michael Brown', 'password202', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (6, 'Sarah Wilson', 'password303', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (7, 'David Lee', 'password404', 'staff');

-- stock_t 테이블에 데이터 삽입
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, issue_date, modifyCheck, modify_emp, memo) 
VALUES ('P123', 'IN', 100, 'A1', 1, to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, 'Initial stock');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, issue_date, modifyCheck, modify_emp, memo) 
VALUES ('P124', 'OUT', -50, 'B1', 2, to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, 'Sold to customer');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, issue_date, modifyCheck, modify_emp, memo) 
VALUES ('P125', 'IN', 200, 'A2', 3, to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, 'Stock replenishment');

-- product_t 테이블에 데이터 삽입
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) 
VALUES ('P123', 'Product A', 1000, 500, 'Partner1', to_char(sysdate, 'YYYY-MM-DD'), 'High quality product');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) 
VALUES ('P124', 'Product B', 1500, 300, 'Partner2', to_char(sysdate, 'YYYY-MM-DD'), 'Limited edition');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) 
VALUES ('P125', 'Product C', 2000, 700, 'Partner3', to_char(sysdate, 'YYYY-MM-DD'), 'Best seller');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) 
VALUES ('P126', 'Product D', 1200, 400, 'Partner4', to_char(sysdate, 'YYYY-MM-DD'), 'Popular among customers');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) 
VALUES ('P127', 'Product E', 800, 1000, 'Partner5', to_char(sysdate, 'YYYY-MM-DD'), 'New arrival');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) 
VALUES ('P128', 'Product F', 2500, 600, 'Partner6', to_char(sysdate, 'YYYY-MM-DD'), 'Exclusive');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) 
VALUES ('P129', 'Product G', 1800, 450, 'Partner7', to_char(sysdate, 'YYYY-MM-DD'), 'Eco-friendly product');



/*조회출력*/
select substr(s.issue_date,3,5) as issue_date,
       s.order_number,
       s.p_code,
       p.p_name,
       s.In_Out,
       s.ea       
from emp e join stock_t s
           on (e.emp_no = s.emp_no)
           join product_t p 
           on(p.p_code = s.p_code)
where substr(s.issue_date,3,5) = '25-05' /*입력값으로받기*/
order by s.order_number asc;

select s.in_out,   /*입출고식별*/
       s.order_number,
       s.p_code,
       p.p_name, 
       s.ea,
       s.location,
       s.issue_date
from stock_t s join product_t p
               on (s. p_code = p.p_code)
where s.in_out = 'IN'  /*입력값으로 받기*/
order by s.issue_date asc;


select s.in_out,  /*수정된 건만 출력.*/
       s.order_number,
       s.p_code, 
       p.p_name,
       s.ea,
       s.location,
       e.emp_name,
       s.memo,
       s.issue_date
from stock_t s join product_t p
                on (s.p_code = p.p_code)
                join emp e
                on (s.modify_emp = e.emp_no)
where modifycheck ='Y'
order by issue_date asc;
               

--productservice 재고출력
select total from product_t where p_code = 'P123';  --대문자.

insert into target_table (p_code
