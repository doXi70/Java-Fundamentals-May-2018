package P08_FindTheSmallestElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestIndex = x -> {
            int minValue = Collections.min(x);

            for (int i = x.size() - 1; i >= 0; i--) {
                if (minValue == x.get(i)) {
                    return i;
                }
            }

            return -1;
        };

        System.out.println(findSmallestIndex.apply(numbers));
    }
}
