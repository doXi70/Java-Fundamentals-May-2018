package P01_TakeTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .distinct()
                .filter(x -> x >= 10 && x <= 20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));

    }
}
