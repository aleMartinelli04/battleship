package gui.app.tiles;

import javax.swing.*;
import java.awt.*;

public class BlankTile extends JButton {
    public BlankTile() {
        super();

        setMargin(new Insets(0, 0, 0, 0));

        setMaximumSize(new Dimension(5, 5));

        setBackground(Color.WHITE);

        setOpaque(true);
        setBorderPainted(false);
    }

    @Override
    public Dimension getPreferredSize() {
        int maxDimension = Math.max(
                super.getPreferredSize().height,
                super.getPreferredSize().width
        );

        return new Dimension(maxDimension, maxDimension);
    }
}
