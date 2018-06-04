package P06_FindAndSumIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Optional<Integer> optional = Arrays.stream(reader.readLine().split(" "))
                .filter(x -> !x.isEmpty())
                .filter(x -> {
                    try {
                        Integer.parseInt(x);
                        return true;
                    } catch (Exception ex) {
                        return false;
                    }
                }).map(Integer::parseInt)
                .reduce((x, y) -> x + y);

        if (optional.isPresent()) {
            System.out.printf("%d", optional.get());
        } else {
            System.out.println("No match");
        }
    }
}
