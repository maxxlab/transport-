package command;

import data.TrainData;

import java.io.IOException;

import static usermenu.ActionMenu.actionMenu;
import static usermenu.Menu.menu;

public class GoBackCommand implements Command{
    TrainData trainData;
    @Override
    public void execute() throws IOException {
        menu();
    }
}
