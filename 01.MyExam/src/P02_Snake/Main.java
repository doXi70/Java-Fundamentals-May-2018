package P02_Snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long snakeLen = 1;
    private static boolean isSnakeDead = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int dimensions = Integer.parseInt(reader.readLine());
        String[][] gameField = new String[dimensions][dimensions];

        // commands for the snake.
        String[] cmds = reader.readLine().split(", ");

        fillGameField(gameField, reader);
        int[] snake = findSnakeStartPosition(gameField);


        for (String currCmd : cmds) {
            switch (currCmd) {
                case "up":
                    moveSnakeUp(gameField, snake);
                    break;
                case "down":
                    moveSnakeDown(gameField, snake);
                    break;
                case "right":
                    moveSnakeRight(gameField, snake);
                    break;
                case "left":
                    moveSnakeLeft(gameField, snake);
                    break;
            }
        }


        int foodLeft = gameFieldFoodAmount(gameField);

        if (foodLeft <= 0) {
            System.out.printf("You win! Final snake length is %d", snakeLen);
        } else if (isSnakeDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", foodLeft);
        }
    }

    private static int gameFieldFoodAmount(String[][] gameField) {
        int foodCount = 0;

        for (String[] strings : gameField) {
            for (String item : strings) {
                if (item.equals("f")) {
                    foodCount++;
                }
            }
        }

        return foodCount;
    }

    private static void moveSnakeLeft(String[][] gameField, int[] snake) {
        if (snake[1] == 0) {
            snake[1] = gameField.length - 1;
            checkForItem(gameField, snake);
        } else {
            snake[1]--;
            checkForItem(gameField, snake);
        }
    }

    private static void checkForItem(String[][] gameField, int[] snake) {
        switch (gameField[snake[0]][snake[1]]) {
            case "*":
                return;
            case "f":
                gameField[snake[0]][snake[1]] = "*";
                snakeLen++;
                break;
            case "e":
                isSnakeDead = true;
                break;
        }
    }

    private static void moveSnakeRight(String[][] gameField, int[] snake) {
        if (snake[1] == gameField.length - 1) {
            snake[1] = 0;
            checkForItem(gameField, snake);
        } else {
            snake[1]++;
            checkForItem(gameField, snake);
        }
    }

    private static void moveSnakeDown(String[][] gameField, int[] snake) {
        if (snake[0] == gameField.length - 1) {
            snake[0] = 0;
            checkForItem(gameField, snake);
        } else {
            snake[0]++;
            checkForItem(gameField, snake);
        }
    }

    private static void moveSnakeUp(String[][] gameField, int[] snake) {
        if (snake[0] == 0) {
            snake[0] = gameField.length - 1;
            checkForItem(gameField, snake);
        } else {
            snake[0]--;
            checkForItem(gameField, snake);
        }
    }

    private static int[] findSnakeStartPosition(String[][] gameField) {
        int[] position;

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j].equals("s")) {
                    return position = new int[]{i, j};
                }
            }
        }

        return null;
    }

    private static void fillGameField(String[][] gameField, BufferedReader reader) throws IOException {
        for (int i = 0; i < gameField.length; i++) {
            String[] col = reader.readLine().split(" ");
            gameField[i] = col;
        }
    }
}
