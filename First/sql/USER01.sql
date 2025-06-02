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
    issue_date varchar2(90) default to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'),
    modifyCheck varchar2(10) default '-',
    modify_emp NUMBER(10) ,
    memo varchar2(80) default '-'    
);

CREATE TABLE product_t ( /*상품테이블 생성*/
    p_code VARCHAR2(20) PRIMARY KEY,
    p_name VARCHAR2(50) not null,
    price NUMBER(10) not null,
    total number(20),
    partner VARCHAR2(30),
    re_date varchar2(20) default to_char('YYYY-MM-DD'),
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
               
/*데이터*/
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (1, '홍길동', '1111', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (2, '김영희', '2222', 'staff');


INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P001', 'Apple 아이폰 14', 999, 1000, 'Apple', '2024-02-15', '스마트폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P002', 'Samsung 갤럭시 S23', 899, 1200, 'Samsung', '2024-01-10', '스마트폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P003', 'LG OLED TV 65"', 2500, 300, 'LG', '2024-05-20', '4K OLED TV');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P004', 'Samsung QLED 55"', 1500, 500, 'Samsung', '2024-06-10', '4K QLED TV');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P005', 'Apple MacBook Pro 16"', 2500, 200, 'Apple', '2024-07-05', '노트북');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P006', 'Apple Watch Ultra', 800, 600, 'Apple', '2024-01-25', '스마트워치');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P007', 'Apple iPad Pro', 1100, 800, 'Apple', '2024-01-11', '태블릿');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P008', 'Apple 아이폰 15', 999, 1000, 'Apple', '2024-02-15', '스마트폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P009', 'Samsung 갤럭시 S24', 899, 1200, 'Samsung', '2024-01-10', '스마트폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P010', 'Apple 아이폰 16', 999, 1000, 'Apple', '2024-02-15', '스마트폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P011', 'Samsung 갤럭시 S25', 899, 1200, 'Samsung', '2024-01-10', '스마트폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P012', 'LG OLED TV 85"', 2500, 300, 'LG', '2024-05-20', '4K OLED TV');


INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P001', 'IN', 100, 'D010', 1, '입고 - 정기 발주');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P002', 'IN', 150, 'D011', 2, '입고 - 대량 발주');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P003', 'IN', 200, 'D012', 3, '입고 - 특급 주문');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P004', 'IN', 50, 'D013', 4, '입고 - 한정판 주문');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P005', 'IN', 30, 'D014', 5, '입고 - 행사용');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P006', 'IN', 100, 'D015', 1, '입고 - 매장용');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P007', 'IN', 70, 'D016', 3, '입고 - 프로모션');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P008', 'IN', 20, 'D017', 8, '입고 - 사무용');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P009', 'IN', 80, 'D018', 1, '입고 - 세일');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P010', 'IN', 40, 'D019', 1, '입고 - 신제품 입고');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P001', 'OUT', -30, 'D010', 1, '출고 - 고객 주문');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P002', 'OUT', -20, 'D011', 2, '출고 - 반품');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P003', 'OUT', -50, 'D012', 3, '출고 - 환불');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P005', 'OUT', -10, 'D014', 5, '출고 - 고객 요청');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P006', 'OUT', -25, 'D015', 6, '출고 - 할인 판매');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P007', 'OUT', -10, 'D016', 8, '출고 - 프로모션');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P008', 'OUT', -5, 'D017', 8, '출고 - 개인 판매');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P009', 'OUT', -40, 'D018', 9, '출고 - 고객 반품');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P010', 'OUT', -15, 'D019', 9, '출고 - 행사용');


SELECT substr(s.issue_date, 1, 7) AS issue_date, -- '2024/02' 형태로 추출
       s.order_number, 
       s.p_code, 
       p.p_name, 
       s.In_Out, 
       s.ea  
FROM emp e
JOIN stock_t s ON (e.emp_no = s.emp_no)
JOIN product_t p ON (p.p_code = s.p_code)
WHERE substr(s.issue_date, 1, 7) = '24/02'
ORDER BY issue_date ASC;


SELECT distinct p.p_code, 
       p.p_name, 
       p.partner,
       p.price,
       p.total
FROM stock_t s 
JOIN product_t p ON (p.p_code = s.p_code)
where p.p_code = 'P002';


--특정기간
SELECT p_code, NVL(SUM(ea), 0) AS total_in FROM stock_t WHERE In_Out = 'IN' AND p_code = 'P002'
            AND TO_DATE(issue_date, 'YYYY-MM-DD HH24:MI:SS') >= ADD_MONTHS(SYSDATE, -6) GROUP BY p_code;

