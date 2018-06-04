package P05_MinEvenNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Optional<Double> optionalDouble = Arrays.stream(reader.readLine().split(" "))
                .filter(x -> !x.isEmpty())
                .map(Double::parseDouble)
                .filter(x -> x % 2 == 0)
                .sorted(Double::compare)
                .findFirst();

        if(optionalDouble.isPresent()) {
            System.out.printf("%.2f", optionalDouble.get());
        } else {
            System.out.println("No match");
        }
    }
}
