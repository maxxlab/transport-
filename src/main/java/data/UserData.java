package data;

import user.User;
import usermenu.MenuPrinters;

import java.io.FileNotFoundException;
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

    public boolean matchSameUserName(String userName) {
        for (User user : userData) {
            if(user.getUserName().equalsIgnoreCase(userName)){
                return  true;
            }
        }
        return false;
    }

    public boolean matchSamePassword(String password) {
        for (User user : userData){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void signUp() throws IOException {
        FileWriter accounts = new FileWriter("C:\\Users\\Max\\IdeaProjects\\lab4\\src\\records\\signUpRecords.txt", true);
        System.out.println(
                        "===== MENU =====\n" +
                        "\t*SIGN UP*"
        );
        Scanner scanner = new Scanner(System.in);
        String userName, password;
        System.out.println("Enter username: ");
        userName = scanner.next();
        if(!matchSameUserName(userName)){
            accounts.append(userName).append("\n");
            System.out.println("Enter password: ");
            password = scanner.next();
            accounts.append(password).append("\n");
            userData.add(new User(userName, password));
            MenuPrinters.LogMenu();
        } else {
            System.out.println("This username is already taken..");
            signUp();
        }
        accounts.close();
    }

    public boolean accountExists(String userName) throws IOException {
        FileReader accountsReader = new FileReader("C:\\Users\\Max\\IdeaProjects\\lab4\\src\\records\\signUpRecords.txt");
        Scanner scanner = new Scanner(accountsReader);
        while(scanner.hasNext()){
            if(scanner.nextLine().equalsIgnoreCase(userName)){
                return true;
            }
        }
        accountsReader.close();
        return false;
    }

    public void logIn() throws IOException {
        System.out.println(
                "===== MENU =====\n" +
                        "\t*LOG IN*"
        );
        String userName, password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        userName = scanner.next();
        if(matchSameUserName(userName)){
            System.out.println("Enter password: ");
            password = scanner.next();
            if(matchSamePassword(password)){
                System.out.println("\tLogged in successfully!!");
            } else {
                System.out.println("\tIncorrect password! try again..");
                logIn();
            }
        } else {
            System.out.println("\tYou are not registered yet, let's sign up!");
            signUp();
        }
    }

    public void fileReading() throws IOException {
        FileReader getAccounts = new FileReader("C:\\Users\\Max\\IdeaProjects\\lab4\\src\\records\\signUpRecords.txt");
        Scanner scanner = new Scanner(getAccounts);
        while(scanner.hasNext()){
            userData.add(new User(scanner.nextLine(), scanner.nextLine()));
        }
        getAccounts.close();
    }
}
