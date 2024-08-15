package com.employeemanagementsystem;

import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.model.Department;
import com.employeemanagementsystem.repository.EmployeeRepository;
import com.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializers implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Create and save departments
        Department hr = new Department();
        hr.setName("HR");
        departmentRepository.save(hr);

        Department it = new Department();
        it.setName("IT");
        departmentRepository.save(it);

        // Create and save employees
        Employee emp1 = new Employee();
        emp1.setFirstName("Kumar");
        emp1.setLastName("Khan");
        emp1.setEmail("kumarkhan@gmail.com");
        emp1.setDepartment(hr);
        employeeRepository.save(emp1);

        Employee emp2 = new Employee();
        emp2.setFirstName("Shah Rukh");
        emp2.setLastName("Khan");
        emp2.setEmail("srk@example.com");
        emp2.setDepartment(it);
        employeeRepository.save(emp2);

        Pageable pageable = PageRequest.of(0, 10, Sort.by("firstName").ascending());

        Page<Employee> employeesPage = employeeRepository.findAll(pageable);
        System.out.println("Employees (Sorted by firstName):");
        employeesPage.forEach(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName()));

        Page<Employee> hrEmployeesPage = employeeRepository.findByDepartmentName("HR", pageable);
        System.out.println("\nEmployees in HR Department (Sorted by lastName):");
        hrEmployeesPage.forEach(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName()));

        Employee specificEmployee = employeeRepository.findByEmail("srk@example.com");
        System.out.println("\nEmployee with email srk@example.com:");
        System.out.println(specificEmployee.getFirstName() + " " + specificEmployee.getLastName());
    }
}
