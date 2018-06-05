package P01_StudentsByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
                    return Integer.parseInt(studentTokens[2]) == 2;
                })
                .sorted((s1, s2) -> {
                    String[] s1Tokens = s1.split(" ");
                    String[] s2Tokens = s2.split(" ");

                    String s1FirstName = s1Tokens[0];
                    String s2FirstName = s2Tokens[0];

                    return s1FirstName.compareTo(s2FirstName);
                }).forEach(student -> {
            String[] studentTokens = student.split(" ");
            System.out.println(studentTokens[0] + " " + studentTokens[1]);
        });


    }
}
