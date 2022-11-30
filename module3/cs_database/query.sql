use furamaresort;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhanvien 
where hoTen like ('H%') or hoTen like ('T%') or hoTen like ('K%') and char_length(hoTen)<=15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khachhang
where TIMESTAMPDIFF(YEAR,ngaySinh,curdate()) between 18 and 50
and diaChi like "%Đà Nẵng" or diaChi like "%Quảng Trị";

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.idKhachHang, kh.hoTen, count(kh.idKhachHang) as so_lan_dat from loaikhach lk
join khachHang kh on kh.idLoaiKhach = lk.idLoaiKhach
join hopDong hd on hd.idKhachHang = kh.idKhachHang
where tenLoaiKhach = "Diamond" 
group by kh.idKhachHang;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.idKhachHang, kh.hoTen, lk.tenLoaiKhach, hd.idHopDong, dv.tendichVu, hd.ngayLamHopDong, hd.ngayKetThuc, sum(dv.chiPhiThue + dvdk.gia * hdct.soLuong) as tong_tien 
from khachhang kh
left join loaikhach lk on lk.idLoaiKhach = kh.idLoaiKhach
left join hopdong hd on hd.idKhachHang = kh.idKhachHang
left join dichVu dv on dv.iddichVu = hd.iddichVu
left join hopdongchitiet hdct on hdct.idHopDong = hd.idHopDong
left join dichVudikem dvdk on dvdk.iddichVuDiKem = hdct.iddichVuDikem
group by hd.idHopDong;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
create view dichVu_loaidichVu
as
select iddichVu, tendichVu, dienTich, chiPhiThue, tenLoaidichVu
from dichVu join loaidichVu on loaidichVu.idLoaidichVu = dichVu.idLoaidichVu ;

select *from dichVu_loaidichVu
where not exists (select iddichVu from hopdong where dichVu_loaidichVu.iddichVu = hopdong.iddichVu and month(ngaylamhopdong) ="1,2,3" and year(ngaylamhopdong)= "2021");

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select iddichVu, tendichVu, dienTich, soNguoiToiDa, chiPhiThue, tenLoaidichVu 
from dichVu  
inner join loaidichVu on loaidichVu.idLoaidichVu = dichVu.idLoaidichVu
where exists (select hopdong.idHopDong from hopdong where year(hopdong.ngaylamhopdong)="2020" and hopdong.iddichVu=dichVu.iddichVu)
and not exists(select hopdong.idHopDong from hopdong where year(hopdong.ngaylamhopdong)="2021" and hopdong.iddichVu=dichVu.iddichVu);

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- c1 
select khachHang.hoTen from khachHang
group by khachHang.hoTen;
-- c2
select hoTen  from khachHang 
union select hoTen from khachHang;
-- c3
select distinct hoTen from khachHang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hopdong.ngaylamhopdong),  count(hopdong.ngaylamhopdong) as kh_dat_phong from hopdong
where year(hopdong.ngaylamhopdong)="2021"
group by month(hopdong.ngaylamhopdong)
order by month(hopdong.ngaylamhopdong);

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hopdong.idhopdong, hopdong.ngaylamhopdong, hopdong.ngayketthuc, hopdong.tiendatcoc, ifnull(hopdongchitiet.soluong,0) as so_lg_dv_dikem from hopdong
left join hopdongchitiet on hopdongchitiet.idhopdong = hopdong.idhopdong
left join dichVudikem on dichVudikem.iddichVudikem = hopdongchitiet.iddichVudikem
group by hopdong.idhopdong;
 
 -- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dichVudikem.iddichVudikem, dichVudikem.tendichVuDiKem from hopdong
inner join hopdongchitiet on hopdong.idhopDong = hopdongchitiet.idhopDong
inner join dichVudikem on hopdongchitiet.IDdichVuDiKem =dichVudikem.IDdichVuDiKem
inner join khachhang on khachhang.IDKhachHang = hopdong.IDKhachHang
inner join loaikhach on khachhang.IDLoaiKhach = loaikhach.IDLoaiKhach
where loaikhach.TenLoaiKhach ="diamond" and (khachhang.DiaChi like "%Vinh" or khachhang.diachi like "%Quảng Ngãi");
 
 -- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
 select hopdong.idhopdong, nhanvien.hoten, khachhang.hoten, khachhang.sdt, dichVu.tendichVu, sum(hopdongchitiet.soluong) as so_lg_dv_di_kem , hopdong.tiendatcoc from hopdong
 join nhanvien on nhanvien.idnhanvien = hopdong.idnhanvien
 join khachhang on khachhang.idkhachhang = hopdong.idkhachhang
 left join hopdongchitiet on hopdongchitiet.idhopdong = hopdong.idhopdong
 join dichVu on dichVu.iddichVu = hopdong.iddichVu
 where not exists(select hopdong.idhopdong where month(hopdong.ngaylamhopdong) between 1 and 6 and year(hopdong.ngaylamhopdong) = "2021")
 and exists(select hopdong.idhopdong where month(hopdong.ngaylamhopdong) between 10 and 12 and year(hopdong.ngaylamhopdong) = "2020") 
 group by hopdong.idhopdong;
 
 -- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.iddichVudikem, dvdk.tendichVudikem , sum(hdct.soluong) as so_luong_dich_vu_di_kem from dichVudikem dvdk
