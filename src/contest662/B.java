package contest662;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    static Set<Integer> frequencyGreaterThan8 = new HashSet<>();
    static Set<Integer> frequencyGreaterThan6 = new HashSet<>();
    static Set<Integer> frequencyGreaterThan4 = new HashSet<>();
    static Set<Integer> frequencyGreaterThan2 = new HashSet<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] frequency = new int[100001];


        for (int i = 0; i < n; i++) {
            int plankLength = s.nextInt();
            frequency[plankLength]++;
        }


        for(int plankLength = 1; plankLength < 100001; plankLength++){
            addToSet(plankLength,frequency[plankLength]);
        }

        int q = s.nextInt();
        for(int j =0;j<q;j++){
            char sign = s.next().charAt(0);
            int newPlankLength = s.nextInt();

            removeFromSet(newPlankLength,frequency[newPlankLength]);
            frequency[newPlankLength] = frequency[newPlankLength] + (sign == '+' ? 1 : -1);
            addToSet(newPlankLength,frequency[newPlankLength]);

            String possible = checkPossible();
            System.out.println(possible);
        }
    }
    private static String checkPossible() {
        if((frequencyGreaterThan8.size()>0)
                || (frequencyGreaterThan6.size()>=2)
                || (frequencyGreaterThan6.size()>=1 && (frequencyGreaterThan4.size()>0 || frequencyGreaterThan2.size()>0))
                || (frequencyGreaterThan4.size()>=2)
                || (frequencyGreaterThan4.size()>=1 && frequencyGreaterThan2.size()>=2)){
            return "YES";
        }else{
            return "NO";
        }
    }

    private static void addToSet(int plankLength, int frequency) {
        if(frequency>=8){
            frequencyGreaterThan8.add(plankLength);
        }else if(frequency>=6){
            frequencyGreaterThan6.add(plankLength);
        }else if(frequency>=4){
            frequencyGreaterThan4.add(plankLength);
        }else if(frequency>=2){
            frequencyGreaterThan2.add(plankLength);
        }else{
            //no where to add
        }
    }

    private static void removeFromSet(int plankLength, int frequency) {
        if(frequency>=8){
            frequencyGreaterThan8.remove(plankLength);
        }else if(frequency>=6){
            frequencyGreaterThan6.remove(plankLength);
        }else if(frequency>=4){
            frequencyGreaterThan4.remove(plankLength);
        }else if(frequency>=2){
            frequencyGreaterThan2.remove(plankLength);
        }else{
            //frequency is small than length 2
        }
    }
}