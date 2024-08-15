package com.employeemanagementsystem.repository;

import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByDepartment_Name(String departmentName, Pageable pageable);
}
