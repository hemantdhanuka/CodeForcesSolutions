package contest665;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Hemant Dhanuka on 22/08/20
 */
public class Aad {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

    }


    // template code
    public static void shuffleArray(long[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }
}