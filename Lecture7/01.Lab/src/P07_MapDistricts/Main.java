package P07_MapDistricts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> cities = new HashMap<>();

        List<String> input = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        for (String citiesData : input) {
            String[] tokens = citiesData.split(":");
            String town = tokens[0];
            Integer population = Integer.parseInt(tokens[1]);

            if (!cities.containsKey(town)) {
                cities.put(town, new ArrayList<>());
            }

            cities.get(town).add(population);
        }

        int populationTreshold = Integer.parseInt(reader.readLine());

        cities.entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    Integer value = c1.getValue().stream().reduce((x1, x2) -> x1 + x2).get();
                    Integer value2 = c2.getValue().stream().reduce((x1, x2) -> x1 + x2).get();

                    return Integer.compare(value2, value);
                })
                .filter(p -> {
                    int sumOfPopulation = p.getValue().stream().reduce((q1, q2) -> q1 + q2).get();

                    return sumOfPopulation > populationTreshold;
                })
                .forEach(city -> {
                    System.out.printf("%s: ", city.getKey());

                    city.getValue()
                            .stream()
                            .sorted((o1, o2) -> Integer.compare(o2, o1))
                            .limit(5)
                            .forEach(v -> System.out.print(v + " "));

                    System.out.println();
                });
    }
}
