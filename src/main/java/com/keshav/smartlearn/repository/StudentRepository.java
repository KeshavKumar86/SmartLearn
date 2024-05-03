package com.keshav.smartlearn.repository;

import com.keshav.smartlearn.entity.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findStudent();
    Student findStudentById(int id);
    Student save(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Student student);
    List<Student> findStudentByCourseId(int courseId);

}
