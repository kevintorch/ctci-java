package recursion_and_dp;

// Implement the "paint fill" function that one might see on many image editing programs.
// That is, given a screen (represented by a two-dimensional array of colors), a point,
// and a new color, fill in the surrounding area until the color changes from the original color.

import java.util.Arrays;
import java.util.LinkedList;

public class PaintFill {
    public static void main(String[] args) {
        int N = 10;
        Color[][] screen = new Color[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                screen[i][j] = Color.Black;
            }
        }
        for (int i = 0; i < 100; i++) {
            screen[randomInt(N)][randomInt(N)] = Color.Green;
        }
//        printScreen(screen);
        Color[][] screenCopy = Arrays.copyOf(screen, screen.length);
        printBothScreen(screen, screenCopy);
        paintFill(screen, 2, 2, Color.White);
        paintFillBFS(screenCopy, 2, 2, Color.White);
        System.out.println();
//        printScreen(screen);
        printBothScreen(screen, screenCopy);
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static void printScreen(Color[][] screen) {
        for (int r = 0; r < screen.length; r++) {
            for (int c = 0; c < screen[0].length; c++) {
                System.out.print(PrintColor(screen[r][c]));
            }
            System.out.println();
        }
    }

    public static void printBothScreen(Color[][] screen1, Color[][] screen2) {
        for (int r = 0; r < screen1.length; r++) {
            StringBuilder first = new StringBuilder();
            for (int c = 0; c < screen1[0].length; c++) {
                final String color = PrintColor(screen1[r][c]);
                first.append(color);
                System.out.print(color);
            }
            System.out.print("  :  ");
            StringBuilder second = new StringBuilder();
            for (int c = 0; c < screen2[0].length; c++) {
                final String color = PrintColor(screen2[r][c]);
                second.append(color);
                System.out.print(color);
            }
            System.out.print("  " + first.toString().equals(second.toString()));
            System.out.println();
        }
    }

    public static String PrintColor(Color c) {
        switch (c) {
            case Black:
                return "B";
            case White:
                return "W";
            case Red:
                return "R";
            case Yellow:
                return "Y";
            case Green:
                return "G";
        }
        return "X";
    }

    // Main methods.
    public static boolean paintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }
        if (screen[r][c] == ocolor) {
            screen[r][c] = ncolor;
            paintFill(screen, r - 1, c, ocolor, ncolor); // up
            paintFill(screen, r + 1, c, ocolor, ncolor); // down
            paintFill(screen, r, c - 1, ocolor, ncolor); // left
            paintFill(screen, r, c + 1, ocolor, ncolor); // right
        }
        return true;
    }

    public static boolean paintFill(Color[][] screen, int r, int c, Color ncolor) {
        if (screen[r][c] == ncolor) return false;
        return paintFill(screen, r, c, screen[r][c], ncolor);
    }

    private static void paintFill2(Color[][] screen, int row, int column, Color fillColor) {
        if (row < 0 || row >= screen.length || column < 0 || column >= screen[0].length) return;
        if (screen[row][column] != fillColor) {
            screen[row][column] = fillColor;
            paintFill2(screen, row - 1, column, fillColor);
            paintFill2(screen, row + 1, column, fillColor);
            paintFill2(screen, row, column - 1, fillColor);
            paintFill2(screen, row, column + 1, fillColor);
        }
    }

    private static void paintFillBFS(Color[][] screen, int row, int column, Color fillColor) {
        if (exceedsScreen(screen, new Point(row, column))) return;
        if (screen[row][column] != fillColor) return;
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(row, column));
        while (!queue.isEmpty()) {
            Point removed = queue.remove();
            if (!exceedsScreen(screen, removed) && screen[removed.row][removed.column] != fillColor) {
                screen[removed.row][removed.column] = fillColor;
                queue.add(new Point(row - 1, column));
                queue.add(new Point(row + 1, column));
                queue.add(new Point(row, column - 1));
                queue.add(new Point(row, column + 1));
            }
        }
    }

    private static <T> boolean exceedsScreen(T[][] screen, Point p) {
        return p.row < 0 || p.row >= screen.length ||
                p.column < 0 || p.column >= screen[0].length;
    }

    public enum Color {Black, White, Red, Yellow, Green}

    static class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
