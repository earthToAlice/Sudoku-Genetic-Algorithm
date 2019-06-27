import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    //Population size
    private static final int POP_SIZE = 100000;
    public static final int[][] goal = new int[9][9];

    public static void main(String[] args) {
        Random r = new Random();
        Player[] subjects = new Player[POP_SIZE];
        int[][] current = new int[9][9];
        Grid starter = new Grid(current);
        String[] numString = {"682135479","317429586","495687123","124573698","573896241","869214357","736942815","941358762","258761934"};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                goal[i][j] = Integer.parseInt(numString[i].substring(j, j+1));
            }
        }
        starter.randomize(goal);
        current = starter.getGrid();
        

        current = starter.getGrid();       
        
        for (int i = 0; i < subjects.length; i++) {
            Grid g = new Grid(current);
            g.randomFill();
            subjects[i] = new Player(g);
            
        }
        Arrays.sort(subjects);
        current = subjects[0].grid;

        while (subjects[0].score < 81) {
            for (int i = 0; i < subjects.length; i++) {
                Grid g = new Grid(current);
                g.randomFill();
                subjects[i] = new Player(g);
                
            }
            Arrays.sort(subjects);
            current = subjects[0].grid;
            starter.print(current);
        }
    } //main()

    private static class Player implements Comparable<Player> {
        //Instantiates individual player's instance 
        private int[][] grid;
        //Instantiates player score
        private int score;

        private Player(Grid grid) {
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