package P02_MatrixOfPalindromes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        char[] firstAndLastLetter = {'a', 'a', 'a'};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    matrix[i][j] = firstAndLastLetter[0] + "" + firstAndLastLetter[1] + "" + firstAndLastLetter[2] + "";
                } else {
                    matrix[i][j] = firstAndLastLetter[0] + "" + (char) (firstAndLastLetter[1] + j) + "" + firstAndLastLetter[2];
                }
            }

            firstAndLastLetter[0] = (char) (firstAndLastLetter[0] + 1);
            firstAndLastLetter[1] = (char) (firstAndLastLetter[1] + 1);
            firstAndLastLetter[2] = (char) (firstAndLastLetter[2] + 1);

        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

}
