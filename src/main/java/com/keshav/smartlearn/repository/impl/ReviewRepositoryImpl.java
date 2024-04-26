package com.keshav.smartlearn.repository.impl;

import com.keshav.smartlearn.entity.Course;
import com.keshav.smartlearn.entity.Review;
import com.keshav.smartlearn.repository.ReviewRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    private final EntityManager entityManager;

    //constructor injection
    public ReviewRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Review save(Review review) {
        return entityManager.merge(review);
    }

    @Override
    public List<Review> getAllReview() {
        TypedQuery<Review> typedQuery = entityManager
                .createQuery("select r from Review r", Review.class);
        return typedQuery.getResultList();
    }

    @Override
    public Review getReview(int id) {
        return entityManager.find(Review.class, id);
    }

    @Override
    @Transactional
    public Review updateReview(Review review) {
        return entityManager.merge(review);
    }

    @Override
    @Transactional
    public void deleteReview(Review review) {
        entityManager.remove(review);
    }

    @Override
    public List<Review> getReviewByCourseId(int id) {
       TypedQuery<Course> typedQuery = entityManager
               .createQuery("select c from Course c join fetch c.reviews where c.id=:id", Course.class);
       typedQuery.setParameter("id",id);
      Course course = typedQuery.getSingleResult();
      return course.getReviews();
    }

}
