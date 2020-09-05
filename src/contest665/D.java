package contest665;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n =s.nextInt();
            //creating tree like data structure
            //n+1 arraySize because 1 based indexing
            ArrayList<Integer>[] edges = new ArrayList[n+1];
            for(int j=0;j< edges.length;j++){
                edges[j] = new ArrayList<>();
            }
            for(int j=0;j<n-1;j++){
                int u = s.nextInt();
                int v = s.nextInt();

                edges[u].add(v);
                edges[v].add(u);
            }


            int m = s.nextInt();
            ArrayList<Long> primeFactorList = new ArrayList();
            for(int j=0;j<m;j++){
                long val = s.nextLong();
                primeFactorList.add(val);
            }
            //storing child node from each node assuming 1 as root node
            int[] childCountDp = new int[n+1];
            findChildTreeNodeCount(1,0,childCountDp,edges);

            ArrayList<Long> edgeFrequencyCount = new ArrayList<>();
            findEachEdgeFrequency(1,0,childCountDp,edges,edgeFrequencyCount, n);

            Collections.sort(edgeFrequencyCount,Collections.reverseOrder());
            Collections.sort(primeFactorList, Collections.reverseOrder());

            if(primeFactorList.size()<=n-1){
                int sizeDiff = edgeFrequencyCount.size()-primeFactorList.size();
                for(int j=0;j<sizeDiff;j++){
                    primeFactorList.add(1l);
                }
            }else{
                ArrayList<Long> primeFactorListTemp = new ArrayList();
                long product = 1;
                int j;
                for(j=0;j<=primeFactorList.size()-edgeFrequencyCount.size();j++){
                    product = (product * primeFactorList.get(j))%mod;
                }
                primeFactorListTemp.add(product);
                for(;j<primeFactorList.size();j++){
                    primeFactorListTemp.add(primeFactorList.get(j));
                }
                primeFactorList = primeFactorListTemp;
            }

            long ans = 0;
            for(int j=0;j<edgeFrequencyCount.size();j++){
                    ans = (ans +(((edgeFrequencyCount.get(j))%mod)*primeFactorList.get(j))%mod)%mod;
            }
            System.out.println(ans);

        }
    }

    private static void findEachEdgeFrequency(int curr, int last, int[] childCountDp, ArrayList<Integer>[] edges, ArrayList<Long> edgeFrequencyCount, int totalNodes) {
        ArrayList<Integer> edge = edges[curr];
        for(int i=0;i<edge.size();i++){
            int v= edge.get(i);

            if(v==last){
                continue;
            }
            long edgeFreq = childCountDp[v]*((long)totalNodes-childCountDp[v]);
            edgeFrequencyCount.add(edgeFreq);
            findEachEdgeFrequency(v,curr,childCountDp,edges,edgeFrequencyCount,totalNodes);
        }
    }

    public static int findChildTreeNodeCount(int curr, int last, int[] childCountDp, ArrayList<Integer>[] edges){

        int sum = 0;
        ArrayList<Integer> edgeList = edges[curr];
        for(int i=0;i<edgeList.size();i++){

            int v= edgeList.get(i);
            if(v==last){
                continue;
            }
            sum += findChildTreeNodeCount(v,curr,childCountDp,edges);
        }

        sum = sum + 1; //including self
        childCountDp[curr] = sum;
        return sum;
    }
}
