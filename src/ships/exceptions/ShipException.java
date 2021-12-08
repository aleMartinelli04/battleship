package ships.exceptions;

public abstract class ShipException extends Exception {
    public ShipException() {
    }

    public ShipException(String message) {
        super(message);
    }
}
