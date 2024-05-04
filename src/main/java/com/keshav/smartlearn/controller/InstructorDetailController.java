package com.keshav.smartlearn.controller;

import com.keshav.smartlearn.entity.Instructor;
import com.keshav.smartlearn.entity.InstructorDetail;
import com.keshav.smartlearn.repository.InstructorDetailRepository;
import com.keshav.smartlearn.repository.InstructorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorDetailController {

    private final InstructorDetailRepository repository;
    private final InstructorRepository instructorRepository;

    //constructor injection
    public InstructorDetailController(InstructorDetailRepository repository,
                                      InstructorRepository instructorRepository) {
        this.repository = repository;
        this.instructorRepository = instructorRepository;
    }

    //mapping to get all instructor details
    @GetMapping("/instructordetails")
    public List<InstructorDetail> getAllInstructorDetail() {
        return repository.findAllInstructorDetail();
    }

    //mapping to get a particular instructor
    @GetMapping("/instructordetails/{id}")
    public InstructorDetail getInstructorDetail(@PathVariable int id) {
        return repository.findInstructorDetail(id);
    }

    //mapping to save an instructor detail
    @PostMapping("/instructordetails")
    public InstructorDetail save(@RequestBody InstructorDetail instructorDetail) {
        //to make sure insertion happen
        instructorDetail.setId(0);
        return repository.save(instructorDetail);
    }

    //mapping to update an instructor detail
    @PutMapping("/instructordetails/{id}")
    public InstructorDetail update(@PathVariable int id, @RequestBody InstructorDetail instructorDetail) {
        //set the id
        instructorDetail.setId(id);
        return repository.updateInstructorDetail(instructorDetail);
    }

    //mapping to delete an instructor detail
    @DeleteMapping("/instructordetails/{id}")
    public String delete(@PathVariable int id) {
        //find instructor detail by id
        InstructorDetail instructorDetail = repository.findInstructorDetail(id);
        repository.deleteInstructorDetail(instructorDetail);
        return "InstructorDetail deleted with id: " + id;

    }

    //mapping to get InstructorDetail by instructor id
    @GetMapping("/instructordetails/instructor/{instructorId}")
    public InstructorDetail getInstructorDetailByInstructorId(@PathVariable int instructorId){
        //find instructor by id
        Instructor instructor = instructorRepository.findInstructorById(instructorId);
        //fetch instructor detail
        return instructor.getInstructorDetail();
    }
}
