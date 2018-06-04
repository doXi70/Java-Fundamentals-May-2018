import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMA_Supplies {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();
        List<String> foodCrates = new LinkedList<>();
        List<String> drinksCrates = new LinkedList<>();

        String line;
        int numberOfInputLines = 0;
        while (!"Collect".equals(line = reader.readLine())) {
            numberOfInputLines++;
            input.append(line);
        }

        var creates = findCrates(input.toString());
        var lengthOfAllValidSupplyTags = creates.size() / numberOfInputLines;

        // pattern for food ->  \[(#[a-z]{1})([A-Za-z\s+]+)\1\]
        var drinksPattern = "\\[(#[a-z]{" + lengthOfAllValidSupplyTags + "})([A-Za-z\\s+]+)\\1\\]";

        // pattern for drinks -> \[(#[0-9]{1})([A-Za-z\s+]+)\1\]
        var foodPattern = "\\[(#[0-9]{" + lengthOfAllValidSupplyTags + "})([A-Za-z\\s+]+)\\1\\]";

        for (String create : creates) {
            foodCrates.addAll(regexChecker(foodPattern, create));
            drinksCrates.addAll(regexChecker(drinksPattern, create));
        }

        LinkedList<String> plainBodyCrates = new LinkedList<>();
        Pattern p = Pattern.compile("\\[(#[0-9]{" + lengthOfAllValidSupplyTags + "})([A-Za-z\\s+]+)\\1\\]");

        for (String foodCrate : foodCrates) {
            Matcher m = p.matcher(foodCrate);
            while (m.find()) {
                plainBodyCrates.add(m.group(2));
            }
        }


        ArrayList<String> plainBodyDrinks = new ArrayList<>();
        ArrayList<String> supplyBodyOfDrinks = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\[(#[a-z]{" + lengthOfAllValidSupplyTags + "})([A-Za-z\\s+]+)\\1\\]");
        for (String drinksCrate : drinksCrates) {
            Matcher m = pattern.matcher(drinksCrate);
            while (m.find()) {
                plainBodyDrinks.add(m.group(2));
                supplyBodyOfDrinks.add(m.group(1));
            }
        }

        int foodsCollected = calcFoodAmount(plainBodyCrates, lengthOfAllValidSupplyTags);
        int drinksCollected = calcDrinksAmount(plainBodyDrinks, supplyBodyOfDrinks);

        if (foodsCollected == 0 && drinksCollected == 0) {
            System.out.println("No supplies found!");
        } else {
            System.out.printf("Number of supply crates: %d%nAmount of food collected: %d%nAmount of drinks collected: %d%n",
                    foodCrates.size() + drinksCrates.size(), foodsCollected, drinksCollected);
        }
    }

    private static int calcDrinksAmount(List<String> drinksCrates, ArrayList<String> plainTagOfDrinks) {
        int totalSum = 0;

        for (int i = 0; i < drinksCrates.size(); i++) {
            int drink = calcDrinks(drinksCrates.get(i));
            int tag = calcTag(plainTagOfDrinks.get(i));

            if(tag == 0) {
                totalSum += drink;
            } else {
                totalSum += drink * tag;
            }

        }

        return totalSum;
    }

    private static int calcTag(String s) {
        int sum = 0;

        String tagWIthOutStart = s.substring(1);
        for (char c : tagWIthOutStart.toCharArray()) {
            sum += c;
        }
        return sum;
    }

    private static int calcDrinks(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }

    private static int calcFoodAmount(List<String> foodCrates, int lengthOfAllValidSupplyTags) {
        int totalSum = 0;

        for (String foodCrate : foodCrates) {
            Set<Character> uniqueBodySymbols = new HashSet<>();

            char[] foodBody = foodCrate.toCharArray();
            for (char aFoodBody : foodBody) {
                uniqueBodySymbols.add(aFoodBody);
            }
            totalSum += sumAllASCII(uniqueBodySymbols, lengthOfAllValidSupplyTags);
        }

        return totalSum;
    }

    private static int sumAllASCII(Set<Character> uniqueBodySymbols, int lengthOfAllValidSupplyTags) {
        int sum = 0;
        Iterator<Character> it = uniqueBodySymbols.iterator();
        while ((it.hasNext())) {
            sum += it.next();
        }

        return sum * lengthOfAllValidSupplyTags;
    }

    private static LinkedList<String> findCrates(String input) {
        var cratesFound = new LinkedList<String>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '[') {
                sb.append(ch);
                while (ch != ']') {
                    if (i + 1 >= input.length()) {
                        break;
                    }
                    ch = input.charAt(i + 1);
                    sb.append(ch);
                    i++;
                }

                cratesFound.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return cratesFound;
    }

    private static LinkedList<String> regexChecker(String theRegex, String str2Check) {
        Pattern pattern = Pattern.compile(theRegex);
        Matcher matcher = pattern.matcher(str2Check);
        LinkedList<String> matchedGroups = new LinkedList<>();

        while (matcher.find()) {
            matchedGroups.add(matcher.group());
        }

        return matchedGroups;
    }
}
