package data.structures;

import java.util.HashMap;
import java.util.Scanner;

public class HashTableRansomNote {

    private static boolean hiJackIsSuccessful(String[] magazine, String[] ransom) {
        HashMap<String, Integer> magazinePossibilities = new HashMap<>();
        boolean success = true;

        for (String word : magazine) {
            magazinePossibilities.merge(word, 1, (a, b) -> a + b);
        }

        for (String word : ransom) {
            Integer counts = magazinePossibilities.get(word);
            if (counts == null || counts == 0) {
                success = false;
            } else {
                magazinePossibilities.put(word, counts - 1);
            }
        }

        return success;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        System.out.println(hiJackIsSuccessful(magazine, ransom) ? "Yes" : "No");
    }
}
