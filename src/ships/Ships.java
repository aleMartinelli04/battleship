package ships;

public enum Ships {
    CARRIER("Carrier", 5),
    BATTLESHIP("Battleship", 4),
    CRUISER("Cruiser", 3),
    SUBMARINE("Submarine", 3),
    DESTROYER("Destroyer", 2);

    public final String name;
    public final int dimension;

    Ships(String name, int dimension) {
        this.name = name;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return name + " composed by " + dimension + " tiles";
    }
}
