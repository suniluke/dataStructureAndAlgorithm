package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {

    public static void main(String[] args) {
        int[][] input1 = new int[][] {{1,2},{3},{3},{}};
        int[][] input2 = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};

        List<List<Integer>> allPaths = getAllPaths(input2);
        allPaths.forEach(elem -> {
            System.out.print(elem + "    ");
        });
    }

    private static List<List<Integer>> getAllPaths(int[][] input) {
        List<List<Integer>> allPaths = new ArrayList<>();
        getAllPathsRecursive(allPaths, new ArrayList<Integer>(), 0, input);
        return allPaths;
    }

    private static void getAllPathsRecursive(List<List<Integer>> allPaths, ArrayList<Integer> paths, int index, int[][] input) {
        paths.add(index);

        if (index == input.length-1){
            allPaths.add(new ArrayList<>(paths));
        }else{
            for(int currentIndex : input[index]){
                getAllPathsRecursive(allPaths, paths, currentIndex, input);
            }
        }
        paths.remove(paths.size()-1);
    }
}
