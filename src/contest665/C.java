package contest665;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<t;i++){
            int n = s.nextInt();
            Long arr[] = new Long[n];
            long old[] = new long[n];
            long min = 1000000000;
            for(int j=0;j<n;j++){
                long val = s.nextInt();
                arr[j] = val;
                old[j] = val;
                if(val < min){
                    min = val;
                }
            }

            Arrays.sort(arr);

            String ans = "YES";
            for(int j=0;j<n;j++){
                if((old[j] != arr[j]) && old[j]%min !=0){
                    ans = "NO";
                    break;
                }
            }
            sb.append(ans);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
