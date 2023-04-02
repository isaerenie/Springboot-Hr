package com.enoca.service.personel;

import com.enoca.dto.EmployeeDto;
import com.enoca.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee save(EmployeeDto employeeDto);
    List<Employee> getAll();
    Employee getById(Long id);
    Boolean delete(Long id);
    Employee update(EmployeeDto employeeDto);
}
