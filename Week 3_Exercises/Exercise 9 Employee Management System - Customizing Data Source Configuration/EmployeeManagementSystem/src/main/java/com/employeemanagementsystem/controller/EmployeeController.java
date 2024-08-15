package com.employeemanagementsystem.controller;

import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/department")
    public Page<Employee> getEmployeesByDepartment(
        @RequestParam("departmentName") String departmentName,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortBy", defaultValue = "lastName") String sortBy,
        @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder
    ) {
        Sort sort = Sort.by(Sort.Order.by(sortBy).with(Sort.Direction.fromString(sortOrder)));
        Pageable pageable = PageRequest.of(page, size, sort);
        
        return employeeService.findEmployeesByDepartment(departmentName, pageable);
    }
}
