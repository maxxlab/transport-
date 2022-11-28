package usermenu;

import command.*;
import data.TrainData;
import data.UserData;
import user.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static usermenu.ActionMenu.actionMenu;
import static usermenu.LogMenu.logMenu;

public class Menu {

    public static int userChoice() {
        Scanner choice = new Scanner(System.in);
        System.out.print("Choose action: ");
        return Integer.parseInt(choice.next());
    }

    public static void menu() throws IOException {
        UserData userData = new UserData();
        TrainData trainData = new TrainData();
        logMenu(userData);
        if (!actionMenu(trainData)){
            menu();
        }
    }


}
