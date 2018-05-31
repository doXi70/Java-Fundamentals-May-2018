package P10_MatchPhoneNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"end".equals(line = reader.readLine())) {
            if (line.matches("^\\+359(-| )2\\1\\d{3}\\1\\d{4}$")) {
                System.out.println(line);
            }
        }
    }
}
