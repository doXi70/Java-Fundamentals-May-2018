package P01_Internships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> candidates = new ArrayList<>();

        // stack
        ArrayDeque<String> problems = new ArrayDeque<>();
        // queue
        ArrayDeque<String> users = new ArrayDeque<>();

        int problemsCount = Integer.parseInt(reader.readLine());
        int usersCount = Integer.parseInt(reader.readLine());

        String line;
        for (int i = 0; i < problemsCount; i++) {
            problems.push(line = reader.readLine());
        }

        for (int i = 0; i < usersCount; i++) {
            String user = reader.readLine();
            if (user.matches("[A-Z][a-z]+( |)([A-Z][a-z]+)")) {
                users.add(user);
            }
        }

        while (users.size() >= 1) {
            if (users.size() == 1) {
                String user = users.poll();
                System.out.printf("%s gets the job!", user);
                return;
            }

            String userName = users.peek();
            String problemName = problems.peek();

            if (problemName == null) {
                System.out.print(String.join(", ", candidates));
                return;
            }

            int userNameAscii = calcUserNameASCII(userName);
            int problemsAscii = calcProblemASCII(problemName);

            if (userNameAscii > problemsAscii) {
                String currProblem = problems.remove();
                String currUser = users.poll();
                users.addLast(currUser);
                System.out.printf("%s solved %s.%n", currUser, currProblem);
                candidates.add(currUser);
            } else {
                String currProblem = problems.remove();
                problems.addLast(currProblem);

                String currUser = users.remove();
                System.out.printf("%s failed %s.%n", currUser, currProblem);
            }
        }

        if (users.size() == 1) {
            String user = users.poll();
            System.out.printf("%s gets the job!", user);
        }

    }

    private static int calcProblemASCII(String problemName) {
        char[] problemsAscii = problemName.toCharArray();
        int sum = 0;
        for (char aProblemsAscii : problemsAscii) {
            sum += aProblemsAscii;
        }

        return sum;
    }

    private static int calcUserNameASCII(String userName) {
        char[] userNameAscii = userName.toCharArray();
        int sum = 0;

        for (int i = 0; i < userName.length(); i++) {
            sum += userNameAscii[i];
        }
        return sum;
    }

    private static boolean isCandidateNameValid(ArrayDeque<String> users) {
        String currName = users.peek();

//        if()
        return false;
    }


}
