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

        dfs(maze, start, end, visited, parent);

        ArrayList<Integer> path = new ArrayList<>();
        int current = end;
        while(current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);
        return path;

    }

    public static void dfs(Maze maze, int currentCell, int end, boolean[] visited, int[] parent) {
        visited[currentCell] = true;
        if (currentCell == end) {
            return;
        }
        for (int neighbor : maze.getConnectedNeighbors(currentCell)) {
            if (!visited[neighbor]) {
                parent[neighbor] = currentCell;
                dfs(maze, neighbor, end, visited, parent);
            }
        }
    }
}
