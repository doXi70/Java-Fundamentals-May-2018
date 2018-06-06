package P02_TheVLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int counter = 1;

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> teqKoitoGoSledvat = new LinkedHashMap<>();
        Map<String, List<String>> teqKoitoTOIsledva = new LinkedHashMap<>();

        String line;
        while (!"Statistics".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");
            String username = tokens[0];
            String cmd = tokens[1];

            switch (cmd) {
                case "joined":
                    addUser(teqKoitoGoSledvat, username, teqKoitoTOIsledva);
                    break;
                case "followed":
                    String followerName = tokens[2];
                    followVlogger(teqKoitoGoSledvat, username, followerName, teqKoitoTOIsledva);
                    break;
                default:
                    // it should never be thrown if program works correctly.
                    // very useful for test's for edge cases in judge tho.
                    throw new UnsupportedOperationException();
            }
        }

        /*
            Ako iskame da stravnim stringove

            str1.compareTo(str2) - narastvasht - asc
            str2.compareTo(str1) - namalqvasht - desc

         */

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", teqKoitoGoSledvat.size());

        Comparator<Map.Entry<String, List<String>>> compareByFollowing =
                (u1, u2) -> Integer.compare(u2.getValue().size(), u1.getValue().size());


        teqKoitoGoSledvat.entrySet().stream()
                .sorted((s1, s2) -> Integer.compare(s2.getValue().size(), s1.getValue().size()))
                .forEach(x -> {
                    String name = x.getKey();
                    List<String> following = x.getValue();

                    int size = teqKoitoTOIsledva.get(name).size();

                    System.out.printf("%d. %s : %d followers, %d following%n",
                            counter, name, x.getValue().size(), size);

                    following.sort(String::compareTo);
                    if (counter == 1 && x.getValue().size() != 0) {
                        for (String s : following) {
                            System.out.println("* " + s);
                        }
                    }

                    counter++;
                });

    }

    private static void followVlogger(Map<String, List<String>> teqKoitoGoSledvat, String username,
                                      String followerName, Map<String, List<String>> teqKoitoTOIsledva) {

        if (username.equals(followerName)) {
            return;
        }

        if()

        if (!teqKoitoGoSledvat.get(followerName).contains(username)) {
            List<String> listUserFollows = teqKoitoGoSledvat.get(followerName);
            listUserFollows.add(username);

            List<String> listUserFollower = teqKoitoTOIsledva.get(username);
            listUserFollower.add(followerName);
        }

    }

    private static void addUser(Map<String, List<String>> vlogger, String username, Map<String, List<String>> following) {
        vlogger.putIfAbsent(username, new ArrayList<>());
        following.putIfAbsent(username, new ArrayList<>());
    }


}