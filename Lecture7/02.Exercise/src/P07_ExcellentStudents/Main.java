package P07_ExcellentStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> stundents = new LinkedHashMap<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ", 3);
            String fullName = tokens[0] + " " + tokens[1];
            List<Integer> marks = Arrays.stream(tokens[2].split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            stundents.put(fullName, marks);
        }

        stundents.entrySet().stream()
                .filter(s -> s.getValue().contains(6))
                .forEach(st -> System.out.println(st.getKey()));
    }
}
