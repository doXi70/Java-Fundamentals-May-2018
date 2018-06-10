package P04_Ranking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> softUniDataBase = new LinkedHashMap<>();
        Map<String, Map<String, Long>> submissions = new LinkedHashMap<>();


        Map<String, Map<String, Long>> endResult = new TreeMap<>();

        String line;
        while (!"end of contests".equals(line = reader.readLine())) {
            String[] tokens = line.split(":");

            String contestName = tokens[0];
            String password = tokens[1];

            // TODO: MAKE SURE TO CHECK BACK IF THEY REPEAT SAME CONTEST WITH DIFF PASS ?!?!
            softUniDataBase.putIfAbsent(contestName, password);
        }


        while (!"end of submissions".equals(line = reader.readLine())) {
            String[] tokens = line.split("=>");
            String contestName = tokens[0];
            String password = tokens[1];

            if (isValidContestAndPassword(softUniDataBase, contestName, password)) {
                // ENTER THE CONTEST
                String username = tokens[2];
                Long points = Long.parseLong(tokens[3]);

                if (!submissions.containsKey(contestName)) {
                    submissions.put(contestName, new TreeMap<>());
                }

                Map<String, Long> contests = submissions.get(contestName);
                if (!contests.containsKey(username)) {
                    contests.put(username, points);
                } else {
                    long oldPoints = contests.get(username);
                    if (oldPoints < points) {
                        contests.put(username, points);
                    }
                }
            }
        }

        swap(submissions, endResult);


        StringBuilder sb = new StringBuilder();

        String name = "";
        long highest = 0;
        LinkedHashMap<String, Map<String, Long>> sorted = endResult.entrySet().stream()
                .sorted(Main::compare).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> entry : sorted.entrySet()) {
            name = entry.getKey();
            highest = entry.getValue().entrySet().stream().mapToLong(x1 -> x1.getValue()).sum();
            break;
        }

        sb.append(String.format("Best candidate is %s with total %d points.", name, highest)).append(System.lineSeparator());
        sb.append("Ranking:").append(System.lineSeparator());
        endResult.entrySet().stream()
                .forEach(student -> {
                    String te = student.getKey();
                    sb.append(te).append(System.lineSeparator());

                    student.getValue().entrySet().stream()
                            .sorted((s1, s2) -> {
                                Long x1Score = s1.getValue();
                                Long x2Score = s2.getValue();

                                return Long.compare(x2Score, x1Score);
                            })
                            .forEach(h -> {
                                String contestName = h.getKey();
                                Long points = h.getValue();

                                sb.append(String.format("#  %s -> %d", contestName, points)).append(System.lineSeparator());
                            });

                });

        System.out.println(sb);
    }

    private static void swap(Map<String, Map<String, Long>> submissions,
                             Map<String, Map<String, Long>> endResult) {

        for (Map.Entry<String, Map<String, Long>> sub : submissions.entrySet()) {
            String contest = sub.getKey();


            Map<String, Long> userDetails = sub.getValue();
            for (Map.Entry<String, Long> details : userDetails.entrySet()) {
                String username = details.getKey();
                Long score = details.getValue();

                if (!endResult.containsKey(username)) {
                    endResult.put(username, new HashMap<>());
                }

                Map<String, Long> data = endResult.get(username);
                data.put(contest, score);
                endResult.put(username, data);
            }
        }
    }

    private static boolean isValidContestAndPassword(Map<String, String> softUniDataBase,
                                                     String contestName,
                                                     String password) {

        if (softUniDataBase.containsKey(contestName)) {
            String correctPass = softUniDataBase.get(contestName);
            return correctPass.equals(password);
        }

        return false;
    }

    private static int compare(Map.Entry<String, Map<String, Long>> f1, Map.Entry<String, Map<String, Long>> f2) {
        long j = f1.getValue().entrySet().stream()
                .mapToLong(x -> x.getValue()).sum();

        long j2 = f2.getValue().entrySet().stream()
                .mapToLong(x -> x.getValue()).sum();

        return Long.compare(j2, j);
    }
}
