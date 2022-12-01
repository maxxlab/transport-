package command;

import data.TrainData;
import train.TrainCar;

import java.util.ArrayList;
import java.util.List;

public class CreateCommand implements Command{
    TrainData trainData;
    String name;
    ArrayList<TrainCar> cars = new ArrayList<>();
    public CreateCommand(TrainData trainData) {
        this.trainData = trainData;
    }

    @Override
    public void execute() {
        trainData.createTrain(name,  cars);
    }
}
