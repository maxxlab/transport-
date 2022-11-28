package command;

import train.Train;

import java.io.IOException;

public class SortCommand implements Command{
    Train train;

    public SortCommand(Train train) {
        this.train = train;
    }

    @Override
    public void execute() throws IOException {
        train.sortCarsByLevelOfComfort();
    }
}
