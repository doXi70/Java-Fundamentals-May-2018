package T13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blur = Integer.parseInt(scanner.nextLine());

        String[] dimentions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimentions[0]);
        int cols = Integer.parseInt(dimentions[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            String[] lineTokes = scanner.nextLine().split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(lineTokes[j]);
            }
        }
    }
}
