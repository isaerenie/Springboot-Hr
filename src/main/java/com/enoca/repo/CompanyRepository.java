package com.enoca.repo;

import com.enoca.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company deleteCompanyByCompanyId (Long companyId);
}
