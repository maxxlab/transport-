package user;

import java.util.List;

public class User {
    private String userName;
    private String password;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    void logIn(String userName, String password, List<User> users){

    }

    void signUp(String userName, String password, List<User> users){

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
