package Project.BreadthFirstSearch;

import Project.Node;
import Project.PuzzleSix;
import org.junit.Test;

public class Demo {

    /** @IMPLEMENTS A* Algorithm with closed states. */
    @Test
    public void puzzleProblemBFS() {

        BFS bfs = new BFS(PuzzleSix.getInitial());

        long start = System.currentTimeMillis();

        Node node = bfs.solve();

        if (node!=null) node.writeFather();
        else System.out.println("There's no solution.");

        System.out.println("Expanded nodes: " + String.format("%1$,4d", bfs.getNodeCount()));

        long end = System.currentTimeMillis();

        System.out.println("The algorithm took " + (end - start) + " ms to find the answer.");
    }
}