join hopdongchitiet hdct on hdct.iddichvudikem = dvdk.iddichvudikem
group by dvdk.iddichvudikem
having sum(hdct.soluong) >= all (select sum(hdct.soluong) from dichvudikem dvdk
join hopdongchitiet hdct on hdct.iddichvudikem = dvdk.iddichvudikem group by dvdk.iddichvudikem);
 
 -- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
 
 select hopdong.idhopdong, dichvu.tendichvu, dichvudikem.tendichvudikem, count(dichvudikem.iddichvudikem) as so_lan_su_dung from dichvudikem
 join hopdongchitiet on hopdongchitiet.iddichvudikem = dichvudikem.iddichvudikem
 join hopdong on hopdong.idhopdong = hopdongchitiet.idhopdong
 join dichvu on dichvu.iddichvu = hopdong.iddichvu
 join loaidichvu on loaidichvu.idloaidichvu = dichvu.idloaidichvu
 group by dichvudikem.iddichvudikem
 having so_lan_su_dung =1 
 order by idhopdong;
 -- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
 select nhanvien.idnhanvien, nhanvien.hoten, trinhdo.tenTrinhDo, bophan.tenBoPhan, nhanvien.sdt, nhanvien.diaChi, count(hopdong.idnhanvien) as so_lan_tao_hd from nhanvien
 join hopdong on hopdong.idnhanvien = nhanvien.idnhanvien
 join trinhdo on trinhdo.idtrinhdo = nhanvien.idtrinhdo
 join bophan on bophan.idbophan = nhanvien.idbophan
 where year(hopdong.ngaylamhopdong) between 2020 and 2021 
 having so_lan_tao_hd <4;
 
 -- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
  SET SQL_SAFE_UPDATES = 0;
 delete from nhanvien 
 where not exists (select nhanvien.idnhanvien from hopdong where year(hopdong.ngaylamhopdong) between 2019 and 2021 
 and hopdong.idnhanvien = nhanvien.idnhanvien);
 SET SQL_SAFE_UPDATES = 1;
 
 -- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 1.000.000 VNĐ.

select kh.idKhachHang,kh.hoTen,kh.idLoaiKhach from khachhang kh
join loaikhach lk on lk.idLoaiKhach = kh.idLoaiKhach
join hopdong hd on hd.idKhachHang = kh.idKhachHang
join hopdongchitiet hdct on hdct.idHopDong = hd.idHopDong
join dichvudikem dvdk on dvdk.idDichVuDiKem = hdct.idDichVuDiKem
join dichvu dv on dv.idDichVu = hd.idDichVu
where year(hd.ngaylamhopdong) = 2021 and (ifnull((dv.chiphithue),0) + ifnull((hdct.soluong*dvdk.gia),0))>1000000
group by kh.idKhachHang
having  kh.idLoaiKhach = 2;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
  SET SQL_SAFE_UPDATES = 0;
  SET FOREIGN_KEY_CHECKS=0;
delete khachhang ,hopdong, hopdongchitiet from khachhang 
join hopdong on  hopdong.IDKhachHang =khachhang.IDKhachHang 
join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
where not exists(select hopdong.IDHopDong where year (hopdong.ngaylamhopdong)>"2021" and khachhang.IDKhachHang= hopdong.IDKhachHang);
  SET SQL_SAFE_UPDATES = 1;
  SET FOREIGN_KEY_CHECKS=1;
  
  -- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
    SET SQL_SAFE_UPDATES = 0;
update dichvudikem inner join (select  dichvudikem.TenDichVuDiKem as ten_dv_di_kem
from hopdongchitiet inner join dichvudikem on dichvudikem.IDDichVuDiKem = hopdongchitiet.IDDichVuDiKem
group by dichvudikem.IDDichVuDiKem
having count(hopdongchitiet.IDDichVuDiKem)>3) as temp set dichvudikem.Gia= dichvudikem.gia*2 
where dichvudikem.tendichvudikem= temp.ten_dv_di_kem ;
  SET SQL_SAFE_UPDATES = 1;
  
  -- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
  
select nv.idNhanVien, nv.hoTen, nv.email, nv.sdt, nv.ngaySinh, nv.diaChi from nhanvien nv
union
select kh.idKhachHang, kh.hoTen, kh.email, kh.sdt, kh.ngaySinh, kh.diaChi from khachhang kh