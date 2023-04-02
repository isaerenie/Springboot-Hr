package com.enoca.controller;

import com.enoca.dto.CompanyDto;
import com.enoca.entity.Company;
import com.enoca.service.company.Impl.CompanyServiceImpl;
import com.enoca.util.ResponseMap;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyServiceImpl companyService;
    private ModelMapper mapper;

    @PostMapping
    public ResponseMap save(@RequestBody CompanyDto companyDto) {
        Company company = companyService.save(companyDto);
        return ResponseMap.builder()
                .message("Company saved successfully")
                .code("200")
                .details(Map.of("company", mapper.map(company, CompanyDto.class)))
                .build();
    }

    @GetMapping
    public ResponseMap getAll() {
        return ResponseMap.builder()
                .message("Companies listed successfully")
                .code("200")
                .details(Map.of("companies", mapper.map(companyService.getAll(), CompanyDto[].class)))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseMap getById(@PathVariable Long id) {
        return ResponseMap.builder()
                .message("Company listed successfully")
                .code("200")
                .details(Map.of("company", mapper.map(companyService.getById(id), CompanyDto.class)))
                .build();
    }

    @DeleteMapping("/{companyId}")
    public ResponseMap delete(@PathVariable Long companyId) {
        companyService.delete(companyId);
        return ResponseMap.builder()
                .message("Company deleted successfully")
                .code("200")
                .build();
    }

    @PutMapping
    public ResponseMap update(@RequestBody CompanyDto companyDto) {
        Company company = companyService.update(companyDto);
        return ResponseMap.builder()
                .message("Company updated successfully")
                .code("200")
                .details(Map.of("company", mapper.map(company, CompanyDto.class)))
                .build();
    }


}
