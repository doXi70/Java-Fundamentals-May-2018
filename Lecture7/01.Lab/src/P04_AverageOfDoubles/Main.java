package P04_AverageOfDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble optionalDouble =
                Arrays.stream(reader.readLine().split(" "))
                        .filter(x -> !x.isEmpty())
                        .mapToDouble(Double::parseDouble).average();

        if (optionalDouble.isPresent()) {
            System.out.printf("%.2f", optionalDouble.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
