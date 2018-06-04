package P03_FirstName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split(" "))
                .sorted().collect(Collectors.toList());

        List<String> letters = Arrays.stream(reader.readLine().split(" "))
                .sorted().collect(Collectors.toList());

        Optional<String> op = names.stream().filter(x -> {
            for (String letter : letters) {
                if (x.toLowerCase().startsWith(letter.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }).findFirst();

        System.out.println(op.isPresent() ? op.get() : "No match");
    }
}
