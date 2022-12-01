package command;

import data.UserData;

import java.io.IOException;

public class FileReadingCommand implements Command{
    UserData userData;

    public FileReadingCommand(UserData userData) {
        this.userData = userData;
    }

    @Override
    public void execute() throws IOException {
//        userData.fileReading();
    }
}
