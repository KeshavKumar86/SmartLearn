package com.keshav.smartlearn.repository.impl;

import com.keshav.smartlearn.entity.Student;
import com.keshav.smartlearn.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager entityManager;

    //inject entity manager using constructor injection
    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findStudent() {
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        return query.getResultList();

    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Transactional
    @Override
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }

    @Transactional
    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }

    @Override
    public List<Student> findStudentByCourseId(int courseId) {
        TypedQuery<Student> typedQuery = entityManager
                .createQuery("select s from Student s where s.courses.id=:courseId", Student.class);
        return typedQuery.getResultList();
    }
}
