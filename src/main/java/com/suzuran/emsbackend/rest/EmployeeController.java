package com.suzuran.emsbackend.rest;

import com.suzuran.emsbackend.bizops.EmployeeService;
import com.suzuran.emsbackend.bizops.entities.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAll() {
        System.out.println("---- GET ALL API CALLED ----");
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id) {
        System.out.println("---- GET BY ID API CALLED ----");
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        System.out.println("---- ADD API CALLED ----");
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        System.out.println("---- UPDATE API CALLED ----");
        return new ResponseEntity<>(employeeService.update(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable("id") Long id) {
        System.out.println("---- DELETE API CALLED ----");
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
