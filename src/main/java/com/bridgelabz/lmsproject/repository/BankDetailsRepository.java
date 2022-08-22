package com.bridgelabz.lmsproject.repository;

import com.bridgelabz.lmsproject.model.BankDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankDetailsRepository extends JpaRepository<BankDetailsModel, Long> {
    List<BankDetailsModel> findAllById(Long bankId);
}
