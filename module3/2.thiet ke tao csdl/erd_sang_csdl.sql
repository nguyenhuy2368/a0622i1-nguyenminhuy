create database ss2;
use ss2;
create table phieuxuat(
so_px int primary key,
ngay_xuat date
);
create table vattu(
ma_vtu int primary key,
ten_vtu varchar(40)
);

create table chi_tiet_phieu_xuat(
so_px int,
ma_vtu int,
dg_xuat int,
sl_xuat int,
primary key(so_px, ma_vtu),
foreign key(so_px) references phieuxuat(so_px),
foreign key(ma_vtu) references vattu(ma_vtu)
);

create table phieunhap(
so_pn int primary key,
ngay_nhap date
);

create table chi_tiet_phieu_nhap(
so_pn int,
ma_vtu int,
dg_nhap int,
sl_nhap int,
primary key(so_pn,ma_vtu),
foreign key(so_pn) references phieunhap(so_pn),
foreign key(ma_vtu) references vattu(ma_vtu)
); 

create table sdt(
id int primary key auto_increment,
sdt varchar(50)
);
create table nhacc(
ma_ncc int primary key,
ten_ncc varchar(40),
dia_chi varchar(50),
sdt_id int,
foreign key(sdt_id) references sdt(id)
);
create table dondh(
so_dh int primary key,
ngay_dh date,
ma_ncc int,
foreign key(ma_ncc) references nhacc(ma_ncc)
);

create table chi_tiet_don_hang(
ma_vtu int,
so_dh int,
primary key(ma_vtu,so_dh),
foreign key(so_dh) references dondh(so_dh),
foreign key(ma_vtu) references vattu(ma_vtu)
);