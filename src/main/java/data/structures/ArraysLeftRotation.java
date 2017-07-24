package data.structures;

import java.util.*;

public class ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int result[] = leftRotationBy(k, a);

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        in.close();
    }

    private static int[] leftRotationBy(int rotation, int[] rotatedArray){
        int actualRotation = rotation % rotatedArray.length;

        if (actualRotation == 0){
            return rotatedArray;
        } else {
            int arrayLength = rotatedArray.length;
            int[] resultArray = new int[rotatedArray.length];

            System.arraycopy(rotatedArray, 0, resultArray, arrayLength - actualRotation, actualRotation);
            System.arraycopy(rotatedArray, actualRotation, resultArray, 0, arrayLength - actualRotation);

            return resultArray;
        }
    }
}
