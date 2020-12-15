package ASTAR;

import java.util.ArrayList;

public interface State {

    double h();

    boolean goal();

    ArrayList<Action> suc();

    static ArrayList<State> getInitial() { return new ArrayList<State>(); }

    boolean equals(Object p);

    int hashCode();
}
