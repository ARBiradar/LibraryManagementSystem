import java.util.*;

class Book {
    String title, author;
    boolean isIssued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void issue() { isIssued = true; }
    void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

class User {
    String name;
    int id;

    User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User: " + name + ", ID: " + id;
    }
}

public class LibraryManagementSystem {
    static List<Book> books = new ArrayList<>();
    static List<User> users = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        books.add(new Book("Wings of Fire", "A.P.J. Abdul Kalam"));
        books.add(new Book("Let Us C", "Yashavant Kanetkar"));
        users.add(new User("Adarsh", 1));

        boolean running = true;
        while (running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books\n2. Issue Book\n3. Return Book\n4. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> showBooks();
                case 2 -> issueBook();
                case 3 -> returnBook();
                case 4 -> {
                    System.out.println("Thanks for using the system!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void showBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : books) System.out.println(b);
    }

    static void issueBook() {
        System.out.print("Enter book title to issue: ");
        String title = sc.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title) && !b.isIssued) {
                b.issue();
                System.out.println("Book issued: " + b.title);
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = sc.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title) && b.isIssued) {
                b.returnBook();
                System.out.println("Book returned: " + b.title);
                return;
            }
        }
        System.out.println("Book not found or wasnt issued.");
    }
}

