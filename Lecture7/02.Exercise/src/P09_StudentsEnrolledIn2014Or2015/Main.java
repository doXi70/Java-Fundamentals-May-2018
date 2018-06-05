package P09_StudentsEnrolledIn2014Or2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> students = new LinkedHashMap<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ", 2);
            String fullName = tokens[0];
            List<String> marks = Arrays.stream(tokens[1].split(" ")).collect(Collectors.toList());

            students.put(fullName, marks);
        }

        students.entrySet().stream()
                .filter(st -> st.getKey().endsWith("14") || st.getKey().endsWith("15"))
                .forEach(student -> System.out.println(String.join(" ", student.getValue())));

    }
}
