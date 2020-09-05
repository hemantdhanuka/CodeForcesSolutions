package contest665;

import java.util.Scanner;

public class B_After_Editorial {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t= s.nextInt();
        for(int i=0;i<t;i++){
            int x1= s.nextInt();
            int y1= s.nextInt();
            int z1= s.nextInt();
            int x2= s.nextInt();
            int y2= s.nextInt();
            int z2= s.nextInt();

            int val = Math.min(z1,y2);
            z1= z1-val;
            y2= y2-val;
            int sum = 2*val;
            z1 = z1+x1;

            z2 -= Math.min(z2,z1);
            y1 -= Math.min(y1,x2+y2);

            sum = sum - 2*Math.min(z2,y1);
            System.out.println(sum);
        }
    }
}
