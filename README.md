# Puzzle-Algorithm-AI
 AI implementation of a 2x3 puzzle.  
 There are three algorithms implemented to test efficiency.

 - A*
 - A* with closed states
 - Breadth-First Search

If you test these out there's massive efficiency differences. In my cpu I've found that:

 - A* takes around 1200 - 1300 ms to complete and expands 9829 nodes.
 - A* with closed states takes 20-25 ms to complete and expands 50 nodes.
 - BFS takes around 25-35 ms to complete and expands 6119 nodes.
  
 The way the puzzle works is simple. The -1 represents a blank space. You can move any piece
 into a blank space if you want to. The idea, has shown in the solution is to switch the blank
 space and the number one, pretty much.

 ### The board:

 [ -1 0 0 ]  
 [ 0 0 1 ] 

 ### The solution:

 [ 1 0 0 ]  
 [ 0 0 -1 ]

## Class Diagram:

![Diagram Class](C:/Users/berna/OneDrive/Desktop/Adventures/Dev/Puzzle Algorithm AI/Github/xd.png)  

## Class description

### Node:

The node class represents each node and it's attributes.
From each node we can get the board state, everything related to the heuristics, it's depth and the father.
**Has methods:**

- Getters & Setters.
- toString(): prints the state and the corresponding H, G and F.
- getSuccessors(): puts into an ArrayList all nodes successors to the current one.

### Action:

The action class represents each action made in the board.
Each action represents a state, the cost of the action and the description of the action.
**Has methods:**

- Getters & Setters.

### PuzzleSix:

PuzzleSix implements State.
Here's where we solve our specific problem.
**Has methods:**

- h(): represents heuristic function.
- goal(): evaluates to true or false if the solution has been found.
- suc(): returns the list of successors for the next move. In our specific case evaluates if left, right, up or down is available.
- copy(): helper function. Copies the matrix onto a new one.
- getInitial(): Has set the initial board, and returns it. **This is where you should set the initial board.**
- equals(): checks if object is the same has the given one. Evaluates to true or false.
- hashCode(): Evaluates a single int for each board, hashCode.
- toString(): prints each board.
- get(): Gets a specific row/col value.

### A*, A* Closed, BFS.

The algorithm to use.
The three algorithms contain a solve() method that solves the problem.
Each one has its own efficiency for each case, in ours, the most effective is as said above the A* with closed states.
All of these have solve() and addNeighbours().

### Demo

Decided to use Demo to run the program instead of creating several mains because it seems more organized to me.

## .

Use the project as you want, and I hope this serves as help for many.
If you have a puzzle, adapting this to your own puzzle isn't that hard.
All you have to do is change the **PuzzleSix** class to your own problem.  

Have fun!