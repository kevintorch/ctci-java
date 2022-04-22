package moderate.Q19_pond_sizes;


// You have an integer matrix representing a plot of land, where the value at that location
// represents the height above sea level. A value of zero indicates water.
// A pond is a region of water connected vertically, horizontally, or diagonally.
// The size of the pond is the total number of connected water cells.
// Write a method to compute the sizes of all ponds in the matrix.
//
// EXAMPLE
// Input:
//   0 2 1 0
//   0 1 0 1
//   1 1 0 1
//   0 1 0 1
// Output: 2, 4, 1 (in any order)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Question {
    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        ArrayList<Integer> sizes = pondSizes(land);
        for (int sz : sizes) {
            System.out.println(sz);
        }
    }

    private static ArrayList<Integer> pondSizes(int[][] plot) {
        ArrayList<Integer> sizes = new ArrayList<>();
        HashSet<Index> table = new HashSet<>();
        for (int row = 0; row < plot.length; row++) {
            for (int column = 0; column < plot[0].length; column++) {
                if (plot[row][column] == 0) {
                    int size = sizeOf(plot, new Index(row, column), table);
                    if (size > 0)
                        sizes.add(size);
                }
            }
        }
        return sizes;
    }

    private static int sizeOf(int[][] plot, Index index, Set<Index> table) {
        if (index.row < 0 || index.column < 0 || index.row >= plot.length ||
                index.column >= plot[index.row].length || plot[index.row][index.column] != 0 || table.contains(index))
            return 0;
        table.add(index);
        int size = 1;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += sizeOf(plot, index.plusRow(dr).plusColumn(dc), table);
            }
        }
        return size;
    }

}
