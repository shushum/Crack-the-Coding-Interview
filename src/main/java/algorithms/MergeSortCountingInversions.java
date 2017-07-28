package algorithms;

import java.util.Scanner;

public class MergeSortCountingInversions {
    private static long counter = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }

            mergeSort(arr, 0, arr.length, new int[arr.length]);

            System.out.println(counter);
            counter = 0;
        }

    }

    private static void mergeSort(int[] array, int startInclusive, int endExclusive, int[] buff) {
        final int length = endExclusive - startInclusive;

        if (length <= 1) {
            return;
        }

        final int mid = startInclusive + length / 2;

        mergeSort(array, startInclusive, mid, buff);
        mergeSort(array, mid, endExclusive, buff);

        merger(array, startInclusive, mid, endExclusive, buff);
    }

    private static void merger(int[] array, int startInclusive, int mid, int endExclusive, int[] buff) {
        System.arraycopy(array, startInclusive, buff, startInclusive, endExclusive - startInclusive);

        int i = startInclusive;
        int j = mid;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= mid) {
                array[k] = buff[j++];
            } else if (j >= endExclusive) {
                array[k] = buff[i++];
            } else if (buff[i] <= buff[j]) {
                array[k] = buff[i++];
            } else {
                array[k] = buff[j++];
                counter += j - k - 1;
            }
        }
    }
}
