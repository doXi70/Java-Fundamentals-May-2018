package P05_AppliedArithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String line;
        while (!"end".equals(line = reader.readLine())) {
            switch (line) {
                case "add":
                    numbers = numbers.stream()
                            .map(x -> x + 1)
                            .collect(Collectors.toList());
                    break;
                case "print":
                    numbers.forEach(x -> System.out.print(x + " "));
                    System.out.println();
                    break;
                case "subtract":
                    numbers = numbers.stream()
                            .map(x -> x - 1)
                            .collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers = numbers.stream()
                            .map(x -> x * 2)
                            .collect(Collectors.toList());
                    break;
            }
        }
    }

}
