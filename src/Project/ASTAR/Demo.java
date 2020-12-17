package Project.ASTAR;

import Project.Node;
import Project.PuzzleSix;
import org.junit.Test;

public class Demo {

    /** @IMPLEMENTS A* Algorithm. */
    @Test
    public void puzzleProblemAStar() {

        AStar astar = new AStar(PuzzleSix.getInitial());

        long start = System.currentTimeMillis();

        Node node = astar.solve();

        if (node!=null) node.writeFather();
        else System.out.println("There's no solution.");

        System.out.println("Expanded nodes: " + String.format("%1$,4d", astar.getNodeCount()));

        long end = System.currentTimeMillis();

        System.out.println("The algorithm took " + (end - start) + " ms to find the answer.");
    }
}