import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String username = "Denis Ivanov";
        String follower1 = "Martin Stoqnov";
        String follower2 = "Anni Kristova";
        String follower3 = "New Value";


        Map<String, List<String>> followers = new LinkedHashMap<>();
        Map<String, List<String>> following = new LinkedHashMap<>();

        int counter = 2;
        while (counter-- != 0) {

            if (!followers.containsKey(username)) {
                followers.put(username, new ArrayList<>());
                following.put(username, new ArrayList<>());

                followers.put(follower1, new ArrayList<>());
                followers.put(follower2, new ArrayList<>());

                following.put(follower1, new ArrayList<>());
                following.put(follower2, new ArrayList<>());
            } else {
                List<String> as = followers.get(username);
                as.add(follower1);
                as.add(follower2);

                List<String> bb = followers.get(follower2);
                bb.add(follower3);

                List<String> putFollower = following.get(follower1);
                putFollower.add(username);

                List<String> anniFollower = following.get(follower2);
                anniFollower.add(follower3);

                following.put(follower1, putFollower);
                following.put(follower2, anniFollower);
            }

        }

        List<Map.Entry<String, List<String>>> collect = followers.entrySet()
                .stream()
                .sorted((f1, f2) -> Integer.compare(f2.getValue().size(), f1.getValue().size()))
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
