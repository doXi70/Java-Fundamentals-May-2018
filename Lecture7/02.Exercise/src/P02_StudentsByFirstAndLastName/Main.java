package P02_StudentsByFirstAndLastName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            students.add(line);
        }


        students.stream()
                .filter(student -> {
                    String[] studentTokens = student.split(" ");
                    String firstName = studentTokens[0];
                    String lastName = studentTokens[1];

                    int result = lastName.compareTo(firstName);
                    return result > 0;
                }).forEach(System.out::println);

    }
}
