import java.util.*;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();

        // -- Random Data --
        map.put("Pesho", Arrays.asList(2, 3, 3, 5));
        map.put("Annie", Arrays.asList(5, 5, 6, 6));
        map.put("Boris", Arrays.asList(3, 2, 2, 4));
        map.put("Zori", Arrays.asList(2, 5, 5, 2));
        map.put("Qni", Arrays.asList(3, 5, 6, 3));
        map.put("Delys", Arrays.asList(6, 5, 2, 4));

        LinkedHashMap<String, List<Integer>> sorted = map.entrySet()
                .stream()
                .sorted((x1, x2) -> {
                    String firstStudentName = x1.getKey();
                    String secondStudentName = x2.getKey();

//                    Collections.sort(x1.getValue());
                    List<Integer> studentMarks = x1.getValue();
                    studentMarks.sort((s1, s2) -> s2 - s1);

                    return firstStudentName.compareTo(secondStudentName);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        System.out.println(sorted);


    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int age = entry.getValue();

            System.out.println(String.format("%s - %d", name, age));
        }

    }
}
