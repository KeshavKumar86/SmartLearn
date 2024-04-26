package com.keshav.smartlearn.controller;

import com.keshav.smartlearn.entity.Review;
import com.keshav.smartlearn.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    private final ReviewRepository repository;

    //constructor injection
    public ReviewController(ReviewRepository repository){
        this.repository = repository;
    }

    //mapping to create  a review
    @PostMapping("/reviews")
    public Review createReview(@RequestBody Review review){
        //to make sure insertion happens
        review.setId(0);
        return repository.save(review);
    }

    //mapping to get all reviews
    @GetMapping("/reviews")
    public List<Review> getAllReview(){
        return  repository.getAllReview();
    }

    //mapping to get a review
    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable int id){
        return  repository.getReview(id);
    }

    //mapping to update review
    @PutMapping("/reviews/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review review){
        review.setId(id);
        return  repository.updateReview(review);
    }

    //mapping to delete review
    @DeleteMapping("/reviews/{id}")
    public String deleteCourse(@PathVariable int id){
        //find review by id
        Review review = repository.getReview(id);
        repository.deleteReview(review);
        return "Review deleted with id: " + id;
    }

    //mapping to get reviews by course id
    @GetMapping("/reviews/courses/{courseId}")
    public List<Review> getReviewByCourseId(@PathVariable int courseId){
        return repository.getReviewByCourseId(courseId);
    }
}
