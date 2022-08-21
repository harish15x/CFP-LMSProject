package com.bridgelabz.lmsproject.repository;

import com.bridgelabz.lmsproject.model.MentorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MentorRepository extends JpaRepository<MentorModel, Long> {

    @Query(value = "select * from mentor where employeeId" , nativeQuery = true)
    List<MentorModel> findAllById(String employeeId);
}
