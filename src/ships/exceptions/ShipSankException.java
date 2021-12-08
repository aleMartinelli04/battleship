package ships.exceptions;

import ships.Ship;
import ships.Ships;

public class ShipSankException extends ShipException {
    private final Ship ship;
    public ShipSankException(Ship ship) {
        super(ship.toString());
        this.ship = ship;
    }

    public Ship getShip() {
        return ship;
    }
}
