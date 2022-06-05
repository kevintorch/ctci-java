package hard.Q25_Word_Rectangle;

import others.Trie;

public class Rectangle {
    public int length;
    public int height;
    public char[][] matrix;

    public Rectangle(int length) {
        this.length = length;
    }

    public Rectangle(char[][] matrix) {
        this.height = matrix.length;
        this.length = matrix[0].length;
        this.matrix = matrix;
    }

    public char getLetter(int i, int j) {
        return matrix[i][j];
    }

    public String getColumn(int i) {
        char[] col = new char[height];
        for (int j = 0; j < col.length; j++) {
            col[j] = getLetter(i, j);
        }
        return new String(col);
    }

    public boolean isComplete(int l, int h, WordGroup groupList) {
        // Check if we have formed a complete rectangle.
        if (height == h) {
            // Check if each column is a word in the dictionary.
            for (int i = 0; i < l; i++) {
                String col = getColumn(i);
                if (!groupList.containsWord(col)) {
                    return false; // Invalid rectangle.
                }
            }
            return true; // Valid Rectangle!
        }
        return false;
    }

    public boolean isPartialOK(int l, Trie trie) {
        if (height == 0) {
            return true;
        }
        for (int i = 0; i < l; i++) {
            String col = getColumn(i);
            if (!trie.contains(col)) {
                return false; // Invalid rectangle.
            }
        }
        return true;
    }

    /* If the length of the argument s is consistent with that of this
     * Rectangle object, then return a Rectangle whose matrix is constructed by
     * appending s to the underlying matrix. Otherwise, return null. The
     * underlying matrix of this Rectangle object is /not/ modified.
     */
    public Rectangle append(String s) {
        if (s.length() == length) {
            char[][] temp = new char[height + 1][length];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    temp[i][j] = matrix[i][j];
                }
            }
            s.getChars(0, length, temp[height], 0);

            return new Rectangle(temp);
        }
        return null;
    }

    /* Print the rectangle out, row by row. */
    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println(" ");
        }
    }
}
