package P05_Palindromes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> palindromes = new TreeSet<>();
        String[] input = reader.readLine().split("[ ,.?!]+");

        for (String s : input) {
            if (isPalindrom(s)) {
                palindromes.add(s);
            }
        }

        System.out.println(palindromes);
    }

    private static boolean isPalindrom(String s) {
        char[] reversed = new StringBuilder(s).reverse().toString().toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (reversed[i] != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
