create database testmodule3;
use testmodule3;
create table category
(
    categoryId   int primary key auto_increment,
    categoryName varchar(255) not null
);
create table products
(
    productId          int primary key auto_increment,
    productName        varchar(255) not null,
    productPrice       double       not null,
    productQuantity    int,
    productColor       varchar(255),
    productDescription varchar(255),
    productCategoryId  int          not null,
    foreign key (productCategoryId) references category (categoryId)
);

insert into category (categoryName)
values ('Phone');
insert into category (categoryName)
values ('Television');

insert into products (productName, productPrice, productQuantity, productColor, productDescription, productCategoryId)
values ('Iphone 11', 799.0, 12, 'Purple, Yellow, Green', 'ApplePhone', '1');
insert into products (productName, productPrice, productQuantity, productColor, productDescription, productCategoryId)
values ('Iphone 11 Pro', 1100.0, 12, 'Green, Black, White', 'ApplePhone', '1');
insert into products (productName, productPrice, productQuantity, productColor, productDescription, productCategoryId)
values ('Iphone X', 749.0, 13, 'Coral, Black, Blue', 'ApplePhone', '1');
insert into products (productName, productPrice, productQuantity, productColor, productDescription, productCategoryId)
values ('Smart TV màn hình cong 4K UHD 49 inch RU7300', 10000000, 5, 'Black', 'SamSungTV', '2');
insert into products (productName, productPrice, productQuantity, productColor, productDescription, productCategoryId)
values ('SAMSUNG GALAXY S10 E', 420.0, 10, 'Prism White, Prism Blue, Ceeeramich Black', 'SamSungPhone', '1');