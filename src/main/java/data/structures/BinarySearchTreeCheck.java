package data.structures;

public class BinarySearchTreeCheck {
    private boolean flag = true;

    boolean checkBST(Node root) {
        return inOrderSearchFrom(root);
    }

    private boolean inOrderSearchFrom(Node root) {
        if (root.left != null) {
            if (root.left.data < root.data) {
                return inOrderSearchFrom(root.left);
            } else {
                return false;
            }
        }

        if (root.right != null){
            if (root.right.data > root.data) {
                return inOrderSearchFrom(root.right);
            } else {
                return false;
            }
        }

        return flag;
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
