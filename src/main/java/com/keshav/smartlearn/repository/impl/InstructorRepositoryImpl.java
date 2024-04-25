package com.keshav.smartlearn.repository.impl;

import com.keshav.smartlearn.entity.Instructor;
import com.keshav.smartlearn.entity.InstructorDetail;
import com.keshav.smartlearn.repository.InstructorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository {

    private final EntityManager entityManager;

    //inject entityManager using constructor injection
    public InstructorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        TypedQuery<Instructor> typedQuery = entityManager
                .createQuery("select i from Instructor i", Instructor.class);
        return typedQuery.getResultList();

    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);

    }

    @Transactional
    @Override
    public void deleteInstructor(Instructor instructor) {
        entityManager.remove(instructor);
    }

    @Transactional
    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return entityManager.merge(instructor);

    }

    @Transactional
    @Override
    public Instructor createInstructor(Instructor instructor) {
        return entityManager.merge(instructor);
    }

}
