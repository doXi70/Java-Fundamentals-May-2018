package P01_StudentsResults;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" - ");
        String name = input[0];

        String[] details = input[1].split(", ");
        double jAdv = Double.parseDouble(details[0]);
        double jOOP = Double.parseDouble(details[1]);
        double advOOP = Double.parseDouble(details[2]);
        double avg = (jAdv + jOOP + advOOP) / 3;

        System.out.println("Name      |   JAdv|JavaOOP| AdvOOP|Average|");
        System.out.print(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", name, jAdv, jOOP, advOOP, avg));
    }
}
