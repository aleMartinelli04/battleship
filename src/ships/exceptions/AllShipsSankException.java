package ships.exceptions;

import board.Board;

public class AllShipsSankException extends ShipException {
    private final Board board;

    public AllShipsSankException(Board board) {
        super("All ships sank! Congrats!");
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
}
