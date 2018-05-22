package P06_AMinerTask;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resorceQuantity = new LinkedHashMap<>();

        String line;
        int counter = 1;
        String resorceName = "";
        while (!"stop".equals(line = scanner.nextLine())) {
            if (counter % 2 == 0) {
                resorceQuantity.put(resorceName, resorceQuantity.get(resorceName) + Integer.parseInt(line));
                counter++;
            } else {
                resorceName = line;

                if (!resorceQuantity.containsKey(resorceName)) {
                    resorceQuantity.put(line, 0);
                }
                counter++;
            }
        }

        for (Map.Entry<String, Integer> entry : resorceQuantity.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.printf("%s -> %d%n", key, value);
        }
    }
}
