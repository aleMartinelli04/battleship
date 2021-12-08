package gui.app.tiles;

import board.IndexManager;

public class NumberTile extends ColoredBorderTile {
    public NumberTile(int number) {
        super();

        setText(String.valueOf(IndexManager.getIndexForGuiOf(number)));
    }
}
