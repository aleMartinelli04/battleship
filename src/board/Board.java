package board;

import directions.Coordinate;
import directions.Direction;
import ships.Ship;
import ships.Ships;
import ships.exceptions.AllShipsSankException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Board {
    private Tile[][] board;
    private final int rows;
    private final int columns;

    private final List<Ship> ships;


    public Board(int rows, int columns) {
        this.board = createEmptyBoard(rows, columns);
        this.rows = rows;
        this.columns = columns;

        this.ships = Arrays.stream(Ships.values())
                .map(shipEnum -> new Ship(shipEnum))
                .collect(Collectors.toList());
    }


    public Tile[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    private Tile[][] createEmptyBoard(int rows, int columns) {
        Tile[][] newBoard = new Tile[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                newBoard[row][column] = new Tile(null);
            }
        }

        return newBoard;
    }

    public void placeShips() {
        for (int i = 0; i < Ships.values().length; i++) {
            Ship ship = new Ship(Ships.values()[i]);

            Coordinate startCoordinate = new Coordinate(
                    ThreadLocalRandom.current().nextInt(rows),
                    ThreadLocalRandom.current().nextInt(columns)
            );

            Collections.shuffle(Arrays.asList(Direction.values()));

            List<Direction> randomizedDirections = Direction.getRandomizedValues();

            boolean placed = false;

            for (Direction direction : randomizedDirections) {
                Coordinate endCoordinate = startCoordinate.add(ship.getDimension(), direction);

                try {
                    Tile endTile = tileIn(endCoordinate);
                } catch (Exception e) {
                    continue;
                }

                List<Coordinate> coordinates = startCoordinate.getCoordinatesUntil(endCoordinate, direction);

                try {
                    for (int j = 0; j < coordinates.size(); j++) {
                        Coordinate coordinate = coordinates.get(j);
                        if (tileIn(coordinate).isOccupied()) {
                            throw new Exception();
                        }

                        List<Coordinate> nearCoordinates =
                                coordinate.getNearCoordinates(direction, j == 0, j == coordinates.size() - 1);
                        for (Coordinate nearCoordinate : nearCoordinates) {
                            if (tileIn(nearCoordinate).isOccupied()) {
                                throw new Exception();
                            }
                        }
                    }
                } catch (Exception e) {
                    continue;
                }

                coordinates.forEach(coordinate -> tileIn(coordinate).setShip(ship));
                placed = true;
            }

            if (!placed) {
                i--;
            }
        }
    }

    public void shipSank(Ship ship) throws AllShipsSankException {
        ships.remove(ships.stream()
                .filter(ship1 -> ship1.toString().equals(ship.toString()))
                .findFirst()
                .orElse(null)
        );

        if (ships.isEmpty()) {
            throw new AllShipsSankException(this);
        }
    }

    private void reset() {
        board = createEmptyBoard(rows, columns);
    }


    private Tile tileIn(Coordinate coordinate) {
        return tileIn(coordinate.getRow(), coordinate.getColumn());
    }

    private Tile tileIn(int row, int column) {
        return board[row][column];
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\t");
        for (int asciiCode = 0; asciiCode < columns; asciiCode++) {
            stringBuilder.append(IndexManager.getCharOf(asciiCode));
        }
        stringBuilder.append("\n");

        for (int i = 0; i < board.length; i++) {
            Tile[] tiles = board[i];
            stringBuilder.append(IndexManager.getIndexOf(i)).append("\t");
            for (Tile tile : tiles) {
                stringBuilder.append(tile).append("  ");
            }

            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
