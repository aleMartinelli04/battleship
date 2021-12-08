package gui.app;

import board.Board;

import javax.swing.*;
import java.awt.*;

public class JBattleship extends JFrame {
    public JBattleship(Board boardP1, Board boardP2) {
        super("Battleship Game");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2
        );
        setLocationRelativeTo(null);

        JBoard jBoardP1 = new JBoard(boardP1);
        MouseTileListener.setJBoardP1(jBoardP1);

        JBoard jBoardP2 = new JBoard(boardP2);
        MouseTileListener.setJBoardP2(jBoardP2);

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        add(new JUserLabel("Player 1", Colors.PLAYER_1.getColor()), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        add(new JUserLabel("Player 2", Colors.PLAYER_2.getColor()), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        add(jBoardP1, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        add(jBoardP2, constraints);

        jBoardP1.enableBoard();
        jBoardP2.disableBoard();
    }
}
