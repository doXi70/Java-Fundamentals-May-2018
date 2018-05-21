package P06_StringMatrixRotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        String[] input = scanner.readLine().split("\\D+");
        int degrees = Integer.parseInt(input[1]);

        List<String> inputTokens = new ArrayList<>();
        String line;
        while (!"END".equals(line = scanner.readLine())) {
            inputTokens.add(line);
        }

        int rows = inputTokens.size();
        int cols = findLongestString(inputTokens);
        char[][] matrix = new char[rows][cols];
        fillMatrix(matrix, inputTokens);


        switch (degrees % 360) {
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                printMatrix(rotateMatrix90(matrix, rows, cols));
                break;
            case 180:
                printMatrix(rotateMatrix180(matrix, rows, cols));
                break;
            case 270:
                printMatrix(rotateMatrix270(matrix, rows, cols));
                break;
        }


    }

    private static char[][] rotateMatrix90(char[][] matrix, int rows, int cols) {
        char[][] result = new char[cols][rows];

        int resultRow = 0;
        int resultCol = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[resultRow++][resultCol] = matrix[i][j];
            }
            resultCol++;
            resultRow = 0;
        }

        return result;
    }

    private static char[][] rotateMatrix270(char[][] matrix, int rows, int cols) {
        char[][] result = new char[cols][rows];

        int resultRow = 0;
        int resultCol = 0;
        for (char[] aMatrix : matrix) {
            for (int j = aMatrix.length - 1; j >= 0; j--) {
                result[resultRow++][resultCol] = aMatrix[j];
            }
            resultCol++;
            resultRow = 0;
        }


        return result;
    }

    private static char[][] rotateMatrix180(char[][] matrix, int rows, int cols) {
        char[][] result = new char[rows][cols];

        int resultRow = 0;
        int resultCol = 0;
        for (int k = matrix.length - 1; k >= 0; k--) {
            for (int l = matrix[k].length - 1; l >= 0; l--) {
                result[resultRow][resultCol++] = matrix[k][l];
            }
            resultCol = 0;
            resultRow++;
        }

        return result;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, List<String> inputTokens) {
        for (int i = 0; i < matrix.length; i++) {

            char[] currArr = inputTokens.get(i).toCharArray();
            int counter = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                if (counter == currArr.length) {
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = currArr[counter++];
                }
            }
        }
    }

    private static int findLongestString(List<String> inputTokens) {
        int maxLen = Integer.MIN_VALUE;

        for (String inputToken : inputTokens) {
            if (inputToken.length() > maxLen) {
                maxLen = inputToken.length();
            }
        }

        return maxLen;
    }
}
