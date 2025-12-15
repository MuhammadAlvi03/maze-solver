import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter maze dimensions: ");
        int rows = input.nextInt();
        int cols = input.nextInt();
        Maze maze = new Maze(rows, cols);
        maze.generateMaze();

        System.out.println("Generated Maze:");
        Display.printMaze(maze);

        List<Integer> path = MazeSolver.solveMaze(maze);
        System.out.println("\nMaze Solver:");
        Display.printSolvedMaze(maze, path);
    }
}
