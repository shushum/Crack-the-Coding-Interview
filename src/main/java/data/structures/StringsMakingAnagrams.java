package data.structures;

import java.util.Scanner;

public class StringsMakingAnagrams {
    private static final int ALPHABET_CAPACITY = 26;
    private static final char FIRST_LETTER_CHAR = 'a';

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));

        in.close();
    }

    private static int numberNeeded(String first, String second) {
        int deletions = 0;
        int[] charDifference = new int[ALPHABET_CAPACITY];

        for (int i = 0; i < first.length(); i++) {
            charDifference[first.charAt(i) - (int) FIRST_LETTER_CHAR]++;
        }

        for (int i = 0; i < second.length(); i++) {
            charDifference[second.charAt(i) - (int) FIRST_LETTER_CHAR]--;
        }

        for (int i = 0; i < ALPHABET_CAPACITY; i++) {
            deletions += Math.abs(charDifference[i]);
        }

        return deletions;
    }
}
