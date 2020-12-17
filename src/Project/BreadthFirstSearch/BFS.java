package Project.BreadthFirstSearch;

import Project.Node;
import Project.State;

import java.util.ArrayList;

public class BFS {

    private ArrayList<Node> neighbours;
    private int nodeCount;

    /** BFS Constructor.
     * Initializes the neighbours ArrayList adds the board to it.
     * Initializes nodeCount.
     * @param initial: Initial board. */
    public BFS(ArrayList<State> initial) {
        neighbours = new ArrayList<Node>();

        for (State state : initial) {
            neighbours.add(new Node(state, null, 0));
        }

        nodeCount = 0;
    }

    public int getNodeCount() { return nodeCount; }

    /** BFS Algorithm.
     * From an initial node, it expands it's successors onto the suc list.
     * Until the list is empty, for each node inside the list, we check if it is the goal node and
     * add it to the neighbours list.
     * @return the found node with the solution or null. */
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
