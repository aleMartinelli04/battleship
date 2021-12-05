package ships;

import ships.exceptions.ShipSankException;

public class Ship {
    private final String name;
    private final int dimension;
    private int hits;

    public Ship(String name, int dimension) {
        this.name = name;
        this.dimension = dimension;
        this.hits = 0;
    }

    public Ship(Ships ship) {
        this(ship.name, ship.dimension);
    }

    public String getName() {
        return name;
    }

    public int getDimension() {
        return dimension;
    }

    public void hit() throws ShipSankException {
        hits++;

        if (hits == dimension) {
            throw new ShipSankException(this);
        }
    }

    @Override
    public String toString() {
        return "Ship " + name + " composed of " + dimension + " tiles sank!";
    }
}
