package Project.BreadthFirstSearch;

import Project.Node;
import Project.State;

import java.util.ArrayList;

public class BFS {

    private ArrayList<Node> neighbours;
    private int nodeCount;

    public BFS(ArrayList<State> initials) {
        neighbours = new ArrayList<Node>();

        for (State state : initials) {
            neighbours.add(new Node(state, null, 0));
        }

        nodeCount = 0;
    }

    public int getNodeCount() { return nodeCount; }

    public Node solve() {

        nodeCount = 0;

        Node node = neighbours.remove(0);

        while (node != null) {

            nodeCount++;

            ArrayList<Node> suc = node.getSuccessors();

            for (Node nodeSuc : suc) {

                if (nodeSuc.getState().goal()) {
                    System.out.println("Path till solution: ");
                    return nodeSuc;
                }

                neighbours.add(nodeSuc);
            }

            if (neighbours.isEmpty()) return null;
            else node = neighbours.remove(0);
        }

        return null;
    }
}
