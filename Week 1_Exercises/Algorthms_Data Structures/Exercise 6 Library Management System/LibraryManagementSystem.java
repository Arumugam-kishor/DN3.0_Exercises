package DN3.LibraryManagementSysteimport; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryManagementSystem {

    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search requires the list to be sorted by title
    public void sortBooksByTitle() {
        Collections.sort(books, Comparator.comparing(book -> book.title));
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books.get(mid).title.compareToIgnoreCase(title);

            if (cmp == 0) {
                return books.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; 
    }

    // Method to display all books
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
