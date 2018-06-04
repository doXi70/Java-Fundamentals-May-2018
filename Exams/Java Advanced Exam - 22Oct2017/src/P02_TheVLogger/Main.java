//package P02_TheVLogger;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        var reader = new BufferedReader(new InputStreamReader(System.in));
//        Map<String, Map<String, Integer>> vlogger = new LinkedHashMap<>();
//
//        String line;
//        while (!"Statistics".equals(line = reader.readLine())) {
//            String[] tokens = line.split(" ");
//            String username = tokens[0];
//            String cmd = tokens[1];
//
//            switch (cmd) {
//                case "joined":
//                    addUser(vlogger, username);
//                    break;
//                case "followed":
//                    String followerName = tokens[2];
////                    followVlogger(vlogger, username, followerName);
//                    break;
//                default:
//                    // it should never be thrown if program works correctly.
//                    // very useful for test's for edge cases in judge tho.
//                    throw new UnsupportedOperationException();
//            }
//        }
//
////        LinkedHashMap<String, List<String>> sortedVlogger = vlogger.entrySet()
////                .stream().sorted((v1, v2) -> {
////                    int followersCountOfFirstVlogger = v1.getValue().size();
////                    int followersCountOfSecondVlogger = v2.getValue().size();
////
//////                    return Integer.compare(followersCountOfSecondVlogger, followersCountOfFirstVlogger);
//////                })
////                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
//
////        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.", vlogger.size()));
////        printVloggers(sortedVlogger);
//    }
//
//    private static void printVloggers(LinkedHashMap<String, List<String>> sortedVlogger, Map<String, Integer> follows) {
//        int counter = 1;
//        for (Map.Entry<String, List<String>> entry : sortedVlogger.entrySet()) {
//            String vloggerName = entry.getKey();
//            int countOfFollows = follows.get(vloggerName);
//
//            System.out.println(String.format("%d. %s : %d followers, %d following",
//                    counter, vloggerName, entry.getValue().size(), countOfFollows));
//
//            if (counter == 1) {
//                List<String> followers = entry.getValue();
//                Collections.sort(followers);
//                for (String follower : followers) {
//                    System.out.println(String.format("*  %s", follower));
//                }
//            }
//
//            counter++;
//        }
//    }
//
//    private static void followVlogger(Map<String, Map<String, Integer>> vlogger,
//                                      String username,
//                                      String followerName,
//                                      Map<String, Integer> follows) {
//
//        // User can't follow him self.
//        if (followerName.equals(username)) {
//            return;
//        }
//
//        // Make sure that the vlogger contains both the user, and his follower.
//        if (vlogger.containsKey(username) && vlogger.containsKey(followerName)) {
//
//            //  Add new follower to that user.
//            for (Map.Entry<String, List<String>> entry : vlogger.entrySet()) {
//                // search for the follower and make sure that he DOESN'T have the user already following him.
//                if (entry.getKey().equals(followerName) && !entry.getValue().contains(username)) {
//                    // adding follower in the vlogger
//                    List<String> followers = entry.getValue();
//                    followers.add(username);
//                    vlogger.put(followerName, followers);
//
//                    // adding to this follower +1 more follower
//                    int oldFollowersCount = follows.get(username);
//                    follows.put(username, ++oldFollowersCount);
//                }
//            }
//        }
//    }
//
//    private static void addUser(Map<String, Map<String, Integer>> vlogger, String username) {
//        vlogger.putIfAbsent(username, new LinkedHashMap<>());
//    }
//}