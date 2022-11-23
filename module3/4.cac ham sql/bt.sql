use quanlysinhvien;
select * from subject where credit = ( select max(credit) from subject);
select s.subname, max(mark)
from subject s join mark m on s.subid = m.subid
where m.mark = ( select max(mark) from subject);
select * from student s 
join mark m on s.studentid = m.studentid ;