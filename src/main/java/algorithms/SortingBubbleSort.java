package algorithms;

import java.util.Scanner;

public class SortingBubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        bubbleSort(a);
    }

    private static void bubbleSort(int[] arrayToSort) {
        int n = arrayToSort.length;
        int swapsForWholeSort = 0;

        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwapsInCycle = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    //   swap(arrayToSort[j], arrayToSort[j + 1]);
                    int old = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = old;
                    numberOfSwapsInCycle++;
                    swapsForWholeSort++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwapsInCycle == 0) {
                break;
            }
        }

        System.out.printf("Array is sorted in %d swaps.\n", swapsForWholeSort);
        System.out.printf("First Element: %d\n", arrayToSort[0]);
        System.out.printf("Last Element: %d\n", arrayToSort[n - 1]);
    }
}
