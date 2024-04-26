package com.keshav.smartlearn.controller;

import com.keshav.smartlearn.entity.Course;
import com.keshav.smartlearn.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseRepository courseRepository;

    //constructor injection
    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    //mapping to create  a course
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course){
        return courseRepository.createCourse(course);
    }

    //mapping to get all courses
    @GetMapping("/courses")
    public List<Course> getAllCourse(){
        return  courseRepository.findAllCourse();
    }

    //mapping to get a course
    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id){
        return  courseRepository.findCourseById(id);
    }

    //mapping to update course
    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course){
        course.setId(id);
        Course tempCourse;
        if(course.getInstructor()==null){
            //fetch course from db by id
            tempCourse = courseRepository.findCourseById(id);
            course.setInstructor(tempCourse.getInstructor());
        }
        return  courseRepository.updateCourse(course);
    }

    //mapping to delete course
    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id){
        //find course by id
        Course course = courseRepository.findCourseById(id);
        courseRepository.deleteCourse(course);
        return "Course deleted with id: " + id;
    }

    //mapping to find courses by instructor id
    @GetMapping("/courses/instructor/{instructorId}")
    public List<Course> findCourseByInstructorId(@PathVariable int instructorId){
        return  courseRepository.findCourseByInstructorId(instructorId);
    }

    //mapping to get Course with Reviews
    @GetMapping("/courses/reviews/{courseId}")
    public Course getCourseWithReviews(@PathVariable int courseId){
        return  courseRepository.getCourseWithReviews(courseId);
    }
}
