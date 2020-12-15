# Puzzle-Algorithm-AI
 AI implementation of a 2x3 puzzle.

 At the moment there's the A* algorithm implemented to find the shortest path to the solution.  
 This implementation does not include the closed nodes yet, since I want to do those separately.  
 I will later also implement Breadth-First-Search on this same problem.
  
 The way the puzzle works is simple. The -1 represents a blank space. You can move any piece
 into a blank space if you want to. The idea, has shown in the solution is to switch the blank
 space and the one, pretty much.

 ### The board:

 [ -1 0 0 ]  
 [ 0 0 1 ] 

 ### The solution:

 [ 1 0 0 ]  
 [ 0 0 -1 ]
