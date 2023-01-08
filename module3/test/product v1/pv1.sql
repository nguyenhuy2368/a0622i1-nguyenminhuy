create database csdl_thi;
create table category(
	id int primary key,
    category varchar(255)
);
create table product(
	id int primary key,
	name varchar(255),
    count double,
    amount int,
    color  varchar(45) ,
    described varchar(255),
    id_category int,
    foreign key (id_category) references category(id)
);
SELECT * FROM csdl_thi.product;

SELECT product.*, category.category FROM product
LEFT JOIN category ON product.id_category = category.id
where name like concat('%',?,'%');
INSERT INTO `csdl_thi`.`product` (`id`, `name`, `count`, `amount`, `color`, `described`, `id_category`) VALUES (?,?,?,?,?,?,?);

UPDATE `csdl_thi`.`product` SET `name` = ?, `count` = ?, `amount` = ?, `color` = ?, `described` = ?, `id_category` = ? WHERE (`id` = ?);

delete from product where id = ?;