package P05_AppliedArithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> add = (integers) -> {
            for (Integer integer : integers) {
                integer += 1;
            }
        };

        Consumer<List<Integer>> subtract = (integers) -> {
            for (Integer integer : integers) {
                integer -= 1;
            }
        };

        Consumer<List<Integer>> multiply = (integers) -> {
            for (int i = 0; i < integers.size(); i++) {
//                integers.get(i)++;
            }
        };

        Consumer<List<Integer>> print = (integers) -> {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
        };


        String line;
        while (!"end".equals(line = reader.readLine())) {
            switch (line) {
                case "add":
                    add.accept(input);
                    break;
                case "print":
                    print.accept(input);
                    break;
                case "subtract":
                    subtract.accept(input);
                    break;
                case "multiply":
                    multiply.accept(input);
                    break;
            }
        }
    }

}
