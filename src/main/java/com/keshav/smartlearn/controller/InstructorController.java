package com.keshav.smartlearn.controller;

import com.keshav.smartlearn.entity.Instructor;
import com.keshav.smartlearn.entity.InstructorDetail;
import com.keshav.smartlearn.repository.InstructorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    private final InstructorRepository instructorRepository;

    //inject using constructor injection
    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    //mapping to create instructor
    @PostMapping("/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        //to make sure we are inserting
        instructor.setId(0);
        return instructorRepository.createInstructor(instructor);
    }

    //mapping to get all instructors
    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    //mapping to get a particular instructor
    @GetMapping("/instructors/{instructorId}")
    public Instructor getInstructor(@PathVariable int instructorId) {
        return instructorRepository.findInstructorById(instructorId);
    }

    //mapping to update an instructor
    @PutMapping("/instructors/{instructorId}")
    public Instructor updateInstructor(@PathVariable int instructorId,
                                       @RequestBody Instructor instructor) {
        instructor.setId(instructorId);
        return instructorRepository.updateInstructor(instructor);
    }

    //mapping to delete a instructor
    @DeleteMapping("/instructors/{instructorId}")
    public String deleteInstructor(@PathVariable int instructorId) {
        //find the instructors
        Instructor instructor = instructorRepository.findInstructorById(instructorId);
        //remove the relationship with courses
        instructor.getCourses().forEach(course -> course.setInstructor(null));
        instructorRepository.deleteInstructor(instructor);
        return "Instructors deleted successfully with id: " + instructorId;
    }

    //mapping to get InstructorDetail by instructor id
    @GetMapping("instructordetails/{instructorId}")
    public InstructorDetail getInstructorDetailByInstructorId(@PathVariable int instructorId){
        //find instructor by id
        Instructor instructor = instructorRepository.findInstructorById(instructorId);
        //fetch instructor detail
        return instructor.getInstructorDetail();
    }

}
