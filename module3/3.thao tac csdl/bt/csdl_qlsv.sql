use quanlysinhvien;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student where studentname like 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đau vào tháng 12
select * from class where month(startdate) =12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject where credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set sql_safe_updates = 0;
update student set classid = 2 where studentname = 'HUNG';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select studentname, subname, mark from mark m 
join subject s1 on m.subid = s1.subid
join student s on s.studentid = m.studentid
order by mark desc,s.studentname;