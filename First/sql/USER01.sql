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
    order_number number GENERATED ALWAYS AS IDENTITY PRIMARY key,   /*수정해줘라*/
    p_code VARCHAR2(20)not null,
    In_Out VARCHAR2(20) not null,
    ea number(10) not null,
    location varchar2(20), 
    emp_no number(10), 
    total number(20) not null,
    issue_date varchar2(20) default to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'),
    modifyCheck varchar2(10) default '-',
    modify_emp NUMBER(10) ,
    memo varchar2(80) default '-'    
);


CREATE TABLE product_t ( /*상품테이블 생성*/
    p_code VARCHAR2(20) PRIMARY KEY,
    p_name VARCHAR2(50) not null,
    price NUMBER(10) not null,
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
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (1, '홍길동', 'password123', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (2, '김철수', '1234pass', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (3, '이영희', 'mypassword', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (4, '박지은', 'secure123', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (5, '정다운', 'password2021', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (6, '김미소', 'qwerty123', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (7, '최하늘', 'letmein123', 'staff');

INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, total, issue_date, modifyCheck, modify_emp, memo)
VALUES ('P001', 'IN', 100, 'A01', 1, 100, TO_CHAR(2025-04-13), '-', NULL, '입고 처리');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, total, issue_date, modifyCheck, modify_emp, memo)
VALUES ('P001', 'IN', 100, 'A01', 1, 100, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, '입고 처리');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, total, issue_date, modifyCheck, modify_emp, memo)
VALUES ('P002', 'OUT', -50, 'B02', 2, 50, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, '출고 처리');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, total, issue_date, modifyCheck, modify_emp, memo)
VALUES ('P003', 'IN', 200, 'C03', 3, 250, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, '입고 처리');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, total, issue_date, modifyCheck, modify_emp, memo)
VALUES ('P004', 'OUT', -30, 'D04', 4, 220, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, '출고 처리');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, total, issue_date, modifyCheck, modify_emp, memo)
VALUES ('P005', 'IN', 150, 'E05', 5, 370, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, '입고 처리');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, total, issue_date, modifyCheck, modify_emp, memo)
VALUES ('P006', 'OUT', -70, 'F06', 6, 300, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, '출고 처리');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, total, issue_date, modifyCheck, modify_emp, memo)
VALUES ('P007', 'IN', 100, 'G07', 7, 400, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), '-', NULL, '입고 처리');

INSERT INTO product_t (p_code, p_name, price, partner, re_date, info)
VALUES ('P001', 'Apple MacBook Pro', 2500000, 'Apple', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), '고성능 노트북');
INSERT INTO product_t (p_code, p_name, price, partner, re_date, info)
VALUES ('P002', 'Samsung Galaxy S23', 1000000, 'Samsung', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), '최신 스마트폰');
INSERT INTO product_t (p_code, p_name, price, partner, re_date, info)
VALUES ('P003', 'Sony WH-1000XM5', 450000, 'Sony', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), '노이즈 캔슬링 헤드폰');
INSERT INTO product_t (p_code, p_name, price, partner, re_date, info)
VALUES ('P004', 'LG OLED TV', 3000000, 'LG', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), '울트라 HD OLED TV');
INSERT INTO product_t (p_code, p_name, price, partner, re_date, info)
VALUES ('P005', 'Dell XPS 13', 1800000, 'Dell', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), '프리미엄 울트라북');
INSERT INTO product_t (p_code, p_name, price, partner, re_date, info)
VALUES ('P006', 'Microsoft Surface Pro 9', 2000000, 'Microsoft', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), '태블릿 겸용 노트북');
INSERT INTO product_t (p_code, p_name, price, partner, re_date, info)
VALUES ('P007', 'Bose QuietComfort 45', 550000, 'Bose', TO_CHAR(SYSDATE, 'YYYY-MM-DD'), '프리미엄 헤드폰');



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
