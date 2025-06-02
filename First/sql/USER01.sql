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


CREATE TABLE stock_t (  /*��_���&��� ���̺� ����*/
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

CREATE TABLE product_t ( /*��ǰ���̺� ����*/
    p_code VARCHAR2(20) PRIMARY KEY,
    p_name VARCHAR2(50) not null,
    price NUMBER(10) not null,
    total number(20),
    partner VARCHAR2(30),
    re_date varchar2(20) default to_char('YYYY-MM-DD'),
    info VARCHAR2(100) default '-'
);    

/*���̺�����*/
select *
from emp e join stock_t s
           on (e.emp_no = s.emp_no)
           join product_t p 
           on(p.p_code = s.p_code);


/*�������� ���*/
select total 
from stock_t
where register_date in(select MAX(register_date)
from stock_t);

/*��ȸ���*/
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
where substr(s.issue_date,3,5) = '25-05' /*�Է°����ιޱ�*/
order by s.order_number asc;

select s.in_out,   /*�����ĺ�*/
       s.order_number,
       s.p_code,
       p.p_name, 
       s.ea,
       s.location,
       s.issue_date
from stock_t s join product_t p
               on (s. p_code = p.p_code)
where s.in_out = 'IN'  /*�Է°����� �ޱ�*/
order by s.issue_date asc;


select s.in_out,  /*������ �Ǹ� ���.*/
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
               
/*������*/
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (1, 'ȫ�浿', '1111', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (2, '�迵��', '2222', 'staff');


INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P001', 'Apple ������ 14', 999, 1000, 'Apple', '2024-02-15', '����Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P002', 'Samsung ������ S23', 899, 1200, 'Samsung', '2024-01-10', '����Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P003', 'LG OLED TV 65"', 2500, 300, 'LG', '2024-05-20', '4K OLED TV');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P004', 'Samsung QLED 55"', 1500, 500, 'Samsung', '2024-06-10', '4K QLED TV');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P005', 'Apple MacBook Pro 16"', 2500, 200, 'Apple', '2024-07-05', '��Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P006', 'Apple Watch Ultra', 800, 600, 'Apple', '2024-01-25', '����Ʈ��ġ');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P007', 'Apple iPad Pro', 1100, 800, 'Apple', '2024-01-11', '�º�');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P008', 'Apple ������ 15', 999, 1000, 'Apple', '2024-02-15', '����Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P009', 'Samsung ������ S24', 899, 1200, 'Samsung', '2024-01-10', '����Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P010', 'Apple ������ 16', 999, 1000, 'Apple', '2024-02-15', '����Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P011', 'Samsung ������ S25', 899, 1200, 'Samsung', '2024-01-10', '����Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P012', 'LG OLED TV 85"', 2500, 300, 'LG', '2024-05-20', '4K OLED TV');


INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P001', 'IN', 100, 'D010', 1, '�԰� - ���� ����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P002', 'IN', 150, 'D011', 2, '�԰� - �뷮 ����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P003', 'IN', 200, 'D012', 3, '�԰� - Ư�� �ֹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P004', 'IN', 50, 'D013', 4, '�԰� - ������ �ֹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P005', 'IN', 30, 'D014', 5, '�԰� - ����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P006', 'IN', 100, 'D015', 1, '�԰� - �����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P007', 'IN', 70, 'D016', 3, '�԰� - ���θ��');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P008', 'IN', 20, 'D017', 8, '�԰� - �繫��');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P009', 'IN', 80, 'D018', 1, '�԰� - ����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P010', 'IN', 40, 'D019', 1, '�԰� - ����ǰ �԰�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P001', 'OUT', -30, 'D010', 1, '��� - �� �ֹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P002', 'OUT', -20, 'D011', 2, '��� - ��ǰ');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P003', 'OUT', -50, 'D012', 3, '��� - ȯ��');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P005', 'OUT', -10, 'D014', 5, '��� - �� ��û');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P006', 'OUT', -25, 'D015', 6, '��� - ���� �Ǹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P007', 'OUT', -10, 'D016', 8, '��� - ���θ��');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P008', 'OUT', -5, 'D017', 8, '��� - ���� �Ǹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P009', 'OUT', -40, 'D018', 9, '��� - �� ��ǰ');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P010', 'OUT', -15, 'D019', 9, '��� - ����');


SELECT substr(s.issue_date, 1, 7) AS issue_date, -- '2024/02' ���·� ����
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


--Ư���Ⱓ
SELECT p_code, NVL(SUM(ea), 0) AS total_in FROM stock_t WHERE In_Out = 'IN' AND p_code = 'P002'
            AND TO_DATE(issue_date, 'YYYY-MM-DD HH24:MI:SS') >= ADD_MONTHS(SYSDATE, -6) GROUP BY p_code;

