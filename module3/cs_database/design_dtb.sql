create database furamaresort;
use furamaresort;
create table vitri(
	idViTri int primary key,
    tenViTri varchar(45)
);
create table trinhdo(
	idTrinhDo int primary key,
    trinhDo varchar(45)
);
create table bophan(
	idBoPhan int primary key,
    tenBoPhan varchar(45)
);
create table nhanvien(
	idNhanVien int primary key,
    hoTen varchar(45),
    idViTri int,
    foreign key (idViTri) references vitri(idViTri),
    idTrinhDo int,
    foreign key (idTrinhDo) references trinhdo(idTrinhDo),
    idBoPhan int,
    foreign key (idBoPhan) references bophan(idBoPhan),
    ngaySinh date,
    soCMND int,
    luong int,
    sdt varchar(10),
    email varchar(45),
    diaChi varchar(45)
);

create table loaikhach(
	idLoaiKhach int primary key,
    tenLoaiKhach varchar(45)
);
create table khachhang(
	idKhachHang int primary key,
    hoTen varchar(45),
    ngaySinh date,
    gioiTinh bit,
    soCMND int,
    sdt varchar(10),
    email varchar(45),
    diaChi varchar(45),
    idLoaiKhach int,
    foreign key (idLoaiKhach) references loaikhach(idLoaiKhach)
);

create table kieuthue(
	idKieuThue int primary key,
    tenKieuThue varchar(45)
);
create table loaidichvu(
	idLoaiDichVu int primary key,
    tenLoaiDichVu varchar(45)
);
create table dichvu(
	idDichVu int primary key,
    tenDichVu varchar(45),
    dienTich int,
    chiPhiThue double,
    soNguoiToiDa int,
    tieuChuanPhong varchar(45),
    moTaKhac varchar(45),
    dienTichHoBoi double,
    soTang int,
    dichVuFree text,
    idKieuThue int,
    foreign key (idKieuThue) references kieuthue(idKieuThue),
    idLoaiDichVu int,
    foreign key (idLoaiDichVu) references loaidichvu(idLoaiDichVu)
);

create table hopdong(
	idHopDong int primary key,
    ngayLamHopDong date,
    ngayKetThuc date,
    tienDatCoc int,
    idNhanVien int,
	idKhachHang int,
	idDichVu int,
    foreign key (idNhanVien) references nhanvien(idNhanVien),
    foreign key (idKhachHang) references khachhang(idKhachHang),
    foreign key (idDichVu) references dichvu(idDichVu)
);
create table dichvudikem(
	idDichVuDiKem int primary key,
    tenDichVuDiKem varchar(45),
    gia int,
    donVi varchar(10),
    trangThai varchar(45)
);
create table hopdongchitiet(
	idHopDongChiTiet int primary key,
	idHopDong int,
    foreign key (idHopDong) references hopdong(idHopDong),
    idDichVuDiKem int,
    foreign key (idDichVuDiKem) references dichvudikem(idDichVuDiKem),
    soLuong int
);