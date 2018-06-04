import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));


        int[] firstInts = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> theIntegers = new ArrayDeque<>();
        for (int i = 0; i < firstInts.length; i++) {
            theIntegers.add(firstInts[i]);
        }

        int[] inputInts = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> toCheck = new ArrayDeque<>();
        for (int num : inputInts) {
            toCheck.add(num);
        }

        List<Integer> toPrint = new ArrayList<>();
        while (toPrint.size() != 6) {
            int firstNum = theIntegers.peek();
            int secondNum = toCheck.peek();

            if (secondNum % firstNum == 0) {
                toPrint.add(toCheck.poll());
                theIntegers.poll();
            } else {
                int newValue = toCheck.poll() + 1;
                toCheck.add(newValue);
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < toPrint.size(); i++) {
            if (i != toPrint.size() - 1) {
                sb.append(toPrint.get(i)).append(", ");
            } else {
                sb.append(toPrint.get(i));
            }
        }

        System.out.println(sb);
    }
}
/*
 if (firstNum >= secondNum) {
                if (firstNum % secondNum == 0) {
                    toPrint.add(toCheck.poll());
                    theIntegers.poll();
                } else {
                    int newValue = toCheck.poll() + 1;
                    toCheck.add(newValue);
                }
            } else {
                int newValue = toCheck.poll() + 1;
                toCheck.add(newValue);
            }
 */