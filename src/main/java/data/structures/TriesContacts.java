package data.structures;

import java.util.HashMap;
import java.util.Scanner;

public class TriesContacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TrieTree tries = new TrieTree();
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();

            switch (op) {
                case "add":
                    tries.add(contact);
                    break;
                case "find":
                    System.out.println(tries.find(contact));
                    break;
                default:
                    System.out.println("Wrong command type!");
                    break;
            }
        }

        in.close();
    }

    private static class TrieNode {
        private HashMap<Character, TrieNode> children;
        private int usesOfThisTrieNode;

        TrieNode() {
            this.children = new HashMap<>();
            this.usesOfThisTrieNode = 0;
        }

        private void putNewChildIfAbsent(Character ch) {
            children.putIfAbsent(ch, new TrieNode());
        }

        private TrieNode getChild(Character ch) {
            return children.get(ch);
        }

        private int getUsesOfThisTrieNode() {
            return usesOfThisTrieNode;
        }

        private void incrementUses() {
            usesOfThisTrieNode++;
        }
    }

    private static class TrieTree {
        private TrieNode root;

        private TrieTree() {
            this.root = new TrieNode();
        }

        private void add(String name) {
            TrieNode current = root;
            for (int i = 0; i < name.length(); i++) {
                Character letter = name.charAt(i);
                current.putNewChildIfAbsent(letter);
                current = current.getChild(letter);
                current.incrementUses();
            }
        }

        private int find(String partial) {
            TrieNode current = root;
            for (int i = 0; i < partial.length(); i++) {
                Character letter = partial.charAt(i);
                current = current.getChild(letter);

                if (current == null) {
                    return 0;
                }
            }

            return current.getUsesOfThisTrieNode();
        }

    }
}
