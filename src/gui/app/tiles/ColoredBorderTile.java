package gui.app.tiles;

import gui.app.Colors;

import javax.swing.*;

public abstract class ColoredBorderTile extends BlankTile {
    public ColoredBorderTile() {
        super();

        setBorder(BorderFactory.createLineBorder(Colors.BORDER.getColor()));
        setBorderPainted(true);
    }
}
