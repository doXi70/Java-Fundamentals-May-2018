package P01_FillTheMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensionsAndType = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(dimensionsAndType[0]);
        int cols = Integer.parseInt(dimensionsAndType[0]);
        int[][] matrix = new int[rows][cols];

        if (dimensionsAndType[1].toUpperCase().equals("A")) {
            fillMatrixA(matrix);
        } else {
            fillMatrixB(matrix);
        }

        printMatrix(matrix);
    }

    private static void fillMatrixA(int[][] matrix) {
        int counter = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = counter++;
            }
        }
    }

    private static void fillMatrixB(int[][] matrix) {
        int counter = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j % 2 == 0) {
                    matrix[j][i] = counter++;
                    System.out.println("  Writing on position: " + i + "" + j + "number: " + (counter - 1));
                } else {
                    matrix[i][j] = counter++;
                    System.out.println("  Writing on position: " + i + "" + j + "number: " + (counter - 1));
                }

            }
        }
    }
    /*
    00  01  02  03
    10  11  12  13
    20  21  22  23
    30  31  32  33
 */

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
