package DN3.LibraryManagementSysteimport; 
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean b = true;

        while (b) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title (Linear Search)");
            System.out.println("4. Search Book by Title (Binary Search)");
            System.out.println("5. Sort Books by Title");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();

                    library.addBook(new Book(id, title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 2: // Display All Books
                    System.out.println("All books:");
                    library.displayBooks();
                    break;

                case 3: // Search Book by Title (Linear Search)
                    System.out.print("Enter Book Title to search (Linear Search): ");
                    String linearSearchTitle = scanner.nextLine();
                    Book foundBook = library.linearSearchByTitle(linearSearchTitle);
                    System.out.println("Linear Search - Found: " + foundBook);
                    break;

                case 4: // Search Book by Title (Binary Search)
                    System.out.print("Enter Book Title to search (Binary Search): ");
                    String binarySearchTitle = scanner.nextLine();
                    library.sortBooksByTitle(); // Ensure books are sorted before binary search
                    Book foundBinaryBook = library.binarySearchByTitle(binarySearchTitle);
                    System.out.println("Binary Search - Found: " + foundBinaryBook);
                    break;

                case 5: // Sort Books by Title
                    library.sortBooksByTitle();
                    System.out.println("Books sorted by title.");
                    break;

                case 6: // Exit
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
