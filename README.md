This project is a maze generator and solver in Java.
It uses Prim's algorithm to generate the maze and DFS to solve it.

The Cell objects only store their row and column numbers.
The ID is calculated separately by the Maze module.
ID = (row * total columns) + column
This gives each cell a unique ID so that it is easier to work with.

I used an adjacency list to create the graph structure.
The maze is built using Prim's algorithm, starting from the fixed start cell.
The neighboring cells are added to a frontier set.
A random cell is selected from the set and connected to the maze.
I used a hash set instead of a list to prevent duplicates.

The maze is solved using a depth first search algorithm.
Visited and parent cells are tracked in a boolean array.
The path is recurisvely found from the end to the start, and reversed to output the correct path.