package com.keshav.smartlearn.repository;

import com.keshav.smartlearn.entity.InstructorDetail;

import java.util.List;

public interface InstructorDetailRepository {

    List<InstructorDetail> findAllInstructorDetail();

    InstructorDetail findInstructorDetail(int id);

    InstructorDetail save(InstructorDetail instructorDetail);

    InstructorDetail updateInstructorDetail(InstructorDetail instructorDetail);

    void deleteInstructorDetail(InstructorDetail instructorDetail);
}
