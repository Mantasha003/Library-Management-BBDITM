package Manager;

import model.User;

import java.util.ArrayList;

public class LoginManager {
    public User login(String u, String p, ArrayList<User> users){
        for (User user: users){
            String tempUserName=user.getUserName();
            String tempPassword=user.getPassword();
            if (tempUserName.equals(u)&& tempPassword.equals(p)){
                return user;
            }
        }
        return null;
    }
}
