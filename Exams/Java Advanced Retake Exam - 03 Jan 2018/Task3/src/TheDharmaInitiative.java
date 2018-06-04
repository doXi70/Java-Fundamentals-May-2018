import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("Duplicates")
public class TheDharmaInitiative {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Long, String> hydra = new LinkedHashMap<>();
        Map<Long, String> arrow = new LinkedHashMap<>();
        Map<Long, String> flame = new LinkedHashMap<>();
        Map<Long, String> pearl = new LinkedHashMap<>();
        Map<Long, String> orchid = new LinkedHashMap<>();

        String line;
        while (!"Recruit".equals(line = reader.readLine())) {
            String[] tokens = line.split(":");
            String personName = tokens[0];
            Long personId = Long.parseLong(tokens[1]);
            String stationName = tokens[2];

            switch (stationName) {
                case "Hydra":
                    hydra.put(personId, personName);
                    break;
                case "Arrow":
                    arrow.put(personId, personName);
                    break;
                case "Orchid":
                    orchid.put(personId, personName);
                    break;
                case "Flame":
                    flame.put(personId, personName);
                    break;
                case "Pearl":
                    pearl.put(personId, personName);
                    break;
                default:
                    // station name is invalid ignore command.
                    break;
            }
        }
        // new int[] {arrow.size(), flame.size(), hydra.size(), orchid.size(), pearl.size()};
        Map<String, Integer> recruits = new TreeMap<>();
        recruits.put("Arrow", arrow.size());
        recruits.put("Flame", flame.size());
        recruits.put("Hydra", hydra.size());
        recruits.put("Orchid", orchid.size());
        recruits.put("Pearl", pearl.size());

        line = reader.readLine();
        switch (line) {
            case "DHARMA Initiative":
                recruits.entrySet()
                        .stream()
                        .sorted((x1, x2) -> {
                            int value = x1.getValue();
                            int value2 = x2.getValue();

                            return value2 - value;
                        })
                        .forEach(x -> {
                            System.out.println(String.format("The %s has %d DHARMA recruits in it.", x.getKey(), x.getValue()));
                        });

                break;

            case "Arrow":
                System.out.println("The Arrow station: Development of defensive strategies, and Intelligence gathering.");
                arrow.entrySet()
                        .stream()
                        .sorted((x1, x2) -> {
                            Long x1Value = x1.getKey();
                            Long x2Value = x2.getKey();

                            return Long.compare(x2Value, x1Value);
                        })
                        .forEach(x -> {
                            System.out.println(String.format("###%s - %d", x.getValue(), x.getKey()));
                        });

                for (Map.Entry<String, Integer> entry : recruits.entrySet()) {
                    if (entry.getValue() == 0 && entry.getKey().equals("Arrow")) {
                        System.out.print("No recruits.");
                    }
                }
                break;
            case "Flame":
                System.out.println("The Flame station: Communication.");
                flame.entrySet()
                        .stream()
                        .sorted((x1, x2) -> {
                            Long x1Value = x1.getKey();
                            Long x2Value = x2.getKey();

                            return Long.compare(x2Value, x1Value);
                        })
                        .forEach(x -> {
                            System.out.println(String.format("###%s - %d", x.getValue(), x.getKey()));
                        });

                for (Map.Entry<String, Integer> entry : recruits.entrySet()) {
                    if (entry.getValue() == 0 && entry.getKey().equals("Flame")) {
                        System.out.print("No recruits.");
                    }
                }
                break;
            case "Orchid":
                System.out.println("The Orchid station: Space-time manipulation research, disguised as a Botanical station.");
                orchid.entrySet()
                        .stream()
                        .sorted((x1, x2) -> {
                            Long x1Value = x1.getKey();
                            Long x2Value = x2.getKey();

                            return Long.compare(x2Value, x1Value);
                        })
                        .forEach(x -> {
                            System.out.println(String.format("###%s - %d", x.getValue(), x.getKey()));
                        });

                for (Map.Entry<String, Integer> entry : recruits.entrySet()) {
                    if (entry.getValue() == 0 && entry.getKey().equals("Orchid")) {
                        System.out.print("No recruits.");
                    }
                }
                break;
            case "Pearl":
                System.out.println("The Pearl station: Psychological Research and/or Observation.");
                pearl.entrySet()
                        .stream()
                        .sorted((x1, x2) -> {
                            Long x1Value = x1.getKey();
                            Long x2Value = x2.getKey();

                            return Long.compare(x2Value, x1Value);
                        })
                        .forEach(x -> {
                            if (x.getKey() != 0) {
                                System.out.println(String.format("###%s - %d", x.getValue(), x.getKey()));
                            } else {
                                System.out.println(String.format("###%s - No recruits.", x.getValue()));
                            }
                        });

                for (Map.Entry<String, Integer> entry : recruits.entrySet()) {
                    if (entry.getValue() == 0 && entry.getKey().equals("Pearl")) {
                        System.out.print("No recruits.");
                    }
                }
                break;
            case "Hydra":
                System.out.println("The Hydra station: Zoological Research.");
                arrow.entrySet()
                        .stream()
                        .sorted((x1, x2) -> {
                            Long x1Value = x1.getKey();
                            Long x2Value = x2.getKey();

                            return Long.compare(x2Value, x1Value);
                        })
                        .forEach(x -> {
                            System.out.println(String.format("###%s - %d", x.getValue(), x.getKey()));
                        });

                for (Map.Entry<String, Integer> entry : recruits.entrySet()) {
                    if (entry.getValue() == 0 && entry.getKey().equals("Hydra")) {
                        System.out.print("No recruits.");
                    }
                }
                break;
            default:
                System.out.println("DHARMA Initiative does not have such a station!");
                break;
        }

    }
}
