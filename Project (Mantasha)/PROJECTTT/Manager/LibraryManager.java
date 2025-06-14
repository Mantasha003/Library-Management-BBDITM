package Manager;

import model.*;
import java.util.ArrayList;

public class LibraryManager {
    private ArrayList<Book> books= new ArrayList<>();
    private ArrayList<User> users= new ArrayList<>();
    //Add a new book
    public void addBook(Book book){
        books.add(book);
    }
    //add new user
    public void addUser(User user){
        users.add(user);
    }

    // get users
    public ArrayList<User> getAllUsers(){
        return users;
    }

    // view ll books
    public void ViewAllBooks(){
        if (books.isEmpty()){
            System.out.println("No books in library");
        }
        else {
            for (Book book : books){
                System.out.println(book);
            }
        }
    }
    // getUserById
    public User getUserById(int id){
        for (User u : users){
            if (u.getUserId()==id){
                return u;
            }
        }
        return null;
    }
    // getBookById
    public Book getBookById(int id){
        for (Book b : books){
            if (b.getBookId()==id){
                return b;
            }
        }
        return null;
    }
    public void searchBookByTitle(String keyword){
        boolean found = false;
        String k= keyword.toLowerCase();
        for (Book book:books){
            String bTitle=book.getTitle().toLowerCase();
            if (bTitle.contains(k)){
                System.out.println(book);
                found= true;
            }
        }
        if (found=false){
            System.out.println("No books found");
        }




    }

    public void borrowBook (int bookId, int userId){
        User u=getUserById(userId);
        Book b= getBookById(bookId);


        if (u!= null&&b!=null && b.getAvailableCopies()>0){
            b.decreaseCopies();
            u.borrowBook(bookId);
            System.out.println("Book borrowed successflly");
        }
        else{
            System.out.println("Unable to borrow book ");
        }
    }
    // returnBook
    public void returnBook(int bookId, int userId) {
        Book book = getBookById(bookId);
        User user = getUserById(userId);

        if (book != null && user != null) {
            book.increaseCopies();
            user.returnBook(bookId);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Unable to return book.");
        }
    }
}