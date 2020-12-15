package ASTAR;

import java.util.ArrayList;

public class AStar {

    private int nodeCount;
    private ArrayList<Node> neighbours;

    /** AStar constructor.
     * Initializes the neighbours ArrayList and adds the new Node (initial game board) to it.
     * Initializes nodeCount.
     * @param initial: contains initial game board. */
    public AStar(ArrayList<State> initial) {
        neighbours = new ArrayList<Node>();

        for(State state: initial) {
            neighbours.add(new Node(state, null, 0));
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

            if (node.getState().goal()) {
                System.out.println("Path till solution: ");
                return node;
            }

            nodeCount++;

            ArrayList<Node> successors = node.getSuccessors();
            for (Node nodeSuc : successors) {
                addNeighbours(nodeSuc);
            }

            if (neighbours.isEmpty()) return null;
            else { node = neighbours.remove(0); }
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