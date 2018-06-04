import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> testMap = new HashMap<>();

        Map<String, Integer> insideMap = new HashMap<>();
        Map<String, Integer> insideMap2 = new HashMap<>();


        insideMap.put("test", 2);
        insideMap.put("asd", 4);
        insideMap.put("asz", 1);
        insideMap.put("zxczxcxzc", 6);

        insideMap2.put("adv", 2);
        insideMap2.put("ff", 3);
        insideMap2.put("vvvv", 1);

        testMap.put("Pesho", insideMap);
        testMap.put("Gosho", insideMap2);

        System.out.println(testMap);

        testMap.entrySet()
                .stream()
                .sorted((m1, m2) -> {
                    int valueSize = m1.getValue().size();
                    int value2Size = m2.getValue().size();

                    return Integer.compare(value2Size, valueSize);
                })
                .forEach(m -> {
                    m.getValue()
                            .values()
                            .stream()
                            .sorted((v1, v2) -> Integer.compare(v2, v1))
                            .forEach(player -> {

                            });

                });

    }
}
