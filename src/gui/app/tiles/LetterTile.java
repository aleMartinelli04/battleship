package gui.app.tiles;

import board.IndexManager;

public class LetterTile extends ColoredBorderTile {
    public LetterTile(int number) {
        super();

        setText(IndexManager.getCharForGuiOf(number));
    }
}
