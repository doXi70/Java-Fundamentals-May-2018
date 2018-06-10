package P01_MelrahShake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String patternToRemove = reader.readLine();

        String compilePattern = patternBuilder(patternToRemove);
        Pattern pattern = Pattern.compile(compilePattern);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Shaked it.");
            String replaceFirst = matcher.group(1);
            String replaceLast = matcher.group(2);


            text = text.replaceFirst(replaceFirst, "");
            int lastMatchIndex = text.lastIndexOf(replaceLast);
            text = text.substring(0, lastMatchIndex) + text.substring(lastMatchIndex + replaceLast.length());

            String newPattern = modifyPattern(patternToRemove);
            newPattern = patternBuilder(newPattern);

            if (newPattern.length() == 0) {
                break;
            }

            pattern = Pattern.compile(newPattern);
            matcher = pattern.matcher(text);
        }

        System.out.println("No shake.");
        System.out.println(text);
    }

    private static String modifyPattern(String patternToRemove) {
        StringBuilder sb = new StringBuilder(patternToRemove);
        int removeIndex = patternToRemove.length() / 2;
        sb.deleteCharAt(removeIndex);

        return sb.toString();
    }

    private static String patternBuilder(String patternToRemove) {
        // escapes regex special symbols from the pattern
        String pattern = Pattern.quote(patternToRemove);

        return "(" + pattern + ")" + ".*?" + "(" + pattern + ")";
    }
}
