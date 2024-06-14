package com.queueeasy.apirest.service.company;

import com.queueeasy.apirest.repository.CompanyRepository;
import com.queueeasy.apirest.model.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Optional<CompanyModel> find() {
        return this.companyRepository.findAll().stream().findFirst();
    }

    @Override
    public CompanyModel save(CompanyModel company) {
        company.setId(1L);
        this.companyRepository.save(company);
        return company;
    }

    @Override
    public void delete() {
        this.companyRepository.deleteAll();
    }
}
