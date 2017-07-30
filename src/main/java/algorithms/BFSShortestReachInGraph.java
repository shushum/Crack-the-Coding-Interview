package algorithms;

import java.util.*;

public class BFSShortestReachInGraph {
    public static final int DEFAULT_STEP = 6;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numQueries = scan.nextInt();

        for (int q = 0; q < numQueries; q++) {
            int numNodes = scan.nextInt();
            int numEdges = scan.nextInt();

            HashMap<Integer, Node> graph = new HashMap<>();

            for (int i = 0; i < numNodes; i++) {
                graph.put(i + 1, new Node(i + 1));
            }

            for (int i = 0; i < numEdges; i++) {
                Node n1 = graph.get(scan.nextInt());
                Node n2 = graph.get(scan.nextInt());

                n1.addNewAdj(n2);
                n2.addNewAdj(n1);
            }

            int startPoint = scan.nextInt();
            findDistances(startPoint, graph);

            for (int i = 0; i < graph.size(); i++) {
                if (i + 1 != startPoint) {
                    System.out.print(graph.get(i + 1).getDistanceToSpecNode() + " ");
                }
            }
            System.out.println();
        }
        scan.close();
    }

    private static void findDistances(int startPoint, HashMap<Integer, Node> graph) {
        LinkedList<Node> toVisit = new LinkedList<>();
        Set<Node> beenThere = new HashSet<>();

        Node firstNode = graph.get(startPoint);

        firstNode.setDistanceToSpecNode(0);
        toVisit.add(firstNode);

        while (!toVisit.isEmpty()) {
            Node current = toVisit.poll();

            for (Node adj : current.getAdj()) {
                if (!beenThere.contains(adj)) {
                    adj.setDistanceToSpecNode(current.getDistanceToSpecNode() + DEFAULT_STEP);
                    toVisit.add(adj);
                    beenThere.add(adj);
                }
            }
            beenThere.add(current);
        }
    }
}

class Node {
    private int id;
    private Set<Node> adj;
    private int distanceToSpecNode;

    public Node(int id) {
        this.id = id;
        adj = new HashSet<>();
        distanceToSpecNode = -1;
    }

    public int getId() {
        return id;
    }

    public Set<Node> getAdj() {
        return adj;
    }

    public void addNewAdj(Node adj) {
        this.adj.add(adj);
    }

    public int getDistanceToSpecNode() {
        return distanceToSpecNode;
    }

    public void setDistanceToSpecNode(int distanceToSpecNode) {
        this.distanceToSpecNode = distanceToSpecNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (id != node.id) return false;
        if (distanceToSpecNode != node.distanceToSpecNode) return false;
        return adj != null ? adj.equals(node.adj) : node.adj == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }
}