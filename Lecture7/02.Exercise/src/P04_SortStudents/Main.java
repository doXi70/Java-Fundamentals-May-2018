package P04_SortStudents;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Pair<String, String>> students = new ArrayList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];

            Pair<String, String> student = new Pair<>(firstName, lastName);
            students.add(student);
        }

        Comparator<Pair<String, String>> comp1 = Comparator.comparing(Pair::getValue);
        Comparator<Pair<String, String>> comp2 = ((s1, s2) -> s2.getKey().compareTo(s1.getKey()));


        students.stream()
                .sorted(comp1.thenComparing(comp2))
                .forEach(x -> System.out.printf("%s %s%n", x.getKey(), x.getValue()));

    }
}
