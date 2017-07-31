package texniques;

import java.util.Scanner;

public class DPCoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }

        System.out.println(varOfChange(coins, n));
    }

    private static int varOfChange(int[] coins, int money) {
        int matrixDim = money + 1;
        int[] varMoney = new int[matrixDim];

        varMoney[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < matrixDim; i++) {
                varMoney[i] += varMoney[i - coin];
            }
        }

        return varMoney[matrixDim - 1];
    }
}
