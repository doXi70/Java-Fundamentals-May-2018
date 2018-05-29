package P04_SeriesOfLetters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();

        int state = 0;
        char prev = input[0];
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            switch (state) {
                case 0:     //Initial state
                    state = 1;
                    prev = input[i];
                    break;
                case 1:    // Found a new letter
                    output.append(input[i - 1]);
                    if (input[i] == prev)
                        state = 2;
                    prev = input[i];
                    break;
                case 2:   // Found the same letter
                    if (input[i] != prev)
                        state = 1;
                    prev = input[i];
                    break;
            }
            ++i;
            if (input[i - 2] != prev)
                output.append(prev);
        }

        System.out.println(output);
    }
}