package algorithms;

import java.util.*;

public class BinarySearchIceCreamParlor {

    static class IceCream implements Comparable<IceCream> {
        private int id;
        private int price;

        public IceCream(int id, int price) {
            this.id = id;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(IceCream o) {
            if (this.price == o.price) {
                return this.id - o.id;
            } else {
                return this.price - o.price;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            IceCream[] iceCreams = new IceCream[n];
            for (int a_i = 0; a_i < n; a_i++) {
                int price = in.nextInt();
                a[a_i] = price;
                iceCreams[a_i] = new IceCream(a_i + 1, price);
            }

            int[] result = iceCreamSearch(iceCreams, m);

            if (result != null) {
                System.out.println(result[0] + " " + result[1]);
            }
        }
    }

    private static int[] iceCreamSearch(IceCream[] iceCreams, int money) {
        Arrays.sort(iceCreams);

        for (int i = 0; i < iceCreams.length; i++) {
            int firstCost = iceCreams[i].getPrice();
            int remainings = money - firstCost;

            if (remainings >= firstCost) {
                int secondId = binarySearch(i + 1, iceCreams.length - 1, iceCreams, remainings);

                if (secondId != -1) {
                    int firstId = iceCreams[i].getId();

                    int[] result = new int[]{firstId, secondId};
                    Arrays.sort(result);
                    return result;
                }
            }
        }
        return null;
    }

    private static int binarySearch(int first, int last, IceCream[] array, int key) {
        if (first <= last) {
            int mid = (first + last) / 2;
            if (array[mid].getPrice() == key) {
                return array[mid].getId();
            }
            if (key < array[mid].getPrice()) {
                return binarySearch(first, mid - 1, array, key);
            } else {
                return binarySearch(mid + 1, last, array, key);
            }
        } else {
            return -1;
        }
    }
}
