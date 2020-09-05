package contest662;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0 ;i <t ;i ++){
            int g = s.nextInt();
            System.out.println(g/2 + 1);
        }
    }
}
