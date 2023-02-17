package com.codegym.repository.impl;

import com.codegym.model.Student;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.IStudentRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    @Override
    public List<Student> findAll() {
       List<Student> studentList = new ArrayList<>();
        Session session = BaseRepository.sessionFactory.openSession();
        // Sử dung HQL
        TypedQuery<Student> query =session.createQuery("from Student",Student.class);
        studentList= query.getResultList();
        session.close();
        // sử dụng SQl
//        TypedQuery<Student> query1 = session.createNativeQuery("select * from student",Student.class);
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Session session = BaseRepository.sessionFactory.openSession();
        TypedQuery<Student> query =session.createQuery("from Student where id = :id",Student.class);
        query.setParameter("id",id);
        Student student = query.getSingleResult();
        session.close();
        return student;
    }

    @Override
    public void save(Student student) {
        Session session = BaseRepository.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(student);
        transaction.commit();
        session.close();
    }
}
