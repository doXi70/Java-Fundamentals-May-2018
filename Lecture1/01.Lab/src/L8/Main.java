package L8;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x = scanner.nextLong();
        long y = scanner.nextLong();

        BigInteger n = BigInteger.valueOf(x);
        BigInteger m = BigInteger.valueOf(y);

        BigInteger result = BigInteger.ONE;

        for (BigInteger i = BigInteger.valueOf(x); true; i = i.add(BigInteger.ONE)) {
            if (x == y) {
                break;
            }


            result = result.add(result.multiply(i));
            x++;
        }

        System.out.println(result);
    }
}
