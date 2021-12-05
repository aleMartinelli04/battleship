package board;

import gui.console.Colors;
import gui.Symbols;
import ships.Ship;
import ships.exceptions.ShipSankException;

public class Tile {
    private Ship ship;
    private TileState state;

    public Tile(Ship ship) {
        this.ship = ship;
        this.state = TileState.NOT_CHECKED;
    }

    public Tile() {
        this(null);
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean isChecked() {
        return state == TileState.CHECKED;
    }

    public void check() throws ShipSankException {
        if (ship != null && state == TileState.NOT_CHECKED) {
            state = TileState.CHECKED;
            ship.hit();
        }

        state = TileState.CHECKED;
    }

    public boolean isOccupied() {
        return ship != null;
    }

    @Override
    public String toString() {
        if (state == TileState.NOT_CHECKED) {
            return Colors.getColoredString(Symbols.UNKNOWN.toString(), Colors.NOT_CHECKED);
        }

        if (ship == null) {
            return Colors.getColoredString(Symbols.WATER.toString(), Colors.WATER);
        }

        return Colors.getColoredString(Symbols.SHIP.toString(), Colors.SHIP);
    }
}
