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
    total number(20) not null,
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
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (2, '김영희', 'password456', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (3, '이철수', 'password789', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (4, '박지영', 'password321', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (5, '최민수', 'password654', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (6, '정은지', 'password987', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (7, '김정훈', 'password159', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (8, '송은주', 'password753', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (9, '이민호', 'password369', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (10, '강하늘', 'password741', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (11, '박상훈', 'password852', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (12, '오세미', 'password963', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (13, '홍석구', 'password741', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (14, '김상민', 'password852', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (15, '정유미', 'password159', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (16, '최수현', 'password753', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (17, '권유정', 'password369', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (18, '박지수', 'password741', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (19, '배진호', 'password852', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (20, '김지윤', 'password963', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (21, '이하늘', 'password741', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (22, '박상아', 'password852', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (23, '정현진', 'password159', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (24, '홍하린', 'password753', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (25, '임민정', 'password369', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (26, '박지혜', 'password741', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (27, '김은찬', 'password852', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (28, '이소희', 'password963', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (29, '정수빈', 'password741', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (30, '김하진', 'password852', 'staff');


INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P001', 'Apple 아이폰 14', 999, 1000, 'Apple', '2024-02-15', '스마트폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P002', 'Samsung 갤럭시 S23', 899, 1200, 'Samsung', '2024-01-10', '스마트폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P003', 'Sony WH-1000XM5', 350, 500, 'Sony', '2024-03-01', '무선 헤드폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P004', 'Dell XPS 13', 1200, 800, 'Dell', '2024-04-05', '노트북');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P005', 'LG OLED TV 65"', 2500, 300, 'LG', '2024-05-20', '4K OLED TV');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P006', 'Samsung QLED 55"', 1500, 500, 'Samsung', '2024-06-10', '4K QLED TV');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P007', 'Bose QuietComfort 45', 400, 400, 'Bose', '2024-02-25', '노이즈 캔슬링 헤드폰');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P008', 'Apple MacBook Pro 16"', 2500, 200, 'Apple', '2024-07-05', '노트북');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P009', 'Microsoft Surface Laptop 5', 1000, 1000, 'Microsoft', '2024-08-15', '노트북');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P010', 'Nikon D850 DSLR 카메라', 3000, 200, 'Nikon', '2024-09-30', '카메라');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P011', 'Apple Watch Ultra', 800, 600, 'Apple', '2024-01-25', '스마트워치');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P012', 'Sony PlayStation 5', 500, 1500, 'Sony', '2024-03-10', '게임 콘솔');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P013', 'Xbox Series X', 500, 1300, 'Microsoft', '2024-05-18', '게임 콘솔');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P014', 'Canon EOS R5', 4000, 100, 'Canon', '2024-02-12', '미러리스 카메라');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P015', 'JBL Charge 5', 150, 900, 'JBL', '2024-04-21', '포터블 스피커');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P016', 'Razer Kraken V3', 120, 700, 'Razer', '2024-07-14', '게이밍 헤드셋');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P017', 'Logitech G Pro X', 130, 1200, 'Logitech', '2024-08-01', '게이밍 헤드셋');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P018', 'GoPro HERO10', 450, 1000, 'GoPro', '2024-03-22', '액션 카메라');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P019', 'Asus ROG Strix', 1800, 400, 'Asus', '2024-07-03', '게이밍 노트북');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P020', 'Dyson V15 Detect', 700, 350, 'Dyson', '2024-04-01', '청소기');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P021', 'Apple iPad Pro', 1100, 800, 'Apple', '2024-01-11', '태블릿');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P022', 'Bose SoundLink Flex', 220, 450, 'Bose', '2024-02-05', '포터블 스피커');

INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P001', 'IN', 100, 'D010', 11, '입고 - 정기 발주');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P002', 'IN', 150, 'D011', 12, '입고 - 대량 발주');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P003', 'IN', 200, 'D012', 13, '입고 - 특급 주문');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P004', 'IN', 50, 'D013', 14, '입고 - 한정판 주문');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P005', 'IN', 30, 'D014', 15, '입고 - 행사용');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P006', 'IN', 100, 'D015', 16, '입고 - 매장용');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P007', 'IN', 70, 'D016', 30, '입고 - 프로모션');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P008', 'IN', 20, 'D017', 8, '입고 - 사무용');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P009', 'IN', 80, 'D018', 10, '입고 - 세일');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P010', 'IN', 40, 'D019', 10, '입고 - 신제품 입고');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P001', 'OUT', -30, 'D010', 11, '출고 - 고객 주문');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P002', 'OUT', -20, 'D011', 12, '출고 - 반품');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P003', 'OUT', -50, 'D012', 103, '출고 - 환불');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P005', 'OUT', -10, 'D014', 105, '출고 - 고객 요청');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P006', 'OUT', -25, 'D015', 106, '출고 - 할인 판매');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P007', 'OUT', -10, 'D016', 18, '출고 - 프로모션');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P008', 'OUT', -5, 'D017', 18, '출고 - 개인 판매');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P009', 'OUT', -40, 'D018', 19, '출고 - 고객 반품');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P010', 'OUT', -15, 'D019', 19, '출고 - 행사용');


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
