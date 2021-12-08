package gui.app;

import java.awt.*;

public enum Colors {
    UNKNOWN(new Color(239, 239, 245)),
    WATER(new Color(102, 204, 255)),
    SHIP(new Color(35, 35, 35)),
    BORDER(Color.BLACK),
    PLAYER_1(Color.BLUE),
    PLAYER_2(Color.ORANGE);

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
