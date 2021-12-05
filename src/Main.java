import board.Board;
import ships.exceptions.ShipSankException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Board table = new Board(10, 10);
        table.placeShips();

        System.out.println(table);

        Arrays.stream(table.getBoard()).forEach(column -> {
            Arrays.stream(column)
                    .forEach(tile -> {
                        try {
                            tile.check();
                        } catch (ShipSankException e) {
                            System.out.println(e.getMessage());
                        }
                    });
        });

        System.out.println(table);
    }
}
