package powerSet;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {

        //NOT COMPLETE

        int[] set = new int[] {1,2,3,4};

        List<List<Integer>> lists = powerSet2(set);
        System.out.println(lists.size());
        System.out.println(lists);
    }

    private static List<List<Integer>> powerSet(int[] set) {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        for(int num: set){
            int size = powerSet.size();
            for(int i=0; i<size; i++){
                List<Integer> currentSubset = powerSet.get(i);
                currentSubset.add(num);
                powerSet.add(currentSubset);
            }
        }
        return powerSet;
    }

    private static List<List<Integer>> powerSet2(int[] set) {
        List<List<Integer>> powerSet = new ArrayList<>();
        for(int firstItr=0; firstItr < set.length; firstItr++){
            List<Integer> currentSet = new ArrayList<>();
            currentSet.add(set[firstItr]);
            for(int secondItr=firstItr+1; secondItr < set.length; secondItr++){
                List<Integer> copyPrevSet = new ArrayList<>(currentSet);
                //powerSet.add(copyPrevSet);
                List<Integer> copyCurrSet = new ArrayList<>(currentSet);
                copyCurrSet.add(set[secondItr]);
                powerSet.add(copyCurrSet);
            }
            powerSet.add(currentSet);
        }
        return powerSet;
    }
}
