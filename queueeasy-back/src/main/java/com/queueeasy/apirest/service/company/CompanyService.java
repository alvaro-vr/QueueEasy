package com.queueeasy.apirest.service.company;

import com.queueeasy.apirest.model.CompanyModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CompanyService {

    Optional<CompanyModel> find();

    CompanyModel save(CompanyModel company);

    void delete();

}
