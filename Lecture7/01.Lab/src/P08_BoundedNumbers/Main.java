package P08_BoundedNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split(" "))
                .sorted()
                .mapToInt(Integer::parseInt).toArray();

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.stream(numbers)
                .filter(x -> x >= bounds[0] && x <= bounds[1])
                .forEach(f -> System.out.print(f + " "));
    }
}
