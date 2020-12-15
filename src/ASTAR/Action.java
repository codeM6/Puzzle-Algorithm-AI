package ASTAR;

/** Action class represents an action.
 * In our specific game an action can be made when there's a white space (-1) in the matrix
 * @var state: the state of the puzzle.
 * @var cost: the cost for the action.
 * @var description: Extra stuff. */
public class Action {

    private State state;
    private double cost;
    private String description;

    public Action(State state, double cost) {
        this.state = state;
        this.cost = cost;
    }

    public Action(State state, double cost, String description) {
        this.state = state;
        this.cost = cost;
        this.description = description;
    }

    public State getState() { return state; }
    public double getCost() { return cost; }
    public String getDescription() { return description; }
}
