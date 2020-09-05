package contest667;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Hemant Dhanuka on 05/09/20
 */
public class E {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            int k = s.nextInt();


            long xCord[] = new long[n];
            for(int j=0;j<n;j++){
                xCord[j] = s.nextInt();
            }
            //wasting y cordinate data
            for(int j=0;j<n;j++){
                s.nextInt();
            }
            shuffleArray(xCord);
            Arrays.sort(xCord);

            int ans = solve(xCord,k);
            System.out.println(ans);

        }

    }

    private static int solve(long[] xCord, int k) {
        int n = xCord.length;
        int ans[] = new int[n];
        int ptr1=0;
        int ptr2=0;
        while(ptr1<n){

            while(ptr2<n && xCord[ptr2]-xCord[ptr1]<=k){
                ptr2++;
            }
            ans[ptr1] = ptr2 - ptr1;
            ptr1++;
        }

        int picheSeMax[] = new int[n];
        int max = 0;
        for(int i=n-1;i>=0;i--){
            max = Math.max(max,ans[i]);
            picheSeMax[i] = max;
        }


        int finalMaxAnswer = 0;
        int i =0;
        while(true){
            int j = i + ans[i];
            if(j >= n){
                finalMaxAnswer = Math.max(finalMaxAnswer,ans[i]);
                break;
            }
            finalMaxAnswer = Math.max(finalMaxAnswer,ans[i] + picheSeMax[j]);
            i++;
        }
        return finalMaxAnswer;
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