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
