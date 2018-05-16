package L4;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForLust = scanner.nextDouble() * 1.2;
        BigDecimal priceInLv = new BigDecimal(priceForLust);
        BigDecimal exchangeRate = new BigDecimal(4210500000000L);
        BigDecimal total = priceInLv.multiply(exchangeRate);

        System.out.printf("%.2f marks", total);

    }
}
