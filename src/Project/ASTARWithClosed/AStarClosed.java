package Project.ASTARWithClosed;

import Project.Node;
import Project.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AStarClosed {

    public int nodeCount;
    public ArrayList<Node> neighbours;
    public Set<State> CLOSED;

    /** A* Constructor with closed state.
     * Initializes the neighbours ArrayList adds the board to it.
     * Initializes the CLOSED state.
     * Initializes nodeCount.
     * @param initial: Initial board. */
    public AStarClosed(ArrayList<State> initial) {
        neighbours = new ArrayList<>();
        CLOSED = new HashSet<>();

        for (State state: initial) {
            addNeighbours(new Node(state, null, 0));
        }

        nodeCount = 0;
    }

    public int getNodeCount() { return nodeCount; }

    /** A* Algorithm.
     * Checks if we found goal, if not adds the neighbours of the expanded node to the successors ArrayList and
     * repeats until there are no more neighbours.
     * @return node with the solution */
    public Node solve() {

        nodeCount = 0;
        Node node = neighbours.remove(0);

        while (node != null) {

            CLOSED.add(node.getState());

            if (node.getState().goal()) {
                System.out.println("Path till solution: ");
                return node;
            }

            nodeCount++;

            ArrayList<Node> successors = node.getSuccessors();
            for (Node nodeSuc : successors) {
                if (CLOSED.contains(nodeSuc.getState())) continue;
                addNeighbours(nodeSuc);
            }

            if (neighbours.isEmpty()) return null;
            else {
                node = neighbours.remove(0);
                CLOSED.add(node.getState());
            }
        }

        return null;
    }

    /** Helper method to add and remove neighbours from the ArrayList.
     * @param node: node to add.*/
    public void addNeighbours(Node node) {

        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).getState().equals(node.getState())) {
                if (neighbours.get(i).getF() > node.getF()) {

                    neighbours.remove(i);
                    break;
                }
            }
        }


        if (neighbours.isEmpty()) {
            neighbours.add(node);
        }
        else {

            double estimate = node.getF();

            for (int i = 0; i < neighbours.size(); i++) {

                double est = neighbours.get(i).getF();

                if (estimate <= est) {
                    neighbours.add(i, node);
                    return;
                }
            }

            neighbours.add(node);
        }
    }
}
