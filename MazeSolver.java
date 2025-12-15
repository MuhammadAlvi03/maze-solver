import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeSolver {
    public static List<Integer> solveMaze(Maze maze) {
        int numCells = maze.totalCols * maze.totalRows;
        int start = 0;
        int end = numCells - 1;

        boolean[] visited = new boolean[numCells]; // array to keep track of visited cells
        int[] parent = new int[numCells]; // keeps track of how to reach each cell

        for (int i = 0; i < numCells; i++) {
            parent[i] = -1; // init to -1
        }

        dfs(maze, start, end, visited, parent); // call dfs to solve
        ArrayList<Integer> path = new ArrayList<>(); // stores path from end -> start
        int current = end;
        while(current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path); // correct path is stored in reverse
        return path;
    }

    private static boolean dfs(Maze maze, int currentCell, int end, boolean[] visited, int[] parent) {
        visited[currentCell] = true;
        if (currentCell == end) {
            return true; // end found
        }
        for (int neighbor : maze.getConnectedNeighbors(currentCell)) {
            if (!visited[neighbor]) {
                parent[neighbor] = currentCell;
                if (dfs(maze, neighbor, end, visited, parent)) { // recursive call
                    return true;
                }
            }
        }
        return false;
    }
}
