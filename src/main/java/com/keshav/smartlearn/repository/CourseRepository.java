package com.keshav.smartlearn.repository;

import com.keshav.smartlearn.entity.Course;

import java.util.List;

public interface CourseRepository {

    Course createCourse(Course course);

    List<Course> findAllCourse();

    Course findCourseById(int id);

    void deleteCourse(Course course);

    Course updateCourse(Course course);

    List<Course> findCourseByInstructorId(int id);

    Course getCourseWithReviews(int id);
}
