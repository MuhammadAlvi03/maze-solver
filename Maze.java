import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;


public class Maze {
    int rows; // total rows
    int cols; // total cols

    Cell[][] cells; // matrix of maze cells
    List<List<Integer>> adjacencyList; // stores neighbors

    Random rng = new Random();

    // constructor
    public Maze(int r, int c) {
        this.rows = r;
        this.cols = c;
        
        this.cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i, j); // create cell
            }
        }

        this.adjacencyList =  new ArrayList<>();
        
    }
}
