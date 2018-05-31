package P06_MagicExchangeableWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().trim().split(" ");

        HashSet<Character> firstWord = new HashSet<>();
        HashSet<Character> secondWord = new HashSet<>();

        for (int i = 0; i < words[0].length(); i++) {
            firstWord.add(words[0].charAt(i));
        }

        for (int i = 0; i < words[1].length(); i++) {
            secondWord.add(words[1].charAt(i));
        }

        System.out.println(firstWord.size() == secondWord.size());

    }
}