package leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class TownJudge {
    public static void main(String[] args) {
        int[][] trusts = new int[][]{{1,3},{1,4},{2,3}};
        int judge = findudge(trusts, 4);
        System.out.println("Judge is: " + judge);
    }

    private static int findudge(int[][] trust,int n) {
       int[] trustCount = new int[n+1];
       for(int[] currentTrust: trust){
           trustCount[currentTrust[1]]++;
           trustCount[currentTrust[0]]--;
       }

        return Arrays.stream(trustCount).filter(val -> val == n-1).boxed().collect(Collectors.collectingAndThen(Collectors.toList(),
                list -> {
            if(list.size() == 0) return -1;
            else return list.get(0);
                }));
    }
}
