package leetcode.graph;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class EventualSafeNodes {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        EventualSafeNodes e = new EventualSafeNodes();
        List<Integer> list = e.eventualSafeNodes(graph);
        System.out.println(list);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<graph.length; i++){
            boolean isSafe = getSafeNodes(graph, i, map);
            if(isSafe) list.add(i);
        }
        return list;
    }

    private boolean getSafeNodes(int[][] graph, Integer currentNode, Map<Integer, Boolean> visited) {
        if(visited.containsKey(currentNode))
            return visited.get(currentNode);

        visited.put(currentNode, false);
        for (Integer nextNode : graph[currentNode]){
            boolean isSafe = getSafeNodes(graph, nextNode, visited);
            if(!isSafe){
                return false;
            }
            visited.put(nextNode, isSafe);
        }
        visited.put(currentNode, true);
        return true;
    }

}
