package P03_SumMatrixElements;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        int totalSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] currRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = currRow;
            totalSum += getRowSum(currRow);
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(totalSum);
    }

    private static int getRowSum(int[] currRow) {
        int sum = 0;

        for (int aCurrRow : currRow) {
            sum += aCurrRow;
        }

        return sum;
    }
}
