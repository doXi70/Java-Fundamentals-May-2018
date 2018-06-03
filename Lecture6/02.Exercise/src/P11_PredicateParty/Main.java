package P11_PredicateParty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// overload
public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        String[] guests = reader.readLine().split("\\s+");

        String line;
        while (!"Party!".equals(line = reader.readLine())) {
            String[] commandTokennns = line.split("\\s+");
            String command = commandTokennns[0];
            switch (command) {
                case "Double":
                    List<String> additionalGuest = new ArrayList<>();
                    for (String guest : guests) {
                        if (true) {
                            additionalGuest.add(guest);
                        }
                        additionalGuest.add(guest);
                    }
                    break;
                case "Remove":

                    break;
            }
        }
    }

    private static Predicate<String> getPreicate(String predicateType, String parameter) {

        switch (predicateType) {
            case "StartsWith":
                return (guest) -> guest.startsWith(parameter);
            case "EndsWith":
                return (guest) -> guest.endsWith(parameter);
            default:
                return (guest) -> Integer.parseInt(guest) == Integer.parseInt(parameter);
        }
    }
}
