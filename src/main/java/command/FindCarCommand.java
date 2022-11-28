package command;

import train.Train;

import java.io.IOException;

public class FindCarCommand implements Command{
    Train train;

    public FindCarCommand(Train train) {
        this.train = train;
    }
    @Override
    public void execute() throws IOException {
        train.findCarByRange();
    }
}
