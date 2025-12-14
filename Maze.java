import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;


public class Maze {
    int totalRows;
    int totalCols;

    Cell[][] cells; // matrix of maze cells
    List<List<Integer>> adjacencyList; // stores neighbors

    // constructor
    public Maze(int r, int c) {
        this.totalRows = r;
        this.totalCols = c;
        
        // init Cell matrix
        this.cells = new Cell[totalRows][totalCols];
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                cells[i][j] = new Cell(i, j); // create Cell
            }
        }

        // init adjacency list
        this.adjacencyList =  new ArrayList<>();
        for (int i = 0; i < r * c; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
    }

    // we will use an ID to identify each cell
    // the unique ID will be (row * totalCols + col)
    // helper function to get Id
    public int getId(int r, int c) {
        return r * totalCols + c;
    }

    // returns a List of cellId's of adjacent cells
    public List<Integer> getPotentialNeighbors(int cellId) {
        int row = cellId / totalCols;
        int col = cellId % totalCols;
        List<Integer> potentialNeighbors = new ArrayList<>(4);
        
        // add up neighbor
        if (row > 0) {
            potentialNeighbors.add((row - 1) * totalCols + col);
        }
        // add down neighbor
        if (row < totalRows - 1) {
            potentialNeighbors.add((row + 1 ) * totalCols + col);
        }
        // add left neighbor
        if (col > 0) {
            potentialNeighbors.add(row * totalCols + (col - 1));
        }
        // add right neighbor
        if (col < totalCols - 1) {
            potentialNeighbors.add(row * totalCols + (col + 1));
        }
        return potentialNeighbors;
    }

    // sets don't support random from index, so we can convert the set to a List and get random ID
    Random rng = new Random();
    public int getRandomFromSet(HashSet<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        int randomIndex = rng.nextInt(list.size());
        int randomId = list.get(randomIndex);
        return randomId;
    }


    public void generateMaze() {
        int numCells = totalRows * totalCols;
        boolean[] visited = new boolean[numCells]; // marks cells that are in maze
        HashSet<Integer> frontier = new HashSet<>(); // frontier as a Set rather than List to prevent duplicates
        visited[0] = true; // start is always in maze

        // add neighbors of start
        for (int neighbor : getPotentialNeighbors(0)) {
            frontier.add(neighbor);
        }

        // continue adding neighbors until maze is complete
        while (!frontier.isEmpty()) {
            
        }
    }

}
