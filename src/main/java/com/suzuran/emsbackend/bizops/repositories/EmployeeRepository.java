package com.suzuran.emsbackend.bizops.repositories;

import com.suzuran.emsbackend.bizops.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findById(Long id);

    List<Employee> findByNameContainingIgnoringCaseOrderByNameAsc(String searchParam);

    List<Employee> findAllByOrderByNameAsc();

}
