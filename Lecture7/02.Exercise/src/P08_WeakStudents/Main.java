package P08_WeakStudents;

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
                .filter(s -> {
                    List<Integer> list = s.getValue();
                    int count = 0;
                    for (Integer integer : list) {
                        if (integer <= 3) {
                            count++;
                        }
                        if (count == 2) {
                            return true;
                        }
                    }
                    return false;
                }).forEach(st -> System.out.println(st.getKey()));
    }
}
