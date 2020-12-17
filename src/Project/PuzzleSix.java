package Project;

import java.util.ArrayList;

/** Implements Project.State which helps A* solve the puzzle.
 * Contains the function that determines the successors, the goal check, heuristics and the initial board.
 * @see State : Implemented interface. */
public class PuzzleSix implements State {

    private int[][] puzzle;

    public PuzzleSix() {
        puzzle = null;
    }

    public PuzzleSix(int[][] p) {
        this.puzzle = p;
    }

    /** Calculates Heuristic for each board.
     * The point of heuristics is to determine a better solution.
     * @return h: heuristic value.*/
    @Override
    public double h() {
        int h = 0;

        int[][] solution = {
                {1, 0, 0},
                {0, 0, -1}
        };

        for (int i=0; i<4; i++) {
            for (int a=0; a<3; a++) {
                if (puzzle[i][a] != solution[i][a]) h++;
            }
        }

        return h;
    }

    /** Checks if we have achieved the desired solution.
     * @return true or false. */
    @Override
    public boolean goal() {

        return puzzle[0][0] == 1 && puzzle[0][1] == 0 && puzzle[0][2] == 0
                && puzzle[1][0] == 0 && puzzle[1][1] == 0 && puzzle[1][2] == -1;
    }

    /** Determines the possible successors for each state.
     * This function needs one implementation for each specific puzzle case.
     * @return ArrayList<Project.Action> containing all the possible actions. */
    @Override
    public ArrayList<Action> suc() {

        int[][] newPuzzle;

        ArrayList<Action> action = new ArrayList<Action>();

        // search for -1 (blank space) and the successors are the ones around it.

        for (int i = 0; i < 2; i++) {
            for (int a = 0; a < 3; a++) {

                if (puzzle[i][a] == -1) {

                    /* If up is available. */
                    if (i == 0) {
                        newPuzzle = copy(puzzle);
                        newPuzzle[i+1][a] = puzzle[i][a];
                        newPuzzle[i][a] = puzzle[i+1][a];
                        PuzzleSix newState = new PuzzleSix(newPuzzle);
                        action.add(new Action(newState, 1));
                    }

                    /* If down is available. */
                    if (i == 1) {
                        newPuzzle = copy(puzzle);
                        newPuzzle[i-1][a] = puzzle[i][a];
                        newPuzzle[i][a] = puzzle[i-1][a];
                        PuzzleSix newState = new PuzzleSix(newPuzzle);
                        action.add(new Action(newState, 1));
                    }

                    /* If left is available. */
                    if (a <= 2 && a>0) {
                        newPuzzle = copy(puzzle);
                        newPuzzle[i][a-1] = puzzle[i][a];
                        newPuzzle[i][a] = puzzle[i][a-1];
                        PuzzleSix newState = new PuzzleSix(newPuzzle);
                        action.add(new Action(newState, 1));
                    }

                    /* If right is available. */
                    if (a >= 0 && a<2) {
                        newPuzzle = copy(puzzle);
                        newPuzzle[i][a+1] = puzzle[i][a];
                        newPuzzle[i][a] = puzzle[i][a+1];
                        PuzzleSix newState = new PuzzleSix(newPuzzle);
                        action.add(new Action(newState, 1));
                    }
                }

            }
        }

        return action;
    }

    /** Copies the current board into a new variable.
     * @param puzzle: puzzle to copy.
     * @return new copied puzzle. */
    public int[][] copy (int[][] puzzle) {
        int[][] newPuzzle = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int a = 0; a < 3; a++) {
                newPuzzle[i][a] = puzzle[i][a];
            }
        }

        return newPuzzle;
    }

    /** Contains the initial board and adds it to an ArrayList of States.
     * @return ArrayList containing the initial board. */
    public static ArrayList<State> getInitial() {
        ArrayList<State> initial = new ArrayList<State>();
        int[][] puzzle = {
                {-1, 0, 0},
                {0, 0, 1}
        };

        initial.add(new PuzzleSix(puzzle));

        return initial;
    }

    /** Checks if it is equal (same object, same board).
     * @param p: object to compare.
     * @return true or false. */
    @Override
    public boolean equals(Object p) {

        if (this == p) return true;
        if (p == null) return false;
        if (p.getClass() != getClass()) return false;

        PuzzleSix pp = (PuzzleSix) p;

        for (int i = 0; i < 2; i++) {
            for (int a = 0; a < 3; a++) {
                if (puzzle[i][a] != pp.get(i, a)) return false;
            }
        }

        return true;
    }

    /** Associates to each object a distinctive number. */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 0;
        for (int i = 0; i < 2; i++) {
            for (int a = 0; a < 3; a++) {
                result = a + i * prime;
            }
        }

        return result;
    }

    @Override
    public String toString() {

        for(int i = 0; i < 2; i++) {
            System.out.print("[ ");
            for (int a = 0; a < 3; a++) {
                System.out.print(puzzle[i][a] + "  ");
            }
            System.out.print("]");
            System.out.println();
        }

        return "";
    }

    /** gets number in specific board position.
     * @param i: row.
     * @param a: col.
     * @return the number in [row][col]. */
    public int get(int i, int a) {
        return puzzle[i][a];
    }
}
