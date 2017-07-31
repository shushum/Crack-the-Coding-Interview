package texniques;

import java.util.Scanner;

public class RecursionFibonacciNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n)
    {
        int a = 0, b = 1, c=0;

        for (int i = 0; i < n-1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
