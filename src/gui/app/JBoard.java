package gui.app;

import board.Board;
import board.Tile;
import gui.app.tiles.BlankTile;
import gui.app.tiles.JTile;
import gui.app.tiles.LetterTile;
import gui.app.tiles.NumberTile;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class JBoard extends JComponent {
    private final Board board;
    private boolean disabled;

    public JBoard(Board board) {
        setLayout(new GridLayout(board.getRows() + 3, board.getColumns() + 3));

        this.disabled = false;
        this.board = board;

        for (int column = 0; column < board.getColumns() + 3; column++) {
            add(new BlankTile());
        }

        add(new BlankTile());
        add(new BlankTile());
        for (int column = 0; column < board.getColumns(); column++) {
            add(new NumberTile(column));
        }
        add(new BlankTile());

        int number = 0;

        for (Tile[] tiles : board.getBoard()) {
            add(new BlankTile());
            add(new LetterTile(number));
            number++;

            for (Tile tile : tiles) {
                add(new JTile(tile));
            }

            add(new BlankTile());
        }

        for (int column = 0; column < board.getColumns() + 3; column++) {
            add(new BlankTile());
        }
    }


    public Board getBoard() {
        return board;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void enableBoard() {
        this.disabled = false;
    }

    public void disableBoard() {
        this.disabled = true;
    }


    public boolean contains(JTile jTile) {
        return Arrays.asList(getComponents()).contains(jTile);
    }

    public void wins() {
        Arrays.stream(getComponents())
                .filter(component -> component instanceof JTile)
                .map(component -> (JTile) component)
                .filter(jTile1 -> jTile1.hasNotShip())
                .forEach(jTile -> jTile.setBackground(Color.GREEN));
    }

    public void loses() {
        Arrays.stream(getComponents())
                .filter(component -> component instanceof JTile)
                .map(component -> (JTile) component)
                .filter(jTile -> jTile.hasNotShip())
                .forEach(jTile -> jTile.setBackground(Color.RED));
    }
}
