import java.util.Random;
import java.util.ArrayList;

public class Grid {
    int[][] grid = new int[9][9];

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

    public void randomize(int[][] board) {
        this.grid = board;
        print(grid);
        print(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (r.nextInt(2) != 0) this.grid[i][j] = 0;
            }
        }
        print(grid);
        print(board);
    } //randomize()

    public void randomFill() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = r.nextInt(9) + 1;
                }
            }
        }
    }

    public void deleteWrong(int[][] goal) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != goal[i][i]) {
                    grid[i][j] = 0;
                }
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

} //Grid