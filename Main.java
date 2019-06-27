import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    //Population size
    private static final int POP_SIZE = 5;
    public static final int PRINT_FREQUENCY = 1;
    public static final int[][] goal = new int[9][9];

    public static void main(String[] args) {
        Random r = new Random();
        Player[] subjects = new Player[POP_SIZE];
        int[][] current = new int[9][9];
        Grid starter = new Grid(current);
        String[] numString = {"273596814","184723965","695184327","521649738","349872156","768351249","452918673","937265481","816437592"};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                goal[i][j] = Integer.parseInt(numString[i].substring(j, j+1));
            }
        }
        //current = starter.copyGrid(goal);
        starter.randomize(goal);
        current = starter.getGrid();
        starter.print(current);     
        
        int idx = 0;
        do {
            for (int i = 0; i < subjects.length; i++) {
                Grid g = new Grid(current);
                subjects[i] = new Player(g);
            }
            Arrays.sort(subjects);
            current = subjects[0].grid;
            starter.print(subjects[0].grid);
        } while (subjects[0].score < 81);
        starter.print(subjects[0].grid);
    } //main()

    private static class Player implements Comparable<Player> {
        //Instantiates individual player's instance 
        private int[][] grid;
        //Instantiates player score
        private int score;

        private Player(Grid grid) {
            grid.randomFill();
            this.grid = grid.getGrid();
            score = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (this.grid[i][j] == goal[i][j]) {
                        score++;
                        
                    }
                }
            }
            grid.deleteWrong(goal);
        } //Player()

        @Override
        public int compareTo(Player other) {
            return other.score - score;
        }
    } //Player
} //Main