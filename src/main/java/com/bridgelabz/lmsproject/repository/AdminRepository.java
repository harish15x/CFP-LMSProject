package com.bridgelabz.lmsproject.repository;

import com.bridgelabz.lmsproject.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {

    Optional<AdminModel> findByEmailId(String email);
}
