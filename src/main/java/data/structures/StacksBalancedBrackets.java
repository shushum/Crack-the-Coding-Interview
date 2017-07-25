package data.structures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StacksBalancedBrackets {

    private static boolean isBalanced(String expression) {
        if (expression.length() < 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket : expression.toCharArray()) {
            switch (bracket) {
                case ('{'):
                    stack.push('}');
                    break;
                case ('['):
                    stack.push(']');
                    break;
                case ('('):
                    stack.push(')');
                    break;
                default:
                    if (stack.isEmpty() || !stack.peek().equals(bracket)) {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
