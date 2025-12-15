import java.util.List;

public class Display {
    public static void printMaze(Maze maze) {
        int totalRows = maze.totalRows;
        int totalCols = maze.totalCols;

        // print border
        System.out.print("+");
        for (int i = 0; i < totalCols; i++) {
            System.out.print("---+");
        }
        System.out.println();

        // print cells and walls
        for (int i = 0; i < totalRows; i++) {
            System.out.print("|");
            for (int j = 0; j < totalCols; j++) {
                if (i == 0 && j == 0) { // if cell is start
                    System.out.print(" S ");
                } else if (i == totalRows - 1 && j == totalCols - 1) { // if cell is end
                    System.out.print(" E ");
                } else {
                    System.out.print("   ");
                }

                // print right side border
                if ((j < totalCols - 1) && maze.isConnected(i, j, i, j + 1)) { // if connected to the right
                    System.out.print(" ");
                } else {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.print("+");

            // print bottom border of each row
            for (int j = 0; j < totalCols; j++) {
                if ((i < totalRows - 1) && maze.isConnected(i, j, i + 1, j)) { // if connected downwards
                    System.out.print("   ");
                } else {
                    System.out.print("---");
                }
                System.out.print("+");
            }
            System.out.println();
        }
    }
}
