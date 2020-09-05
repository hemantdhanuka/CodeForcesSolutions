package contest665;

import java.util.Scanner;

public class B {

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

            int sum=0;

            if(z1>y2){
                sum = sum + y2*2;
                z1= z1-y2;

                if(z1+x1<z2){
                    z2 = z2-(x1+z1);
                    sum = sum - 2*Math.min(z2,y1);
                }
            }else{
                sum = sum + z1*2;
                if(x1<z2){
                    z2 = z2-x1;
                    sum = sum - 2*(Math.min(z2,y1));
                }
            }

            System.out.println(sum);
        }
    }
}
