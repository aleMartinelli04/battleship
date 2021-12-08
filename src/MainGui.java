import board.Board;
import gui.app.JBattleship;

public class MainGui {
    public static void main(String[] args) {
        Board boardP1 = new Board(10, 10);
        boardP1.placeShips();

        Board boardP2 = new Board(boardP1.getRows(), boardP1.getColumns());
        boardP2.placeShips();

        JBattleship jBattleship = new JBattleship(boardP1, boardP2);

        jBattleship.setVisible(true);
    }
}
