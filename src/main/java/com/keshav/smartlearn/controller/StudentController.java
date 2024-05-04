package com.keshav.smartlearn.controller;

import com.keshav.smartlearn.entity.Student;
import com.keshav.smartlearn.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentRepository repository;

    //inject StudentRepository using constructor injection
    public StudentController(StudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    //mapping to get all Students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repository.findStudent();
    }

    //mapping to get a particular Student
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return repository.findStudentById(id);
    }

    //mapping to save student
    @PostMapping("/students")
    public Student save(@RequestBody Student student) {
        //to make sure insertion happen
        student.setId(0);
        return repository.save(student);
    }

    //mapping to update Student
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        //set the id
        student.setId(id);
        Student tempStudent;
        if(student.getCourses()==null){
            //fetch courses from the db
            tempStudent = repository.findStudentById(id);
            student.setCourses(tempStudent.getCourses());

        }
        return repository.updateStudent(student);
    }

    //mapping to delete student
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        //fetch the student based on id
        Student student = repository.findStudentById(id);
        repository.deleteStudent(student);
        return "Student deleted with id: " + id;
    }

    //mapping to find student by course id
    @GetMapping("/students/courses/{courseId}")
    public List<Student> getStudentByCourseId(@PathVariable int courseId) {
        return repository.findStudentByCourseId(courseId);
    }
}
