package com.employeemanagementsystem;

import com.employeemanagementsystem.model.Department;
import com.employeemanagementsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeManagementSystemTests {

    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8085/api";

    @Test
    public void testGetAllEmployees() {
        ResponseEntity<Employee[]> response = restTemplate.getForEntity(baseUrl + "/employees", Employee[].class);
        Employee[] employees = response.getBody();
        assertNotNull(employees);
        assertTrue(employees.length > 0);
    }

    @Test
    public void testCreateEmployee() {
        Department department = new Department();
        department.setName("Finance");

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setDepartment(department);

        Employee createdEmployee = restTemplate.postForObject(baseUrl + "/employees", employee, Employee.class);
        assertNotNull(createdEmployee);
        assertEquals("John", createdEmployee.getFirstName());
    }

    @Test
    public void testUpdateEmployee() {
        Long employeeId = 1L;

        Employee employeeDetails = new Employee();
        employeeDetails.setFirstName("Jane");
        employeeDetails.setLastName("Smith");
        employeeDetails.setEmail("jane.smith@example.com");

        restTemplate.put(baseUrl + "/employees/" + employeeId, employeeDetails);

        Employee updatedEmployee = restTemplate.getForObject(baseUrl + "/employees/" + employeeId, Employee.class);
        assertEquals("Jane", updatedEmployee.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        Long employeeId = 1L; // Assume there's an employee with ID 1
        restTemplate.delete(baseUrl + "/employees/" + employeeId);

        ResponseEntity<Employee> response = restTemplate.getForEntity(baseUrl + "/employees/" + employeeId, Employee.class);
        assertEquals(404, response.getStatusCodeValue());
    }
}
