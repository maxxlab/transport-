package data;

import user.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserData {
    private List<User> userData = new ArrayList<>();

    public List<User> getUserData(){
        return userData;
    }

    public boolean matchSameUserName(String userName) throws IOException {
        for (User user : userData) {
            if(user.getUserName().equalsIgnoreCase(userName)){
                return  true;
            }
        }
        return false;
    }

    public boolean matchSamePassword(String password) throws IOException {
        for (User user : userData){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }



    public boolean accountExists(String userName) throws IOException {
        FileReader accountsReader = new FileReader("C:\\Users\\Max\\IdeaProjects\\transport\\src\\main\\java\\records\\signUpRecords.txt");
        Scanner scanner = new Scanner(accountsReader);
        while(scanner.hasNext()){
            if(scanner.nextLine().equalsIgnoreCase(userName)){
                return true;
            }
        }
        accountsReader.close();
        return false;
    }

    public boolean logIn(String userName, String password) throws IOException {
        fileReading();
        if(matchSameUserName(userName)){
            if(matchSamePassword(password)){
                return true;
            } else {
                logIn(userName, password);
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean signUp(String userName, String password) throws IOException {
        FileWriter accounts = new FileWriter("C:\\Users\\Max\\IdeaProjects\\transport\\src\\main\\java\\records\\signUpRecords.txt", true);
        fileReading();
        if(!matchSameUserName(userName)){
            accounts.append(userName).append("\n");
            accounts.append(password).append("\n");
            userData.add(new User(userName, password));
            accounts.close();
            return true;
        } else {
            accounts.close();
            return false;
        }

    }

    public void fileReading() throws IOException {
        FileReader getAccounts = new FileReader("C:\\Users\\Max\\IdeaProjects\\transport\\src\\main\\java\\records\\signUpRecords.txt");
        Scanner scanner = new Scanner(getAccounts);
        while(scanner.hasNext()){
            userData.add(new User(scanner.nextLine(), scanner.nextLine()));
        }
        getAccounts.close();
    }
}
