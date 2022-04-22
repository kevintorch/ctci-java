package moderate.Q19_pond_sizes;

import java.util.ArrayList;

public class QuestionC {
    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        ArrayList<Integer> sizes = computePondSizes(land);
        for (int sz : sizes) {
            System.out.println(sz);
        }
    }

    public static ArrayList<Integer> computePondSizes(int[][] land) {
        ArrayList<Integer> pondSizes = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[r].length; c++) {
                if (land[r][c] == 0) {
                    int size = computeSize(land, visited, r, c);
                    if (size > 0)
                        pondSizes.add(size);
                }
            }
        }
        return pondSizes;
    }

    private static int computeSize(int[][] land, boolean[][] visited, int r, int c) {
        if (r < 0 || c < 0 || r >= land.length || c >= land[r].length || land[r][c] != 0 || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        int size = 1;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += computeSize(land, visited, r + dr, c + dc);
            }
        }
        return size;
    }


}
