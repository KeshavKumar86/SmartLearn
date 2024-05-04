package com.keshav.smartlearn.repository.impl;

import com.keshav.smartlearn.entity.InstructorDetail;
import com.keshav.smartlearn.repository.InstructorDetailRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorDetailRepositoryImpl implements InstructorDetailRepository {

    private final EntityManager entityManager;

    //use constructor injection to inject entity manager
    public InstructorDetailRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<InstructorDetail> findAllInstructorDetail() {
        TypedQuery<InstructorDetail> query = entityManager
                .createQuery("from InstructorDetail", InstructorDetail.class);
        return query.getResultList();
    }

    @Override
    public InstructorDetail findInstructorDetail(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Transactional
    @Override
    public InstructorDetail save(InstructorDetail instructorDetail) {
        return entityManager.merge(instructorDetail);
    }

    @Transactional
    @Override
    public InstructorDetail updateInstructorDetail(InstructorDetail instructorDetail) {
        return entityManager.merge(instructorDetail);
    }

    @Transactional
    @Override
    public void deleteInstructorDetail(InstructorDetail instructorDetail) {
        entityManager.remove(instructorDetail);
    }
}
