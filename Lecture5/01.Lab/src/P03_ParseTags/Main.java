package P03_ParseTags;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();


        int upcaseIndex = input.indexOf("<upcase>");
        while (input.contains("<upcase>")) {
            int closingTag = input.indexOf("</upcase>");

            input = input.replace(
                        input.substring(upcaseIndex + 8, closingTag),
                            input.substring(upcaseIndex + 8, closingTag).toUpperCase());

            input = input.replaceFirst("<upcase>", "").replaceFirst("</upcase>", "");

            upcaseIndex = input.indexOf("<upcase>");
        }

        System.out.println(input);
    }
}
