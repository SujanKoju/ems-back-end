package com.suzuran.emsbackend.bizops;

import com.suzuran.emsbackend.bizops.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(Employee employee);

    List<Employee> findAll();

    List<Employee> findAllWithSearchParam(String searchParam);

    Employee update(Employee employee);

    void delete(Long id);

    Employee findById(Long id);
}
