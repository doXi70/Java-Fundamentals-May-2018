package P04_FindEvenOrOdds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        Predicate<Integer> check = (num) -> num % 2 == 0;

        int[] indexes = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String type = reader.readLine();

        for (int i = indexes[0]; i < indexes[1]; i++) {
            findAllEvenOrOdd(type, check, i);
        }


    }

    private static void findAllEvenOrOdd(String type, Predicate<Integer> check, int currNum) {
        switch (type) {
            case "odd":
                if (!check.test(currNum)) {
                    System.out.print(currNum + " ");
                }
                break;
            case "even":
                if (check.test(currNum)) {
                    System.out.print(currNum + " ");
                }
                break;
        }
    }
}
