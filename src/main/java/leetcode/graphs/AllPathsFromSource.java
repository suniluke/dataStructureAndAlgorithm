package leetcode.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class AllPathsFromSource {

    public static void main(String[] args) {
        int [][] graph = new int[][] {{4,3,1},{3,2,4},{},{4},{}};

        List<List<Integer>> allPaths = new ArrayList<>();
        List<List<Integer>> allPaths2 = allPathsSourceTargetMine(graph, allPaths, new ArrayList<>(),0);
        System.out.println(allPaths);
        System.out.println(allPaths2);
    }

    public static List<List<Integer>> allPathsSourceTargetMine(int[][] graph, List<List<Integer>> allPaths, List<Integer> paths, int index) {
        paths.add(index);

        if(index == graph.length-1){
            allPaths.add(new ArrayList<>(paths));
        }else {
            for(int currentIndex: graph[index]){
                allPathsSourceTargetMine(graph, allPaths, paths, currentIndex);
            }
        }
        paths.remove(paths.size()-1);
        return allPaths;
    }
}
