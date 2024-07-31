package DN3.EmployeeManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager(2); // Initial capacity  2
        boolean b = true;

        while (b) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();

                    manager.addEmployee(new Employee(id, name, position, salary));
                    System.out.println("Employee added successfully.");
                    break;

                case 2: // Display Employees
                    System.out.println("All Employees:");
                    manager.displayEmployees();
                    break;

                case 3: // Search Employee by ID
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee searchedEmployee = manager.searchEmployeeById(searchId);
                    System.out.println("\nSearched Employee:");
                    if (searchedEmployee != null) {
                        System.out.println(searchedEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4: // Delete Employee by ID
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean isDeleted = manager.deleteEmployeeById(deleteId);
                    System.out.println("\nDelete Status: " + (isDeleted ? "Employee deleted successfully." : "Employee not found."));
                    break;

                case 5: // Exit
                    b = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}
