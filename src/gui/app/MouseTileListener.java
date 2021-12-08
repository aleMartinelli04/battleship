package gui.app;

import board.Tile;
import board.TileState;
import gui.app.tiles.JTile;
import ships.exceptions.AllShipsSankException;
import ships.exceptions.ShipSankException;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseTileListener extends JPanel implements MouseListener {
    private final JTile jTile;

    private static JBoard JBoardP1 = null;
    private static JBoard JBoardP2 = null;


    public MouseTileListener(JTile jTile) {
        super();

        this.jTile = jTile;

        setOpaque(true);

        jTile.addMouseListener(this);
        addMouseListener(this);
    }


    public static void setJBoardP1(JBoard JBoardP1) {
        MouseTileListener.JBoardP1 = JBoardP1;
    }

    public static void setJBoardP2(JBoard JBoardP2) {
        MouseTileListener.JBoardP2 = JBoardP2;
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JTile JTile = (JTile) mouseEvent.getComponent();

        JBoard rightJBoard = JBoardP1.contains(JTile) ? JBoardP1 : JBoardP2;
        JBoard otherBoard = rightJBoard == JBoardP1 ? JBoardP2 : JBoardP1;

        if (rightJBoard.isDisabled()) {
            return;
        }

        Tile tile = JTile.getTile();

        if (tile.getState() != TileState.CHECKED) {
            try {
                tile.check();
            } catch (ShipSankException e) {
                try {
                    rightJBoard.getBoard().shipSank(e.getShip());
                } catch (AllShipsSankException ex) {
                    rightJBoard.loses();
                    otherBoard.wins();
                }
            }

            jTile.updateColor();
        }

        rightJBoard.disableBoard();
        otherBoard.enableBoard();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
