package command;

import data.TrainData;

public class CreateCommand implements Command{
    TrainData trainData;

    public CreateCommand(TrainData trainData) {
        this.trainData = trainData;
    }

    @Override
    public void execute() {
        trainData.createTrain();
    }
}
