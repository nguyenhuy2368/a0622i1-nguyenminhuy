package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    List<Student> search(String name, String point, String classId);
    Student findById(int id);
    boolean add(Student student);
    boolean delete(int id);
}
