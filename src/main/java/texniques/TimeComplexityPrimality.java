package texniques;

import java.util.Scanner;

public class TimeComplexityPrimality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        for (int a0 = 0; a0 < p; a0++) {
            int n = scan.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2 || (n % 2 == 0)) {
            return false;
        }
        if (n == 2) {
            return true;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
