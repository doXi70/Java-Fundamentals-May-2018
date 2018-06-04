package P07_PredicateForNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int nameLenCondition = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");
        Predicate<String> checkNameLen = (x) -> x.length() <= nameLenCondition;

        Arrays.stream(names).forEach(x -> {
            if(checkNameLen.test(x)) {
                System.out.println(x);
            }
        });


    }
}
