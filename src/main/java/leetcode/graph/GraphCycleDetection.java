package leetcode.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphCycleDetection {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{2,3},{5},{5},{5},{},{}};
        GraphCycleDetection e = new GraphCycleDetection();
        boolean isCycle= e.detectCycle(graph);
        System.out.println(isCycle);
    }

    public boolean detectCycle(int[][] graph) {

        int[] visited = new int[graph.length];
        int[] pathElems = new int[graph.length];
        for (int i=0; i<graph.length; i++){
            if (visited[i] == 0){
                boolean isCycleDetected = dfsCycleDetection(graph, i, visited, pathElems);
                boolean isCycleDetectedUsingMap = dfsCycleDetectionUsingMap(graph, i, new HashMap<>());
                if(isCycleDetectedUsingMap){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCycleDetection(int[][] graph, int node, int[] visited, int[] pathElems) {

        visited[node] = 1;
        pathElems[node] = 1;

        for (int nextNode : graph[node]){

            if (visited[nextNode] == 0){ //go ahead only if its not visited
                boolean iscycle = dfsCycleDetection(graph, nextNode, visited, pathElems);
                if(iscycle){
                    return true;
                }
            } else if (pathElems[nextNode] == 1) { //means its visited before, also in the same path pf traversal
                return true;
            }
        }
        pathElems[node] = 0;
        return false;
    }

    private boolean dfsCycleDetectionUsingMap(int[][] graph, int node, Map<Integer, Boolean> map) {

        for(int nextNode : graph[node]){

            if(!map.containsKey(node)){
                boolean isCycle = dfsCycleDetectionUsingMap(graph, nextNode, map);
                if(isCycle){
                    return true;
                }
            }
            if(map.get(nextNode)){
                return true;
            }
        }
        map.remove(node);
        return false;
    }
}
