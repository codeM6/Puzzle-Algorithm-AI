package Project;

import java.util.ArrayList;

public class Node {

    private int depth;
    private State state;
    private double g, h, f;
    private Node father;
    private String operator;

    /** Constructor that evaluates g, depth and f, depending on a Project.Node having a father or being a father.
     * @param state: current state of the node.
     * @param father: the father of the node.
     * @param cost: cost of the node. */
    public Node(State state, Node father, double cost) {

        this.state = state;
        this.father = father;

        if (father == null) {
            g = 0;
            depth = 1;
        }
        else {
            g = father.getG() + cost;
            depth = father.getDepth() + 1;
        }

        f = g + h;
    }

    public State getState() { return state; }
    public Node getFather() { return father; }
    public int getDepth() { return depth; }
    public double getG() { return g; }
    public double getF() { return f; }
    public double getH() { return h; }

    /** Gets the Project.Node's successors as leaves and stores them in an ArrayList to return.
     * @return ArrayList of nodes with the successor nodes. */
    public ArrayList<Node> getSuccessors() {
        ArrayList<Node> suc = new ArrayList<>();
        ArrayList<Action> action = state.suc();

        for (Action a: action) {
            Node node = new Node(a.getState(), this, a.getCost());
            suc.add(node);
        }

        return suc;
    }

    public void writeFather() {
        if (father!=null) {
            father.writeFather();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return operator != null && operator.equals("") ?
                (" " + operator) : getState() + " G = " + getG() + ", H = " + getH() + ", F = " + getF();
    }
}