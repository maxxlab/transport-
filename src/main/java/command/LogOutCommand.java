package command;

import data.UserData;

import java.io.IOException;

import static usermenu.LogMenu.logMenu;

public class LogOutCommand implements Command{

    @Override
    public void execute() throws IOException {
        System.out.println("\n\t*You are logged out!*\n");
    }
}
