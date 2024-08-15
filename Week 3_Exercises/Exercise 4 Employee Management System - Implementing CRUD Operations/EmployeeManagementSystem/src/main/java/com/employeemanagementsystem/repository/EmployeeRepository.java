package com.employeemanagementsystem.repository;

import com.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    List<Employee> findByLastName(String lastName);
    
    List<Employee> findByDepartmentId(Long departmentId);
    
    Employee findByEmail(String email);

    List<Employee> findByDepartmentName(String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.department.name = ?1")
    List<Employee> findByDepartmentNameNamedQuery(String departmentName);
}
