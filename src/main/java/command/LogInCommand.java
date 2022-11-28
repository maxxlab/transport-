package command;

import data.UserData;

import java.io.IOException;

public class LogInCommand implements Command{
    UserData userData;

    public LogInCommand(UserData userData) {
        this.userData = userData;
    }

    @Override
    public void execute() throws IOException {
        userData.logIn();
    }
}
