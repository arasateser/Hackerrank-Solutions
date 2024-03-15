import java.util.*;

public class ArrayList {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int d = scn.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            
            for (int j = 0; j < d; j++) {
                row.add(scn.nextInt());
            }
            
            rows.add(row);
        }
        
        int q = in.nextInt();
        
        for (int i = 0; i < q; i++) {
            int x = scn.nextInt() - 1;
            int y = scn.nextInt() - 1;
            
            try {
                System.out.println(rows.get(x).get(y));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
    }
}
