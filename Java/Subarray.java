import java.io.*;
import java.util.*;

public class Subarray {

        public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int neg_sub = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                int curr_sub = 0;

                for (int k = i; k <= j; k++) {
                    curr_sub += arr[k];
                }

                if (curr_sub < 0) {
                    neg_sub++;
                }

            }

        }
        System.out.println(neg_sub);
    }
}
