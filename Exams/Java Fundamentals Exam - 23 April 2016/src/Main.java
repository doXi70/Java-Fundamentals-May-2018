import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static int lineCounter = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String line;
        while (!"<stop/>".equals(line = reader.readLine())) {

            Pattern p = Pattern.compile("\"(.+?)\"");
            Matcher m = p.matcher(line);

            List<String> data = new ArrayList<>();
            while (m.find()) {
                String matche = m.group(1);
                data.add(matche);
            }

            if (data.size() == 0) {
                continue;
            }

            List<String> noWhiteSpaces = Arrays.stream(line.split("\\s+"))
                    .collect(Collectors.toList());

            String checkForCommand = convertToString(noWhiteSpaces);

            if (data.size() != 1) {
                // repeat command
                repeatCommandPrint(data);
            } else {

                if (checkForCommand.contains("inverse")) {
                    // inverse
                    inverseCommandPrint(data);
                } else {
                    // reverse
                    reverseCommandPrint(data);

                }
            }
        }

    }

    private static void reverseCommandPrint(List<String> data) {
        System.out.print(lineCounter + ". ");
        System.out.println(new StringBuilder(data.get(0)).reverse());
        lineCounter++;
    }

    private static void inverseCommandPrint(List<String> data) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.get(0).length(); i++) {
            if (Character.isUpperCase(data.get(0).charAt(i))) {
                String a = Character.toString(data.get(0).charAt(i)).toLowerCase();
                sb.append(a);
            } else {
                String a = Character.toString(data.get(0).charAt(i)).toUpperCase();
                sb.append(a);
            }
        }

        System.out.println(lineCounter + ". " + sb);
        lineCounter++;
    }

    private static void repeatCommandPrint(List<String> data) {
        for (int i = 0; i < Integer.parseInt(data.get(0)); i++) {
            System.out.println(lineCounter + ". " + data.get(1));
            lineCounter++;
        }

    }

    private static String convertToString(List<String> s) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : s) {
            sb.append(s1);
        }

        return sb.toString();
    }

}
