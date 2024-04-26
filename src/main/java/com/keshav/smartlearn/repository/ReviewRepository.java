package com.keshav.smartlearn.repository;

import com.keshav.smartlearn.entity.Review;

import java.util.List;

public interface ReviewRepository {

    Review save(Review review);
    List<Review> getAllReview();
    Review getReview(int id);
    Review updateReview(Review review);
    void deleteReview(Review review);
    List<Review> getReviewByCourseId(int id);
}
