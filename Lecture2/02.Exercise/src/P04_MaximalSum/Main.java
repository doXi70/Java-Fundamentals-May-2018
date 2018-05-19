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

        for (int i = 0; i < matrix.length - 3; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            int[] col = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = col;
        }
    }
}
