package powerSet;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] set = new int[] {1,2,3};

        List<List<Integer>> lists = powerSet(set);
        System.out.println(lists.size());
        System.out.println(lists);
    }

    //Time O(2^N * N) | space O(2^N * N)
    //There are 2^N subsets and one subset have max size of N
    private static List<List<Integer>> powerSet(int[] set) {
        List<List<Integer>> powerset = new ArrayList<>();
        powerset.add(new ArrayList<>());
        for(Integer num: set){
            int length = powerset.size(); // so size in below loop does not change on going
            for(int i=0; i< length; i++){
                // not iterating through actual powerset to avoid concurrent modification exception
                List<Integer> newSubset = new ArrayList<>(powerset.get(i));
                newSubset.add(num);
                powerset.add(newSubset);
                System.out.println(newSubset);
            }
        }
        return powerset;
    }

}
