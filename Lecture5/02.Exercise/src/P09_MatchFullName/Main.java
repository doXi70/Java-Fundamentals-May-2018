package P09_MatchFullName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));


        String line;
        while (!"end".equals(line = reader.readLine())) {
            if (line.matches("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b")) {
                System.out.println(line);
            }
        }
    }
}
