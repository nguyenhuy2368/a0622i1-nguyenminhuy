create database thue_tro;
use thue_tro;
 create table hinh_thuc_thanh_toan
 (
 idThanhToan int primary key,
 tenHinhThuc varchar(45)
 );
create table phong_tro
(
maPhongTro int primary key auto_increment,
tenNguoiThue varchar(45) not null,
sdt varchar(45) not null,
ngayBatDau varchar(45) not null,
idThanhToan int not null,
ghiChu varchar(45),
foreign key (idThanhToan) references hinh_thuc_thanh_toan(idThanhToan)
);
insert into hinh_thuc_thanh_toan(idThanhToan, tenHinhThuc) values
(1,'thang'),
(2,'quy'),
(3,'nam');
insert into phong_tro(tenNguoiThue, sdt, ngayBatDau, idThanhToan, ghiChu) value
('abc', '0123456789','20-20-2022',1,'2 nguoi');
select maPhongTro,tenNguoiThue, sdt, ngayBatDau, hinh_thuc_thanh_toan.idThanhToan,ghiChu from phong_tro join hinh_thuc_thanh_toan on phong_tro.idThanhToan = hinh_thuc_thanh_toan.idThanhToan;