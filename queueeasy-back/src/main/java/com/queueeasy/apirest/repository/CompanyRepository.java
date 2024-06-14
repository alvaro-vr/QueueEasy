package com.queueeasy.apirest.repository;

import com.queueeasy.apirest.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

}
