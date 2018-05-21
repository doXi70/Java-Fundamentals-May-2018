package P05_AcademyGraduation;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> students = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String name = scanner.nextLine();
            double[] marks = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            students.put(name, marks);
        }

        for (Map.Entry<String, double[]> entry : students.entrySet()) {
            String name = entry.getKey();
            double[] marks = entry.getValue();

            double sum = 0;
            for (double mark : marks) {
                sum += mark;
            }
            double avg = sum / marks.length;

            System.out.println(name + " is graduated with " + avg);
        }


    }
}
