create database demo;
use demo;

create table products(
id int auto_increment primary key,
productCode varchar(20),
productName varchar(20),
productPrice double,
productAmount double,
productDiscription varchar(20),
productStatus varchar(20)
);


insert into products values
(1,'p-001','ip11',1000,10000,'mô tả','còn'),
(2,'p-002','ip12',1000,10000,'mô tả','hết'),
(3,'p-003','ip13',1000,10000,'mô tả','còn'),
(4,'p-004','ip14',1000,10000,'mô tả','còn');


explain select * from products;
create index i_productCode on products(productCode);

alter table products add index i_product_name_price(productName,productprice);


create view v_product as
select productCode, productName, productPrice, productStatus from products;

select * from v_product;

update v_product set productCode = 'product1' where productName='dt 1';
drop view v_product;


delimiter //
create procedure p_select()
begin
 select * from product;
end//
delimiter ;


delimiter //
create procedure p_insert()
begin
 insert into products(productCode,productName,productPrice,productAmount,productDiscription,productStatus)
  values('p-005','ip11pro',2000,20000,'mô tả','thêm 1');
end//
delimiter ;

delimiter //
create procedure p_update(IN p_id int)
begin
 update products set productPrice = 1500 where id=p_id;
end//
delimiter ;


delimiter //
create procedure p_delete(IN p_id int)
begin
  delete from products where id = p_id;
end//
delimiter ;