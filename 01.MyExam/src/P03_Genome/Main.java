package P03_Genome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// ^([a-z]+)=(\d+)--(\d+)<<(.*)$
public class Main {
    private static final String REGEX_PATTERN = "^([a-z]+)=(\\d+)--(\\d+)<<(.*)$";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> validGenomes = new LinkedHashMap<>();

        String line;
        while (!"Stop!".equals(line = reader.readLine())) {
            String[] splitInput = line.split("[!@#$?]+");
            String currGenome = convertToString(splitInput);

            genomeMatchesPattern(currGenome, validGenomes);
        }

        StringBuilder sb = new StringBuilder();
        validGenomes.entrySet().stream()
                .sorted((o1, o2) -> {
                    long genomesSize1 = o1.getValue().values().stream().mapToLong(x -> x).sum();
                    long genomesSize2 = o2.getValue().values().stream().mapToLong(x -> x).sum();

                    return Long.compare(genomesSize2, genomesSize1);
                })
                .forEach(x -> {
                    String name = x.getKey();
                    long genomesSize1 = x.getValue().values().stream().mapToLong(y -> y).sum();

                    sb.append(String.format("%s has genome size of %d", name, genomesSize1))
                            .append(System.lineSeparator());
                });

        System.out.println(sb);
    }

    private static void genomeMatchesPattern(String currGenome,
                                             Map<String, Map<String, Long>> validGenomes) {

        if (currGenome.matches(REGEX_PATTERN)) {
            String[] tokens = regexMatcher(currGenome);

            String name = tokens[0];
            long lenOfName = Long.parseLong(tokens[1]);
            long countOfGenes = Long.parseLong(tokens[2]);
            String organismBelongsTo = tokens[3];

            if (name.length() == lenOfName) {
                if (!validGenomes.containsKey(organismBelongsTo)) {
                    validGenomes.put(organismBelongsTo, new LinkedHashMap<>());
                }

                Map<String, Long> organisms = validGenomes.get(organismBelongsTo);
                if (!organisms.containsKey(name)) {
                    organisms.put(name, countOfGenes);
                } else {
                    Long oldGenomesCount = organisms.get(name);
                    Long newGenomesCount = oldGenomesCount + countOfGenes;
                    organisms.put(name, newGenomesCount);
                }
            }
        }

    }

    private static String[] regexMatcher(String currGenome) {
        String[] tokens = new String[4];

        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(currGenome);

        matcher.find();

        tokens[0] = matcher.group(1);
        tokens[1] = matcher.group(2);
        tokens[2] = matcher.group(3);
        tokens[3] = matcher.group(4);

        return tokens;
    }


    private static String convertToString(String[] splitInput) {
        StringBuilder sb = new StringBuilder();

        for (String s : splitInput) {
            sb.append(s);
        }

        return sb.toString();
    }
}
