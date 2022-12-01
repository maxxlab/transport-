package command;

import data.TrainData;

import java.io.IOException;

public class SeeCommand implements Command{
    TrainData trainData;

    public SeeCommand(TrainData trainData) {
        this.trainData = trainData;
    }

    @Override
    public void execute() throws IOException {
//        trainData.showAllTrains();
    }
}
