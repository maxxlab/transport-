package train;

public class TrainCar {
    private String levelOfComfort;
    private int numberOfPlaces;
    private int amountOfBaggage;

    public int getAmountOfBaggage() {
        return amountOfBaggage;
    }

    public void setAmountOfBaggage(int amountOfBaggage) {
        this.amountOfBaggage = amountOfBaggage;
    }



    public TrainCar(String levelOfComfort, int numberOfPlaces, int amountOfBaggage) {
        this.levelOfComfort = levelOfComfort;
        this.numberOfPlaces = numberOfPlaces;
        this.amountOfBaggage = amountOfBaggage;
    }

    public String getLevelOfComfort() {
        return levelOfComfort;
    }

    public void setLevelOfComfort(String levelOfComfort) {
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
