package command;

import data.UserData;

import java.io.IOException;

public class SignUpCommand implements Command{
    UserData userData;
    String username, password;
    public SignUpCommand(UserData userData) {
        this.userData = userData;
    }

    @Override
    public void execute() throws IOException {
        userData.signUp(username, password);
    }
}
