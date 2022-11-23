create database furama;
use furama;

create table position (
position_id int unique primary key,
position_name varchar(45)
);
create table degree (
degree_id int unique primary key,
degree_name varchar(45)
);
 create table department (
 department_id int unique primary key,
 department_name varchar(45)
 );
 create table employee (
 employee_id int unique primary key,
 name varchar(45),
 birthday date,
 cmnd varchar(45),
 salary double,
 phone varchar(45),
 email varchar(45),
 address varchar(45),
 position_id int,
 degree_id int,
 department_id int,
 foreign key(position_id) references position (position_id),
 foreign key(degree_id) references degree (degree_id),
 foreign key(department_id) references department (department_id)
 );
 
 create table customertype (
 customertype_id int unique primary key,
 customertype_name varchar(45)
 );
create table customers (
customer_id int unique primary key,
customertype_id int,
foreign key(customertype_id) references customertype(customertype_id),
name varchar(45),
birthday date,
gender bit,
cmnd varchar(45),
phone varchar(45),
 email varchar(45),
 address varchar(45)
);

create table servicetype (
servicetype_id int unique primary key,
servicetype_name varchar(45)
);
create table rentaltype (
rentaltype_id int unique primary key,
rentaltype_name varchar(45)
);
create table services (
service_id int unique primary key,
service_name varchar(45),
area int,
price double,
max_people int,
servicetype_id int,
rentaltype_id int, 
foreign key (servicetype_id) references servicetype(servicetype_id),
foreign key (rentaltype_id) references rentaltype(rentaltype_id),
room_type varchar(45),
other_conveniences varchar(45), -- tiện nghi -- 
pool_area double,
num_floor int,
free_service text
);

create table contract (
contract_id int unique primary key,
start_date datetime,
end_date datetime,
deposit double, -- tien coc
employee_id int,
customer_id int,
servicetype_id int, 
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id ) references customers(customer_id ),
foreign key (servicetype_id ) references services(servicetype_id)
);

create table attach_service (
attach_service_id int unique primary key,
attach_service_name varchar(45),
price double,
unit varchar(10),
status varchar(45)
);
create table detail_contract (
detail_contract_id int unique primary key,
contract_id int,
attach_service_id int,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_service_id) references attach_service(attach_service_id),
unit int
);