package data.structures;

public class BinarySearchTreeCheck {
    private Node previous;

    public boolean checkBST(Node root) {
        return inOrderSearchFrom(root);
    }

    private boolean inOrderSearchFrom(Node node) {
        if (node != null) {

            if (!(inOrderSearchFrom(node.left))) {
                return false;
            }

            if (previous != null && node.data <= previous.data) {
                return false;
            }

            previous = node;
            return inOrderSearchFrom(node.right);
        }
        return true;
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
