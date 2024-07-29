import java.util.Arrays;

public class LibraryManagementSystem {

    // Inner class representing a Book
    public static class Book {
        private int bookId;
        private String title;
        private String author;

        // Constructor
        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        // Getters and Setters
        public int getBookId() { return bookId; }
        public void setBookId(int bookId) { this.bookId = bookId; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }

        // Override toString for better representation
        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    // Linear Search
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary Search
    public static Book binarySearchByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid]; // Book found
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        // Sample books
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "1984", "George Orwell"),
            new Book(3, "To Kill a Mockingbird", "Harper Lee"),
            new Book(4, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(5, "Moby Dick", "Herman Melville")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        // Search using Linear Search
        String searchTitle = "1984";
        System.out.println("Searching for '" + searchTitle + "' using Linear Search:");
        Book bookFound = linearSearchByTitle(books, searchTitle);
        System.out.println(bookFound != null ? bookFound : "Book not found");

        // Search using Binary Search
        System.out.println("\nSearching for '" + searchTitle + "' using Binary Search:");
        bookFound = binarySearchByTitle(books, searchTitle);
        System.out.println(bookFound != null ? bookFound : "Book not found");
    }
}
