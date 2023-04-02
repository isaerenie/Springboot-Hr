package com.enoca.service.company;

import com.enoca.dto.CompanyDto;
import com.enoca.entity.Company;

import java.util.List;

public interface ICompanyService {
    Company save(CompanyDto companyDto);
    List<Company> getAll();
    Company getById(Long id);
    Boolean delete(Long id);

    Company update(CompanyDto companyDto);

}
