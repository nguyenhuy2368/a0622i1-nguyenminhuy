create database ss2_qlbh;
use ss2_qlbh;
create table Customer(
cID int auto_increment primary key,
CName varchar(50),
CAge int
);
create table `Order`(
oID int auto_increment primary key,
cID int,
oDate date,
OTotalPrice int,
foreign key(oID) references Customer(cID)
);
create table Product (
pID int primary key,
pName varchar(50),
pPrice int
);
create table OderDetail(
oID int,
pID int,
odQTY int

);
