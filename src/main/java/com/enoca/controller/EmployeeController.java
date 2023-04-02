package com.enoca.controller;

import com.enoca.dto.EmployeeDto;
import com.enoca.entity.Employee;
import com.enoca.service.personel.Impl.EmployeeServiceImpl;
import com.enoca.util.ResponseMap;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private ModelMapper mapper;

    @PostMapping
    public ResponseMap save(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.save(employeeDto);
        return ResponseMap.builder()
                .message("Employee saved successfully")
                .code("200")
                .details(Map.of("employee", mapper.map(employee, EmployeeDto.class)))
                .build();
    }

    @GetMapping
    public ResponseMap getAll() {
        return ResponseMap.builder()
                .message("Employee listed successfully")
                .code("200")
                .details(Map.of("employees", mapper.map(employeeService.getAll(), EmployeeDto[].class)))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseMap getById(@PathVariable Long id) {
        return ResponseMap.builder()
                .message("Employee listed successfully")
                .code("200")
                .details(Map.of("employee", mapper.map(employeeService.getById(id), EmployeeDto.class)))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseMap delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseMap.builder()
                .message("Employee deleted successfully")
                .code("200")
                .build();
    }

    @PutMapping
    public ResponseMap update(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.update(employeeDto);
        return ResponseMap.builder()
                .message("Employee updated successfully")
                .code("200")
                .details(Map.of("employee", mapper.map(employee, EmployeeDto.class)))
                .build();
    }


}
