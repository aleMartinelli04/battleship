package directions;

import java.util.*;
import java.util.stream.Stream;

public class Coordinate {
    private final int row;
    private final int column;


    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate(Coordinate coordinate) {
        this(coordinate.row, coordinate.column);
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


    public Coordinate add(int dimension, Direction direction) {
        Coordinate toReturn = new Coordinate(this);

        while (dimension > 0) {
            toReturn = Direction.getNextCoordinate(direction, toReturn);
            dimension--;
        }

        return toReturn;
    }

    public List<Coordinate> getCoordinatesUntil(Coordinate end, Direction direction) {
        List<Coordinate> toReturn = new ArrayList<>();
        Coordinate current = new Coordinate(this);

        while (!current.equals(end)) {
            toReturn.add(current);

            current = Direction.getNextCoordinate(direction, current);
        }

        return toReturn;
    }

    public List<Coordinate> getNearCoordinates(Direction originalDirection, boolean first, boolean last) {
        List<Coordinate> toReturn = new ArrayList<>();

        Stream<Direction> stream = Arrays.stream(Direction.values());

        if (!first) {
            stream = stream.filter(direction -> direction != originalDirection.getOppositeDirection());

        } else if (!last) {
            stream = stream.filter(direction -> direction != originalDirection);

        }

        stream.forEach(direction -> toReturn.add(Direction.getNextCoordinate(direction, this)));

        return toReturn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
