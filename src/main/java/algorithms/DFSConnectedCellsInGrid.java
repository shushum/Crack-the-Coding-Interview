package algorithms;

import java.util.Scanner;

public class DFSConnectedCellsInGrid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        System.out.println(largestRegion(grid));
    }

    private static int largestRegion(int[][] matrix) {
        boolean[][] beenThereSeenThings = new boolean[matrix.length][matrix[0].length];

        int largestRegion = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (!beenThereSeenThings[row][col]) {
                    int regionFromHere = walkThePlank(matrix, beenThereSeenThings, row, col);
                    largestRegion = Integer.max(largestRegion, regionFromHere);
                }
            }
        }

        return largestRegion;
    }

    private static int walkThePlank(int[][] matrix, boolean[][] beenThereSeenThings, int row, int col) {
        if (outOfBonds(matrix, row, col)) {
            return 0;
        }
        if (beenThereSeenThings[row][col]) {
            return 0;
        }
        beenThereSeenThings[row][col] = true;
        if (matrix[row][col] == 0) {
            return 0;
        }

        int plankSize = 1;
        plankSize += walkThePlank(matrix, beenThereSeenThings, row, col + 1);
        plankSize += walkThePlank(matrix, beenThereSeenThings, row + 1, col + 1);
        plankSize += walkThePlank(matrix, beenThereSeenThings, row + 1, col);
        plankSize += walkThePlank(matrix, beenThereSeenThings, row + 1, col - 1);
        plankSize += walkThePlank(matrix, beenThereSeenThings, row, col - 1);
        plankSize += walkThePlank(matrix, beenThereSeenThings, row - 1, col - 1);
        plankSize += walkThePlank(matrix, beenThereSeenThings, row - 1, col);
        plankSize += walkThePlank(matrix, beenThereSeenThings, row - 1, col + 1);

        return plankSize;

    }

    private static boolean outOfBonds(int[][] matrix, int row, int col) {
        return row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0;

    }
}
