package usermenu;

import command.*;
import train.Train;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static usermenu.Menu.userChoice;

public class TrainMenu {
    public static void trainMenu(Train train) throws IOException {
        Map<Integer, Command> trainMenuCommand = new HashMap<>();
        trainMenuCommand.put(1, new SortCommand(train));
        trainMenuCommand.put(2, new FindCarCommand(train));
        trainMenuCommand.put(3, new GoBackCommand());

        int choice = 0;
        while(choice!=3) {
            MenuPrinters.TrainMenu();
            choice = userChoice();
            trainMenuCommand.get(choice).execute();
        }
    }
}
