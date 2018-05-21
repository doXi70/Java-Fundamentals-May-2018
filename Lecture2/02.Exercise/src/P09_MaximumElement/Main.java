package P09_MaximumElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String command = tokens[0];
            switch (command) {
                case "1":
                    int element = Integer.parseInt(tokens[1]);
                    stack.push(element);
                    if (element > maxElement) {
                        maxElement = element;
                    }
                    break;
                case "2":
                    if (stack.pop() == maxElement) {
                        maxElement = Integer.MIN_VALUE;
                    }
                    break;
                case "3":
                    if (maxElement == Integer.MIN_VALUE) {
                        for (Integer el : stack) {
                            if (el > maxElement) {
                                maxElement = el;
                            }
                        }
                    }
                    sb.append(maxElement).append(System.lineSeparator());
                    break;
            }
        }
        System.out.print(sb);
    }
}





