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
        Department hr = new Department();
        hr.setName("HR");
        departmentRepository.save(hr);
        System.out.println("Saved Department: " + hr);

        Department it = new Department();
        it.setName("IT");
        departmentRepository.save(it);
        System.out.println("Saved Department: " + it);

        Employee emp1 = new Employee();
        emp1.setFirstName("Kumar");
        emp1.setLastName("Khan");
        emp1.setEmail("kumarkhan@gmail.com");
        emp1.setDepartment(hr);
        employeeRepository.save(emp1);
        System.out.println("Saved Employee: " + emp1);

        Employee emp2 = new Employee();
        emp2.setFirstName("Shah Rukh");
        emp2.setLastName("Khan");
        emp2.setEmail("srk@example.com");
        emp2.setDepartment(it);
        employeeRepository.save(emp2);
        System.out.println("Saved Employee: " + emp2);

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.asc("lastName")));

        Page<Employee> hrEmployees = employeeRepository.findByDepartment(hr, pageable);
        System.out.println("Employees in HR Department:");
        hrEmployees.getContent().forEach(e -> System.out.println(e));

        Page<Employee> itEmployees = employeeRepository.findByDepartment(it, pageable);
        System.out.println("Employees in IT Department:");
        itEmployees.getContent().forEach(e -> System.out.println(e));
    }
}
