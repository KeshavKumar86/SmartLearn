package com.keshav.smartlearn.repository.impl;

import com.keshav.smartlearn.entity.Course;
import com.keshav.smartlearn.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final EntityManager entityManager;

    //constructor injection
    public CourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Course createCourse(Course course) {
        // to make sure insertion
        course.setId(0);
        return entityManager.merge(course);
    }

    @Override
    public List<Course> findAllCourse() {
        TypedQuery<Course> typedQuery = entityManager.createQuery("select c from Course c", Course.class);
        return typedQuery.getResultList();
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourse(Course course) {
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public Course updateCourse(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public List<Course> findCourseByInstructorId(int id) {
        TypedQuery<Course> typedQuery = entityManager
                .createQuery("select c from Course c where c.instructor.id=:instructorId ", Course.class);
        typedQuery.setParameter("instructorId",id);
        return typedQuery.getResultList();
    }

    @Override
    public Course getCourseWithReviews(int id) {
        TypedQuery<Course> typedQuery = entityManager
                .createQuery("select c from Course c join fetch c.reviews where c.id=:id", Course.class);
        typedQuery.setParameter("id",id);
        return  typedQuery.getSingleResult();
    }
}
