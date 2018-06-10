package P02_Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final long INCOME_PER_HOTEL_POSSETION = 10;
    private static final long PLAYER_STARTING_MONEY = 50;

    private static long currHotelsPossetion = 0;
    private static long gameTurns = 0;
    private static long playerMoney = PLAYER_STARTING_MONEY;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String[][] gameField = new String[dimensions[0]][dimensions[1]];

        // getting the whole game field into the matrix
        for (int i = 0; i < gameField.length; i++) {
            String[] column = reader.readLine().split("");
            gameField[i] = column;
        }

        // implementing the game movement
        for (int i = 0; i < gameField.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < gameField[i].length; j++) {
                    // implementing game processes
                    gameProgress(gameField[i][j], i, j);
                }
            } else {
                for (int j = gameField[i].length - 1; j >= 0; j--) {
                    // implementing game processes
                    gameProgress(gameField[i][j], i, j);
                }
            }
        }

        // The gains for 1 more turn need to be added.
        playerMoney += currHotelsPossetion * INCOME_PER_HOTEL_POSSETION;

        System.out.println("Turns " + gameTurns);
        System.out.println("Money " + playerMoney);
    }

    private static void gameProgress(String s, int row, int col) {
        gameTurns++;
        playerMoney += currHotelsPossetion * INCOME_PER_HOTEL_POSSETION;

        switch (s) {
            case "H":
                buyHotel();
                break;
            case "J":
                goToJail();
                break;
            case "F":
                // player is free game advances with 1 turn.
                return;
            case "S":
                enterShop(row, col);
        }
    }

    private static void enterShop(int row, int col) {
        long moneySpendAtShop = (row + 1) * (col + 1);

        if (moneySpendAtShop > playerMoney) {
            moneySpendAtShop = playerMoney;
            playerMoney = 0;
        } else {
            playerMoney -= moneySpendAtShop;
        }

        System.out.printf("Spent %d money at the shop.%n", moneySpendAtShop);
    }

    private static void goToJail() {
        System.out.println("Gone to jail at turn " + (gameTurns - 1) + ".");
        playerMoney += 2 * (currHotelsPossetion * INCOME_PER_HOTEL_POSSETION);
        gameTurns += 2;
    }

    private static void buyHotel() {
        currHotelsPossetion++;
        System.out.printf("Bought a hotel for %d. Total hotels: %d.%n", playerMoney, currHotelsPossetion);
        playerMoney = 0;
    }


}
