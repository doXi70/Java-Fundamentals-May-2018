package P01_LittleAlchemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> gold = new ArrayList<>();

        int[] inputData = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stones = new ArrayDeque<>();
        for (int anInputData : inputData) {
            stones.add(anInputData);
        }

        String line;
        while (!"Revision".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");
            String cmd = tokens[0];
            String acid = tokens[2];

            switch (cmd) {
                case "Apply":
                    applyAcid(stones, Integer.parseInt(acid), gold);
                    break;
                case "Air":
                    applyAir(stones, Integer.parseInt(acid), gold);
                    break;
                default:
                    // if its thrown I can see it in my test's in Judge - and know smth is wrong :)
                    throw new UnsupportedOperationException();
            }
        }

        while (!stones.isEmpty()) {
            System.out.print(stones.poll() + " ");
        }
        System.out.println();
        System.out.println(gold.size());
    }

    private static void applyAir(ArrayDeque<Integer> stones, int air, List<Integer> gold) {
        if (!gold.isEmpty()) {
            stones.addLast(air);

            /*
                removing one element from the gold pieces it doesn't matter which one
                since if its in the gold mine it's all 0's.
              */
            gold.remove(0);
        }
    }

    private static void applyAcid(ArrayDeque<Integer> stones, int acid, List<Integer> gold) {
        for (int i = 0; i < acid; i++) {
            if (!stones.isEmpty()) {
                int currStone = stones.peek();

                if (currStone - 1 != 0) {
                    stones.poll();
                    stones.add(--currStone);
                } else {
                    gold.add(stones.poll());
                }
            } else {
                break;
            }
        }
    }
}
