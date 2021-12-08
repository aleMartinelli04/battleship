package gui.app.tiles;

import board.Tile;
import board.TileState;
import gui.app.Colors;
import gui.app.MouseTileListener;

import java.awt.*;

public class JTile extends ColoredBorderTile {
    private final Tile tile;

    public JTile(Tile tile) {
        super();

        this.tile = tile;

        new MouseTileListener(this);

        updateColor();
    }

    public Tile getTile() {
        return tile;
    }

    public void disableTile() {
        if (tile.getState() == TileState.CHECKED) {
            return;
        }

        setBackground(Colors.UNKNOWN.getColor());
    }

    public void updateColor() {
        Color color;

        if (tile.getState() == TileState.NOT_CHECKED) {
            color = Colors.UNKNOWN.getColor();
        } else if (tile.getShip() == null) {
            color = Colors.WATER.getColor();
        } else {
            color = Colors.SHIP.getColor();
        }

        setBackground(color);
    }

    public boolean hasNotShip() {
        return tile.getShip() == null;
    }
}
