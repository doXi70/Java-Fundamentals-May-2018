package P03_ChessKnight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int invalidMoves = 0;
    private static int outOfBoardMoves = 0;
    private static int knightPositionRow;
    private static int knightPositionCol;

    private static List<String> capturedPieces;

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        capturedPieces = new ArrayList<>();
        String[][] chessBoard = new String[8][8];
        fillChessBoard(chessBoard, reader);

        int[] knightPosition = Arrays.stream(reader.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        knightPositionRow = knightPosition[0];
        knightPositionCol = knightPosition[1];

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] coordinates = line.split(" -> ");
            String[] coorsToMove = coordinates[1].split("");

            int[] toMoveCoordinates = new int[]{Integer.parseInt(coorsToMove[0]), Integer.parseInt(coorsToMove[1])};
            moveKnight(chessBoard, toMoveCoordinates);
        }

        System.out.println("Pieces take: " + String.join(", ", capturedPieces).replaceAll("[\\[\\]]", ""));
        System.out.println("Invalid moves: " + invalidMoves);
        System.out.println("Board out moves: " + outOfBoardMoves);

    }

    private static void moveKnight(String[][] chessBoard, int[] coordinates) {
        if (moveIsOutOfBounds(chessBoard, coordinates)) {
            outOfBoardMoves++;
        } else if (moveIsInvalid(coordinates)) {
            invalidMoves++;
        } else {
            if (capturesPiece(chessBoard, coordinates)) {
                // add the piece to the captured pieces.
                capturedPieces.add(chessBoard[coordinates[0]][coordinates[1]]);

                // removing the piece that got captured.
                chessBoard[coordinates[0]][coordinates[1]] = " ";
            }

            knightPositionRow = coordinates[0];
            knightPositionCol = coordinates[1];
        }
    }

    private static boolean capturesPiece(String[][] chessBoard, int[] coordinates) {
        return !chessBoard[coordinates[0]][coordinates[1]].equals(" ");
    }

    private static boolean moveIsInvalid(int[] coordinates) {
        int row = Math.abs(knightPositionRow - coordinates[0]);
        int col = Math.abs(knightPositionCol - coordinates[1]);

        return !((row == 2 && col == 1) || (row == 1 && col == 2));
    }


    private static boolean moveIsOutOfBounds(String[][] chessBoard, int[] coordinates) {
        try {
            /*
                Try putting the knight to the given coordinates, if its out of bound,
                catch it and return true meaning move is out of bound other wise if you
                can set the oldValue this means that coordinates are inside so return false
              */
            String canKnightGoHere = chessBoard[coordinates[0]][coordinates[1]];
        } catch (Exception ex) {
            return true;
        }

        return false;
    }

    private static void fillChessBoard(String[][] chessBoard, BufferedReader reader) throws IOException {
        for (int i = 0; i < chessBoard.length; i++) {
            String[] col = reader.readLine().replaceAll("\\|", "").split("");
            chessBoard[i] = col;
        }
    }

    // My own method just for test stuff.
    private static void printChessBoard(String[][] chessBoard) {
        for (String[] row : chessBoard) {
            for (String pieces : row) {
                System.out.print(pieces + " ");
            }
            System.out.println();
        }
    }
}
