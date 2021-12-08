package board;

public class IndexManager {
    private static int spaces = 0;

    public static String getCharOf(int x) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append((char) ((char) x + 'A')).append("  ");

        if (spaces == 3) {
            spaces = 0;
        } else {
            stringBuilder.append(" ");
            spaces++;
        }

        return stringBuilder.toString();
    }

    public static int getIndexOf(int x) {
        return x + 1;
    }

    public static String getCharForGuiOf(int x) {
        return String.valueOf((char) ((char) x + 'A'));
    }

    public static int getIndexForGuiOf(int x) {
        return x + 1;
    }
}
