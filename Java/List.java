import java.io.*;
import java.util.*;

public class List {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        
        LinkedList<Integer> myList = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            int value = scn.nextInt();
            myList.add(value);
        }
        
        int Q = scn.nextInt();
        
        for (int i = 0; i < Q; i++) {
            String query = scn.next();
            if(query.equals("Insert")){
                int x = scn.nextInt();
                int y = scn.nextInt();
                myList.add(x, y);
            }
            else if (query.equals("Delete")){
                int z = scn.nextInt();
                myList.remove(z);
            }
        }
        
        scn.close();
        
        for (Integer num : myList) {
            System.out.print(num + " ");
            
        }
    }
}
