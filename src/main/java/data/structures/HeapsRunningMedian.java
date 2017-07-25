package data.structures;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HeapsRunningMedian {
    private static class KindaHeap {
        private Queue<Integer> lowHeap = new PriorityQueue<>(Comparator.reverseOrder());
        private Queue<Integer> highHeap = new PriorityQueue<>();

        public void add(int newNumber) {
            Queue<Integer> lessQueue = lowHeap.size() <= highHeap.size() ? lowHeap : highHeap;
            lessQueue.add(newNumber);
            balanceOut();
        }

        private void balanceOut() {
            while (!lowHeap.isEmpty() && !highHeap.isEmpty() && lowHeap.peek() > highHeap.peek()) {
                Integer low = lowHeap.poll();
                Integer high = highHeap.poll();
                lowHeap.add(high);
                highHeap.add(low);
            }
        }

        public double median() {
            return lowHeap.size() == highHeap.size() ? (double) (lowHeap.peek() + highHeap.peek()) / 2 : lowHeap.peek();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        KindaHeap heap = new KindaHeap();
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            heap.add(a[a_i]);
            System.out.println(String.format("%.1f", heap.median()));
        }

        in.close();
    }
}
