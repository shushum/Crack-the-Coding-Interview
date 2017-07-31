package texniques;

import java.util.HashMap;
import java.util.Scanner;

public class RecursionDavisStaircase {
    private static HashMap<Integer, Integer> recursionKeys = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(climbVariations(n));
        }


    }

    private static int climbVariations(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (!recursionKeys.containsKey(n)) {
            recursionKeys.put(n, climbVariations(n - 1) + climbVariations(n - 2) + climbVariations(n - 3));
        }

        return recursionKeys.get(n);
    }
}
