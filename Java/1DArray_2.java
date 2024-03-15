import java.util.*;

public class Solution {

    // Function to check if it's possible to win the game starting from index i
    public static boolean canWin(int leap, int[] game, int i) {
        // If the current index is beyond the end of the array, the game is won
        if (i >= game.length) {
            return true;
        } 
        // If the current index is negative or the cell at index i contains an obstacle (1), the game is not won
        else if (i < 0 || game[i] == 1) {
            return false;
        }
        
        // Mark the current cell as visited
        game[i] = 1;
        
        // Recursive Cases:
        // Check if it's possible to win by making one of the three moves: advancing leap steps, advancing 1 step, or going backward 1 step
        return canWin(leap, game, i + leap) || 
               canWin(leap, game, i + 1) || 
               canWin(leap, game, i - 1); //the way this line works, we are flagging every visited index (line 17).
                                          //If advancing leap or 1 step doesn't work that means it's not possible to
                                          //reach end of the array. And we need a way to stop searching for end of the array.
                                          //We are flagging every line we visited so If we can't advanced any further we will check
                                          //the previous step (which always will be flagged as `1`) to get an false return in order to stop searching.
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt(); // Number of test cases

        // Process each test case
        while (q-- > 0) {
            int n = scan.nextInt(); // Size of the array
            int leap = scan.nextInt(); // Leap size
            
            int[] game = new int[n];
            // Populate the array with values representing the game
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            // Check if it's possible to win the game starting from index 0 and print "YES" or "NO"
            System.out.println((canWin(leap, game, 0)) ? "YES" : "NO");
        }
        scan.close();
    }
}
