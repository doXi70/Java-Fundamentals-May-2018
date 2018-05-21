package P04_MaximalSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        fillMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int currSum = find3x3Sum(matrix, i, j);

                if (currSum > maxSum) {
                    maxSum = currSum;
                    startRow = i;
                    startCol = j;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        print3x3Matix(matrix, startRow, startCol);
    }

    private static void print3x3Matix(int[][] matrix, int startRow, int startCol) {
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int find3x3Sum(int[][] matrix, int i, int j) {
        int result = 0;

        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                result += matrix[k][l];
            }
        }

        return result;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            int[] col = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = col;
        }
    }
}
