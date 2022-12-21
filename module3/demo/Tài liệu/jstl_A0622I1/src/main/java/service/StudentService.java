package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public boolean add(Student student) {
        // validate dữ liêu trước thêm mới
        // nếu dữ liêu ok thì lưu vào db
        return studentRepository.add(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }
}
