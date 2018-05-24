package P12_BalancedParentheses;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String anInput : input) {
            if (anInput.equals("{") || anInput.equals("(") || anInput.equals("[")) {
                stack.push(anInput);
            }

            if (anInput.equals("}") || anInput.equals(")") || anInput.equals("]")) {

                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else if (!isMatchingPair(stack.pop(), anInput)) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isMatchingPair(String pop, String s) {
        StringBuilder sb = new StringBuilder(pop);
        sb.append(s);

        return sb.toString().equals("()") || sb.toString().equals("[]") || sb.toString().equals("{}");
    }

}
