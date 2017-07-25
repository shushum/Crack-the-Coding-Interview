package data.structures;

import java.util.HashSet;
import java.util.Set;

public class LinkedListsDetectACycle {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node node) {
        Set<Node> nodeStorage = new HashSet<>();

        while (node != null){

            if (nodeStorage.contains(node)){
                return true;
            }

            nodeStorage.add(node);
            node = node.next;
        }
        return false;
    }
}
