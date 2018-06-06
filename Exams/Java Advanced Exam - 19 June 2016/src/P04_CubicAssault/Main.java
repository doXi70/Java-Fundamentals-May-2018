package P04_CubicAssault;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> regionData = new TreeMap<>();

        // endData before last sorting for the print
        Map<String, Map<String, Long>> endData = new LinkedHashMap<>();

        String line;
        while (!"Count em all".equals(line = reader.readLine())) {
            String[] tokens = line.split(" -> ");

            String regionName = tokens[0].trim();
            String meteorType = tokens[1].trim();
            Long amount = Long.parseLong(tokens[2].trim());

            addRegionData(regionData, regionName, meteorType, amount);
        }

        endData = regionData;

        Comparator<Map.Entry<String, Map<String, Long>>> byBlackAmountAndRegionName = (o1, o2) -> {
            long meteor1Amount = o1.getValue().get("Black");
            long meteor2Amount = o2.getValue().get("Black");

            if (meteor1Amount == meteor2Amount) {
                int region1NameLen = o1.getKey().length();
                int region2NameLen = o2.getKey().length();

                return Integer.compare(region1NameLen, region2NameLen);
            }

            return Long.compare(meteor2Amount, meteor1Amount);
        };

        Comparator<Map.Entry<String, Long>> byAmountOrName = (x1, x2) -> {
            long x1Value = x1.getValue();
            long x2Value = x2.getValue();

            if (x1Value != x2Value) {
                return Long.compare(x2Value, x1Value);
            }

            String x1Name = x1.getKey();
            String x2Name = x2.getKey();

            return x1Name.compareTo(x2Name);
        };

        LinkedHashMap<String, Map<String, Long>> sortedByFirstComp = endData.entrySet().stream()
                .sorted(byBlackAmountAndRegionName)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> entry : sortedByFirstComp.entrySet()) {
            String regionName = entry.getKey();
            Map<String, Long> meteorData = entry.getValue();

            LinkedHashMap<String, Long> sortedMeteorDataBySecondComp = meteorData.entrySet().stream()
                    .sorted(byAmountOrName)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            System.out.println(regionName);
            for (Map.Entry<String, Long> meteorInfo : sortedMeteorDataBySecondComp.entrySet()) {
                String meteorName = meteorInfo.getKey();
                Long meteorAmount = meteorInfo.getValue();

                System.out.printf("-> %s : %d%n", meteorName, meteorAmount);
            }

        }
    }

    private static void addRegionData(Map<String, Map<String, Long>> regionData, String regionName,
                                      String meteorType, Long amount) {

        if (!regionData.containsKey(regionName)) {
            Map<String, Long> meteorDataDefaultValues = new HashMap<>();
            meteorDataDefaultValues.put("Green", 0L);
            meteorDataDefaultValues.put("Red", 0L);
            meteorDataDefaultValues.put("Black", 0L);

            regionData.put(regionName, meteorDataDefaultValues);
        }

        Map<String, Long> meteorData = regionData.get(regionName);
        if (meteorData.containsKey(meteorType)) {
            Long oldAmount = meteorData.get(meteorType);
            Long newAmount = oldAmount + amount;
            meteorData.put(meteorType, newAmount);

            modifyMeteorAmountData(meteorData);
        } else {
            meteorData.put(meteorType, amount);
        }
    }

    private static void modifyMeteorAmountData(Map<String, Long> meteorData) {
        long greenAmount = meteorData.get("Green");
        long redAmount = meteorData.get("Red");
        long blackAmount = meteorData.get("Black");

        while (greenAmount >= 1000000) {            redAmount++;
            greenAmount -= 1000000;
        }

        while (redAmount >= 1000000) {
            blackAmount++;
            redAmount -= 1000000;
        }

        meteorData.put("Green", greenAmount);
        meteorData.put("Red", redAmount);
        meteorData.put("Black", blackAmount);
    }

}