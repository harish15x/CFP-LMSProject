package com.bridgelabz.lmsproject.repository;

import com.bridgelabz.lmsproject.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateModel , Long> {
}
