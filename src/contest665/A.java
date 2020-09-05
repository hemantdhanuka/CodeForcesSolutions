package contest665;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int a=s.nextInt();
            int k = s.nextInt();

            if(a<=k){
                System.out.println(k-a);
            }
            else{
                System.out.println((a ^ k)%2);
            }
        }
    }
}
