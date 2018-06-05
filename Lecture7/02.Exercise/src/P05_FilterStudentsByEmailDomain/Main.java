package P05_FilterStudentsByEmailDomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> students = new LinkedHashMap<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");
            String firstName = tokens[0];
            String lastname = tokens[1];
            String email = tokens[2];

            students.put(firstName + " " + lastname, email);
        }

        students.entrySet()
                .stream()
                .filter(s -> s.getValue().endsWith("@gmail.com"))
                .forEach(st -> System.out.println(st.getKey()));
    }
}
