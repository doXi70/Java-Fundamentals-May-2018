package P01_ReadFile;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\SoftUni\\Java_Fundamentals\\Java-Fundamentals-May-2018\\Lecture4\\Resources\\Lab_Resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
