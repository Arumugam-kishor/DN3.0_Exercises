package DN3.mvcPattern;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Student model
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter student grade: ");
        String grade = scanner.nextLine();
        Student student = new Student(name, id, grade);

        // Create a Student view
        StudentView view = new StudentView();

        // Create a Student controller
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        // Update model data dynamically
        while (true) {
            System.out.println("\nUpdate Student Details");
            System.out.println("1. Update Name");
            System.out.println("2. Update ID");
            System.out.println("3. Update Grade");
            System.out.println("4. Display Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter new name: ");
                    name = scanner.nextLine();
                    controller.setStudentName(name);
                    break;
                case 2:
                    System.out.println("Enter new ID: ");
                    id = scanner.nextLine();
                    controller.setStudentId(id);
                    break;
                case 3:
                    System.out.println("Enter new grade: ");
                    grade = scanner.nextLine();
                    controller.setStudentGrade(grade);
                    break;
                case 4:
                    controller.updateView();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
