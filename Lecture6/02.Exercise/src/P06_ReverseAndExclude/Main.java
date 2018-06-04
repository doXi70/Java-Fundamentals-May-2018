package P06_ReverseAndExclude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] reversedArr = reverseArr(array);

        int n = Integer.parseInt(reader.readLine());
        BiPredicate<Integer, Integer> divisibleByN = (divisor, currNum) -> currNum % divisor != 0;

        Arrays.stream(reversedArr).forEach(x -> {
            if (divisibleByN.test(n, x)) {
                System.out.print(x + " ");
            }
        });
    }

    private static int[] reverseArr(int[] array) {
        int[] rev = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            rev[i] = array[array.length - (i + 1)];
        }

        return rev;
    }
}
