package P05_MatrixShuffling;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int row = dimensions[0];
        int col = dimensions[1];
        String[][] matrix = new String[row][col];
        fillMatrix(matrix, scanner);


        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] cmds = line.split("\\s+");

            if (!"swap".equals(cmds[0]) || cmds.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            try {
                int swapRow = Integer.parseInt(cmds[1]);
                int swapCol = Integer.parseInt(cmds[2]);
                int withRow = Integer.parseInt(cmds[3]);
                int withCol = Integer.parseInt(cmds[4]);

                swapValues(matrix, swapRow, swapCol , withRow, withCol);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void swapValues(String[][] matrix, int swapRow, int swapCol, int withRow, int withCol) {
        String toSwap = matrix[swapRow][swapCol];
        String toBeSwapped = matrix[withRow][withCol];

        matrix[withRow][withCol] = toSwap;
        matrix[swapRow][swapCol] = toBeSwapped;
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

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            String[] col = scanner.nextLine().split("\\s+");
            matrix[i] = col;
        }
    }

}
