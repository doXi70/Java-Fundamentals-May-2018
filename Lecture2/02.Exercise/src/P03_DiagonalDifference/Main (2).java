package P03_DiagonalDifference;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimensions][dimensions];
        fillMatrix(matrix, scanner);

        int firstDiagSum = 0, secondDiagSum = 0;

        int row = 0;
        int firstDiagCol = 0;
        int secoDiagCol = matrix.length - 1;

        while (row < matrix.length) {
            firstDiagSum += matrix[row][firstDiagCol++];
            secondDiagSum += matrix[row][secoDiagCol--];
            row++;
        }

        System.out.println(Math.abs(firstDiagSum - secondDiagSum));
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            int[] col = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = col;
        }
    }


}
