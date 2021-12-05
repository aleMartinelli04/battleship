package ships.exceptions;

import ships.Ship;

public class ShipSankException extends ShipException {
    public ShipSankException(Ship ship) {
        super(ship.toString());
    }
}
