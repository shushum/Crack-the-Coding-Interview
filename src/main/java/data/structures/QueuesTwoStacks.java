package data.structures;

import java.util.Scanner;
import java.util.Stack;

public class QueuesTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    private static class MyQueue<T> {
        Stack<T> in = new Stack<>();
        Stack<T> out = new Stack<>();

        public void enqueue(T i) {
            in.push(i);
        }

        public void dequeue() {
            doFlow();
            out.pop();
        }

        public T peek(){
            doFlow();
            return out.peek();
        }

        private void doFlow(){
            if (out.empty()){
                while (!in.empty()){
                    out.push(in.pop());
                }
            }
        }
    }
}
