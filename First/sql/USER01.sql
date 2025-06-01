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
    total number(20) not null,
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
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (2, '�迵��', 'password456', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (3, '��ö��', 'password789', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (4, '������', 'password321', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (5, '�ֹμ�', 'password654', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (6, '������', 'password987', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (7, '������', 'password159', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (8, '������', 'password753', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (9, '�̹�ȣ', 'password369', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (10, '���ϴ�', 'password741', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (11, '�ڻ���', 'password852', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (12, '������', 'password963', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (13, 'ȫ����', 'password741', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (14, '����', 'password852', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (15, '������', 'password159', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (16, '�ּ���', 'password753', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (17, '������', 'password369', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (18, '������', 'password741', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (19, '����ȣ', 'password852', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (20, '������', 'password963', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (21, '���ϴ�', 'password741', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (22, '�ڻ��', 'password852', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (23, '������', 'password159', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (24, 'ȫ�ϸ�', 'password753', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (25, '�ӹ���', 'password369', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (26, '������', 'password741', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (27, '������', 'password852', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (28, '�̼���', 'password963', 'staff');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (29, '������', 'password741', 'admin');
INSERT INTO emp (emp_no, emp_name, emp_pw, emp_level) VALUES (30, '������', 'password852', 'staff');


INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P001', 'Apple ������ 14', 999, 1000, 'Apple', '2024-02-15', '����Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P002', 'Samsung ������ S23', 899, 1200, 'Samsung', '2024-01-10', '����Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P003', 'Sony WH-1000XM5', 350, 500, 'Sony', '2024-03-01', '���� �����');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P004', 'Dell XPS 13', 1200, 800, 'Dell', '2024-04-05', '��Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P005', 'LG OLED TV 65"', 2500, 300, 'LG', '2024-05-20', '4K OLED TV');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P006', 'Samsung QLED 55"', 1500, 500, 'Samsung', '2024-06-10', '4K QLED TV');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P007', 'Bose QuietComfort 45', 400, 400, 'Bose', '2024-02-25', '������ ĵ���� �����');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P008', 'Apple MacBook Pro 16"', 2500, 200, 'Apple', '2024-07-05', '��Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P009', 'Microsoft Surface Laptop 5', 1000, 1000, 'Microsoft', '2024-08-15', '��Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P010', 'Nikon D850 DSLR ī�޶�', 3000, 200, 'Nikon', '2024-09-30', 'ī�޶�');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P011', 'Apple Watch Ultra', 800, 600, 'Apple', '2024-01-25', '����Ʈ��ġ');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P012', 'Sony PlayStation 5', 500, 1500, 'Sony', '2024-03-10', '���� �ܼ�');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P013', 'Xbox Series X', 500, 1300, 'Microsoft', '2024-05-18', '���� �ܼ�');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P014', 'Canon EOS R5', 4000, 100, 'Canon', '2024-02-12', '�̷����� ī�޶�');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P015', 'JBL Charge 5', 150, 900, 'JBL', '2024-04-21', '���ͺ� ����Ŀ');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P016', 'Razer Kraken V3', 120, 700, 'Razer', '2024-07-14', '���̹� ����');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P017', 'Logitech G Pro X', 130, 1200, 'Logitech', '2024-08-01', '���̹� ����');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P018', 'GoPro HERO10', 450, 1000, 'GoPro', '2024-03-22', '�׼� ī�޶�');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P019', 'Asus ROG Strix', 1800, 400, 'Asus', '2024-07-03', '���̹� ��Ʈ��');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P020', 'Dyson V15 Detect', 700, 350, 'Dyson', '2024-04-01', 'û�ұ�');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P021', 'Apple iPad Pro', 1100, 800, 'Apple', '2024-01-11', '�º�');
INSERT INTO product_t (p_code, p_name, price, total, partner, re_date, info) VALUES ('P022', 'Bose SoundLink Flex', 220, 450, 'Bose', '2024-02-05', '���ͺ� ����Ŀ');

INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P001', 'IN', 100, 'D010', 11, '�԰� - ���� ����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P002', 'IN', 150, 'D011', 12, '�԰� - �뷮 ����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P003', 'IN', 200, 'D012', 13, '�԰� - Ư�� �ֹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P004', 'IN', 50, 'D013', 14, '�԰� - ������ �ֹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P005', 'IN', 30, 'D014', 15, '�԰� - ����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P006', 'IN', 100, 'D015', 16, '�԰� - �����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P007', 'IN', 70, 'D016', 30, '�԰� - ���θ��');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P008', 'IN', 20, 'D017', 8, '�԰� - �繫��');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P009', 'IN', 80, 'D018', 10, '�԰� - ����');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P010', 'IN', 40, 'D019', 10, '�԰� - ����ǰ �԰�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P001', 'OUT', -30, 'D010', 11, '��� - �� �ֹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P002', 'OUT', -20, 'D011', 12, '��� - ��ǰ');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P003', 'OUT', -50, 'D012', 103, '��� - ȯ��');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P005', 'OUT', -10, 'D014', 105, '��� - �� ��û');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P006', 'OUT', -25, 'D015', 106, '��� - ���� �Ǹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P007', 'OUT', -10, 'D016', 18, '��� - ���θ��');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P008', 'OUT', -5, 'D017', 18, '��� - ���� �Ǹ�');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P009', 'OUT', -40, 'D018', 19, '��� - �� ��ǰ');
INSERT INTO stock_t (p_code, In_Out, ea, location, emp_no, memo)
VALUES ('P010', 'OUT', -15, 'D019', 19, '��� - ����');


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
