package model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer> borrowedBooksIds = new ArrayList<>();

   public User(int userId, String name, String username, String password, boolean isAdmin ){
       this.name = name;
       this.userId = userId;
       this.username = username;
       this.password = password;
       this.isAdmin = isAdmin;
   }

    public int getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getUserName() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public boolean getIsAdmin() {
        return isAdmin;
    }

public void borrowBook(int bookId){
       borrowedBooksIds.add(bookId);
}

    public void returnBook(int bookId){
        borrowedBooksIds.remove(bookId);
    }
}
