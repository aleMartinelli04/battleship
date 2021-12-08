package gui.app;

import javax.swing.*;
import java.awt.*;

public class JUserLabel extends JTextField {
    public JUserLabel(String player, Color color) {
        super(player);
        setEditable(false);
        setForeground(color);

        setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        setMargin(new Insets(10, 10, 10, 10));

        setHorizontalAlignment(CENTER);
    }
}
