package P03_StudentsByAge;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Pair<String, Integer>> students = new ArrayList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String tokens[] = line.split(" ");
            String fullName = tokens[0] + " " + tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Pair<String, Integer> student = new Pair<>(fullName, age);
            students.add(student);
        }

        students.stream()
                .filter(student -> student.getValue() >= 18 && student.getValue() <= 24)
                .forEach(s -> System.out.printf("%s %d%n", s.getKey(), s.getValue()));
    }
}
