import java.util.Random;
import java.util.ArrayList;

public class Grid {
    int[][] grid;

    private Random r = new Random();

    public Grid(int[][] start) {
        this.grid = start;
    }
    
    public void print(int[][] board) {
        System.out.println("-------------------------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + board[i][j] + " |");
            } //for(j)
            System.out.println("\n" + "|---|---|---|---|---|---|---|---|---|");
        } //for(i)
    } //print()

    public void randomize(int[][] grid) {
        this.grid = copyGrid(grid);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (r.nextInt(18) != 0) this.grid[i][j] = 0;
            }
        }
    } //randomize()

    public void randomFill() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.grid[i][j] == 0) {
                    this.grid[i][j] = r.nextInt(9) + 1;
                }
            }
        }
    }

    public void deleteWrong(int[][] goal) {
        int[][] goalCopy = copyGrid(goal);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.grid[i][j] != goalCopy[i][j]) {
                    this.grid[i][j] = 0;
                }
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[9][9];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }

} //Grid