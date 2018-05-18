package P13_BlurFilter;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long blurAmount = Long.parseLong(scanner.nextLine());
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            long[] col = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToLong(Long::parseLong).toArray();

            matrix[i] = col;
        }

        int[] blurCoordinats = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        blurMatrix(matrix, blurAmount, blurCoordinats);
        printMatrix(matrix);
    }

    private static void blurMatrix(long[][] matrix, long blurAmount, int[] blurCoordinats) {
        int targBlurRow = blurCoordinats[0];
        int targBlurCol = blurCoordinats[1];

        int[] topLeft = {targBlurRow - 1, targBlurCol - 1};
        int[] topCent = {targBlurRow - 1, targBlurCol};
        int[] topRight = {targBlurRow - 1, targBlurCol + 1};

        int[] centLeft = {targBlurRow, targBlurCol - 1};
        int[] target = blurCoordinats;
        int[] centRight = {targBlurRow, targBlurCol + 1};

        int[] bottLeft = {targBlurRow + 1, targBlurCol - 1};
        int[] bottCent = {targBlurRow + 1, targBlurCol};
        int[] bottRight = {targBlurRow + 1, targBlurCol + 1};

        for (int i = 0; i < matrix.length; i++) {

            if (i == topLeft[0]) {
                loopMatrixCol(matrix, i, topLeft[1], blurAmount);
            }

            if (i == topCent[0]) {
                loopMatrixCol(matrix, i, topCent[1], blurAmount);
            }

            if (i == topRight[0]) {
                loopMatrixCol(matrix, i, topRight[1], blurAmount);
            }

            if (i == centLeft[0]) {
                loopMatrixCol(matrix, i, centLeft[1], blurAmount);
            }

            if (i == target[0]) {
                loopMatrixCol(matrix, i, target[1], blurAmount);
            }

            if (i == centRight[0]) {
                loopMatrixCol(matrix, i, centRight[1], blurAmount);
            }

            if (i == bottLeft[0]) {
                loopMatrixCol(matrix, i, bottLeft[1], blurAmount);
            }

            if (i == bottCent[0]) {
                loopMatrixCol(matrix, i, bottCent[1], blurAmount);
            }

            if (i == bottRight[0]) {
                loopMatrixCol(matrix, i, bottRight[1], blurAmount);
            }
        }
    }

    private static void printMatrix(long[][] matrix) {
        for (long[] aMatrix : matrix) {
            for (long anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }

    private static void loopMatrixCol(long[][] matrix, int row, int targetCol, long blurAmount) {
        for (int j = 0; j < matrix[row].length; j++) {
            if (j == targetCol) {
                matrix[row][j] += blurAmount;
                break;
            }
        }
    }
}