package P02_SumBigNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger(reader.readLine());
        BigInteger num2 = new BigInteger(reader.readLine());

        System.out.println(num.add(num2));
    }
}
