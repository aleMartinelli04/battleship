package board;

public class IndexManager {
    private static int spaces = 0;

    static String getCharOf(int x) {
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

    static int getIndexOf(int x) {
        return x + 1;
    }
}
