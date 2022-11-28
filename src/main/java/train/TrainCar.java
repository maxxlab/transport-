package train;

public class TrainCar {
    private TrainCarLevelsEnum levelOfComfort;
    private int numberOfPlaces;

    public int getAmountOfBaggage() {
        return amountOfBaggage;
    }

    public void setAmountOfBaggage(int amountOfBaggage) {
        this.amountOfBaggage = amountOfBaggage;
    }

    private int amountOfBaggage;

    public TrainCar(TrainCarLevelsEnum levelOfComfort, int numberOfPlaces, int amountOfBaggage) {
        this.levelOfComfort = levelOfComfort;
        this.numberOfPlaces = numberOfPlaces;
        this.amountOfBaggage = amountOfBaggage;
    }

    public TrainCarLevelsEnum getLevelOfComfort() {
        return levelOfComfort;
    }

    public void setLevelOfComfort(TrainCarLevelsEnum levelOfComfort) {
        this.levelOfComfort = levelOfComfort;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    @Override
    public String toString() {
        return "TrainCar\n" +
                "Level of comfort: " + levelOfComfort +
                "\nNumber of places: " + numberOfPlaces +
                "\nAmount of baggage: " + amountOfBaggage;
    }
}
