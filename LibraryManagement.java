import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String name;
    String author;

    Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Author: " + author;
    }
}

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, name, author));
        System.out.println("Book Added Successfully!");
    }

    public static void removeBook() {
        System.out.print("Enter Book ID to Remove: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Book b : books) {
            if (b.id == id) {
                books.remove(b);
                found = true;
                System.out.println("Book Removed Successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Book Not Found!");
        }
    }

    public static void searchBook() {
        System.out.print("Enter Book Name to Search: ");
        sc.nextLine();
        String name = sc.nextLine();

        boolean found = false;
        for (Book b : books) {
            if (b.name.equalsIgnoreCase(name)) {
                System.out.println("Book Found: " + b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book Not Found!");
        }
    }

    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No Books Available!");
        } else {
            System.out.println("\nLibrary Books:");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}