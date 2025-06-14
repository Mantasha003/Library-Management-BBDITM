import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Manager.LibraryManager;
import Manager.LoginManager;
import model.User;
import model.Book;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager library = new LibraryManager();
        LoginManager login = new LoginManager();

        User currentUser = null;
        while (currentUser == null) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                currentUser = login.login(username, password, library.getAllUsers());

                if (currentUser == null) {
                    System.out.println("Invalid username or password, Try again");
                }
            } else if (choice == 2) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                int userId = new Random().nextInt(9000) + 1000;

                User newUser = new User(userId, name, username, password, false);
                library.addUser(newUser);
                System.out.println("User Registered Successfully. Now you can Login.");
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                return;
            } else {
                System.out.println("Invalid Choice. Try again.");
            }
        }

        System.out.println("Welcome " + currentUser.getName());

        while (true) {
            System.out.println("\n======== Menu ========");
            int choice;
            if (currentUser.getIsAdmin()) {
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. View Users");
                System.out.println("4. Logout");
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.print("Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Book Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Book Publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Book Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Copies: ");
                    int copies = Integer.parseInt(scanner.nextLine());

                    int bookId = new Random().nextInt(9000) + 1000;
                    Book newBook = new Book(bookId, title, author, publisher, year, copies);
                    library.addBook(newBook);
                    System.out.println("Book Added Successfully.");
                } else if (choice == 2) {
                    library.ViewAllBooks();
                } else if (choice == 3) {
                    ArrayList<User> users = library.getAllUsers();
                    for (User u : users) {
                        String role = u.getIsAdmin() ? "Admin" : "User";
                        System.out.println(u.getUserId() + ": " + u.getName() + " | Role: " + role);
                    }
                } else if (choice == 4) {
                    System.out.println("Logged Out.");
                    break;
                } else {
                    System.out.println("Invalid Choice.");
                }
            } else {
                System.out.println("1. View Books");
                System.out.println("2. Search Book");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. My Borrowed Books");
                System.out.println("6. Logout");
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    library.ViewAllBooks();
                } else if (choice == 2) {
                    System.out.print("Keyword: ");
                    String keyword = scanner.nextLine();
                    library.searchBookByTitle(keyword);
                } else if (choice == 3) {
                    System.out.print("Book ID: ");
                    int bookId = Integer.parseInt(scanner.nextLine());
                    library.borrowBook(bookId, currentUser.getUserId());
                } else if (choice == 4) {
                    System.out.print("Book ID: ");
                    int bookId = Integer.parseInt(scanner.nextLine());
                    library.returnBook(bookId, currentUser.getUserId());
                } else if (choice == 5) {
//                    library.viewBorrowedBooks(currentUser.getUserId());
                } else if (choice == 6) {
                    System.out.println("Logged Out.");
                    break;
                } else {
                    System.out.println("Invalid Choice.");
                }
            }
        }

        scanner.close();
    }
}
