// package DN3.TaskManagementSystem; 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Display All Tasks");
            System.out.println("3. Search Task by ID");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Task
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Task Status (Pending/Completed): ");
                    String status = scanner.nextLine();

                    Task newTask = new Task(id, description, status);
                    taskList.addTask(newTask);
                    System.out.println("Task added successfully.");
                    break;

                case 2: // Display All Tasks
                    System.out.println("All tasks:");
                    taskList.traverseTasks();
                    break;

                case 3: // Search Task by ID
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task searchResult = taskList.searchTask(searchId);
                    System.out.println("\nSearched Task:");
                    if (searchResult != null) {
                        System.out.println(searchResult);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 4: // Delete Task by ID
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean deleteResult = taskList.deleteTask(deleteId);
                    System.out.println("\nDelete Status: " + (deleteResult ? "Task deleted successfully." : "Task not found."));
                    break;

                case 5: // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }
}