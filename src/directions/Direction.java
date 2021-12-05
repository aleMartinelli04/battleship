package directions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Coordinate getNextCoordinate(Direction direction, int row, int column) {
        return switch (direction) {
            case NORTH -> new Coordinate(row - 1, column);
            case EAST -> new Coordinate(row, column + 1);
            case SOUTH -> new Coordinate(row + 1, column);
            case WEST -> new Coordinate(row, column - 1);
        };
    }

    public static Coordinate getNextCoordinate(Direction direction, Coordinate coordinate) {
        return getNextCoordinate(direction, coordinate.getRow(), coordinate.getColumn());
    }

    public static List<Direction> getRandomizedValues() {
        List<Direction> randomizedValues = new ArrayList<>(Arrays.asList(values()));

        Collections.shuffle(randomizedValues);

        return randomizedValues;
    }


    public Direction getOppositeDirection() {
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }
}
