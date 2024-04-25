package com.keshav.smartlearn.repository;

import com.keshav.smartlearn.entity.Instructor;
import com.keshav.smartlearn.entity.InstructorDetail;

import java.util.List;

public interface InstructorRepository {
    List<Instructor> findAll();

    Instructor findInstructorById(int id);

    void deleteInstructor(Instructor instructor);

    Instructor updateInstructor(Instructor instructor);

    Instructor createInstructor(Instructor instructor);

}
