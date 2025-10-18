package com.project.JobBoardAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.JobBoardAPI.model.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
