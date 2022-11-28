package usermenu;

import command.*;
import data.UserData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static usermenu.Menu.userChoice;

public class LogMenu {
    public static void logMenu(UserData userData) throws IOException {
        MenuPrinters.LogMenu();

        Map<Integer, Command> menuCommands = new HashMap<>();
        menuCommands.put(1, new LogInCommand(userData));
        menuCommands.put(2, new SignUpCommand(userData));
        menuCommands.put(3, new ExitCommand());

        int choice = 0;
        while (choice != 1) {
            choice = userChoice();
            if(choice==3){menuCommands.get(3).execute();}
            new FileReadingCommand(userData).execute();
            menuCommands.get(choice).execute();
        }

    }
}
