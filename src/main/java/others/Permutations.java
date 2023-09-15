package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> permutations = getPermutations(list);
        permutations.stream().forEach( permutation -> {
            System.out.println(permutation);
        });
    }

    private static List<List<Integer>> getPermutations(List<Integer> list) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutationsHelper(0, list, permutations);
        return permutations;
    }

    private static void permutationsHelper(int i, List<Integer> list, List<List<Integer>> permutations) {
        if(i == list.size()-1){
            permutations.add(new ArrayList<>(list));
        }else{
            for(int j=i; j<list.size(); j++){
                swap(i, j, list);
                permutationsHelper(i+1, list, permutations);
                swap(i, j, list);
            }
        }
    }

    private static void swap(int i, int j, List<Integer> list) {
        int iValue = list.get(i);
        int jValue = list.get(j);
        list.set(i, jValue);
        list.set(j, iValue);
    }
}
