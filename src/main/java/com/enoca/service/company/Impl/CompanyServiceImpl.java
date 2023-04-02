package com.enoca.service.company.Impl;

import com.enoca.dto.CompanyDto;
import com.enoca.entity.Company;
import com.enoca.exception.company.CompanyNotFound;
import com.enoca.repo.CompanyRepository;
import com.enoca.service.company.ICompanyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements ICompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper mapper;

    @Override
    public Company save(CompanyDto companyDto) {
        Company company = mapper.map(companyDto, Company.class);
        Company savedCompany = companyRepository.save(company);
        return savedCompany;
    }

    @Override
    public List<Company> getAll() {
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id).orElseThrow(CompanyNotFound::new);
    }

    @Override
    public Boolean delete(Long companyId) {
         if (companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
            return true;
        }else {
            throw new CompanyNotFound();
        }
    }


    @Override
    public Company update(CompanyDto companyDto) {
       Company company = companyRepository.findById(companyDto.getCompanyId()).orElseThrow(CompanyNotFound::new);
         mapper.map(companyDto, company);
        Company savedCompany = companyRepository.save(company);
        return savedCompany;
    }
}
