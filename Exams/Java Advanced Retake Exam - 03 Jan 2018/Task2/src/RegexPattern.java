import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {
    public static void main(String[] args) {


    }

    private static void regexChecker(String theRegex, String str2Check) {
        /*
            Using the Pattern class create new object
            with the static method compile. You must compile
            theRegex(the pattern String e.g. "\\d+").
         */
        Pattern checkRegex = Pattern.compile(theRegex);

        /*
            Then make matcher object by passing the pattern object
            and call method mather passing him the actual string to check
            e.g. "Input text to check here 123 221"
         */
        Matcher regexMatcher = checkRegex.matcher(str2Check);

        /*
            Next loop through the groups with
         */
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                System.out.println(regexMatcher.group().trim());
            }

            System.out.println("Start index: " + regexMatcher.start());
            System.out.println("End index: " + regexMatcher.end());
        }
    }
}
