create database test;
use test;

 create table ho_khau(
 stt int ,
 ma_ho_khau varchar(45) primary key ,
 ten_chu_ho varchar(45),
 so_luong_thanh_vien int,
 ngay_lap_ho_khau date,
 dia_chi varchar(45)
 );
 
 create table thanh_vien(
 cmnd varchar(45) primary key,
 ho_va_ten varchar(45),
 ngay_sinh varchar(45),
 ma_ho_khau varchar(45),
 foreign key (ma_ho_khau) references ho_khau(ma_ho_khau)
 );