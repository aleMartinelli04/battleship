package gui;

public enum Symbols {
    WATER("🟦"),
    SHIP("🟧"),
    UNKNOWN("⬜️");

    private final String symbol;

    Symbols(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol + " ";
    }
}
