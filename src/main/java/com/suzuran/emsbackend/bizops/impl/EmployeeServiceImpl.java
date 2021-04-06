package com.suzuran.emsbackend.bizops.impl;

import com.suzuran.emsbackend.bizops.EmployeeService;
import com.suzuran.emsbackend.bizops.entities.Employee;
import com.suzuran.emsbackend.bizops.exceptions.UserNotFoundException;
import com.suzuran.emsbackend.bizops.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee add(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("USER NOT FOUND WITH ID :" + id));
    }
}
