package usermenu;

import command.*;
import data.TrainData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static usermenu.Menu.userChoice;
import static usermenu.TrainMenu.trainMenu;

public class ActionMenu {
    public static boolean actionMenu(TrainData trainData) throws IOException {

        Map<Integer, Command> actionMenuCommand = new HashMap<>();
        actionMenuCommand.put(1, new CreateCommand(trainData));
        actionMenuCommand.put(2, new SeeCommand(trainData));
        actionMenuCommand.put(3, new LogOutCommand());

        int choice = 0;
        while (choice != 3) {
            MenuPrinters.ActionMenu();
            choice = userChoice();
            actionMenuCommand.get(choice).execute();
        }
        return false;
    }
}
