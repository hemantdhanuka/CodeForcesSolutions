package contest670;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Hemant Dhanuka on 12/09/20
 */
public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long a[] = new long[n];
        for(int i=0;i<n;i++){
            a[i] = s.nextInt();
        }

        long diff[] = new long[n-1];
        long sumOfPositiveDiff = 0;
        for(int i =1;i<n;i++){
            diff[i-1]= a[i]-a[i-1];
            if(diff[i-1]>0){
                sumOfPositiveDiff +=diff[i-1];
            }
        }
        long bFinalValue = a[0]+sumOfPositiveDiff;
        if(bFinalValue>0){
            System.out.println((bFinalValue+1)/2);
        }
        else{
            System.out.println((bFinalValue)/2);
        }
        int q = s.nextInt();
        for(int i=0;i<q;i++){
            int l = s.nextInt()-1;
            int r = s.nextInt()-1;
            int x = s.nextInt();

            if(l>0){
                if(diff[l-1]>0){
                    sumOfPositiveDiff -= diff[l-1];
                }
                diff[l-1] +=x;
                if(diff[l-1]>0){
                    sumOfPositiveDiff += diff[l-1];
                }
            }
            if(r<n-1){
                if(diff[r]>0){
                    sumOfPositiveDiff -= diff[r];
                }
                diff[r] -=x;
                if(diff[r]>0){
                    sumOfPositiveDiff += diff[r];
                }
            }

            if(l==0){
                a[0] += x;
            }

            bFinalValue = a[0]+sumOfPositiveDiff;
            if(bFinalValue>0){
                System.out.println((bFinalValue+1)/2);
            }
            else{
                System.out.println((bFinalValue)/2);
            }

        }
    }

}