import board.Board;
import ships.exceptions.AllShipsSankException;
import ships.exceptions.ShipSankException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 10);
        board.placeShips();

        System.out.println(board);

        Arrays.stream(board.getBoard()).forEach(column -> Arrays.stream(column)
                .forEach(tile -> {
                    try {
                        tile.check();
                    } catch (ShipSankException e) {
                        System.out.println(e.getMessage());
                        try {
                            board.shipSank(e.getShip());
                        } catch (AllShipsSankException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }));

        System.out.println(board);
    }
}
