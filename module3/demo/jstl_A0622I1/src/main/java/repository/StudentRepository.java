package repository;

import model.Clazz;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final String SElECT_ALL = "select * from student";
    private final String SElECT_ALL2 = "select s.*,c.name as class_name from student s join clazz c on s.class_id=c.id ";
    private final String DELETE_STUDENT_BY_ID = "call delete_student_by_id(?)";
    private final String INSERT_INTO = "insert into student(name,gender,point,class_id) values(?,?,?,?)";
    @Override
    public List<Student> findAll() {
        // lấy danh sách từ db
        //kết nối với DB
         List<Student> studentList = new ArrayList<>();
        Connection  connection = BaseRepository.getConnectDB();
        // tao câu truy vấn
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SElECT_ALL2);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float point = resultSet.getFloat("point");
                int classId = resultSet.getInt("class_id");
                String className = resultSet.getString("class_name");
                Clazz clazz = new Clazz(classId,className);
                Student student = new Student(id,name,gender,point,clazz);
                studentList.add(student);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }
    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public boolean add(Student student) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.setInt(4,student.getClazz().getId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_STUDENT_BY_ID);
            callableStatement.setInt(1,id);
            return callableStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
