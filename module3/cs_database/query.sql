use furamaresort;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhanvien 
where hoTen like ('H%') or hoTen like ('T%') or hoTen like ('K%') and char_length(hoTen)<=15;
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khachhang
where timestampdiff(day,ngaySinh,CURDATE())/365 >=18 and timestampdiff(day,ngaySinh,CURDATE())/365 <= 50
and diaChi = "Đà Nẵng" or diaChi = "Quảng Trị";