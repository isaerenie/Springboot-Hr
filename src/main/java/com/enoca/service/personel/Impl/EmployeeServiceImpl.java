package com.enoca.service.personel.Impl;


import com.enoca.dto.EmployeeDto;
import com.enoca.entity.Employee;
import com.enoca.exception.personel.EmployeeNotFound;
import com.enoca.repo.EmployeeRepository;
import com.enoca.service.personel.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    private ModelMapper mapper;
    @Override
    public Employee save(EmployeeDto employeeDto) {
      Employee employee = mapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getAll() {
       List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFound::new);
    }

    @Override
    public Boolean delete(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }else {
            throw new EmployeeNotFound();
        }
    }

    @Override
    public Employee update(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId()).orElseThrow(EmployeeNotFound::new);
        mapper.map(employeeDto, employee);
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }
}
