use `student-management`;
create table Class(
id int primary key,
`name` varchar(50)
);
create table Teacher(
id int primary key,
`name` varchar(50),
age int,
country varchar(50)
);