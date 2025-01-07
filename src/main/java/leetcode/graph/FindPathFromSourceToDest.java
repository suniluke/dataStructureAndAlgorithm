package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class FindPathFromSourceToDest {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};

        int n = 10;
        int source = 5;
        int dest = 9;

        boolean isPathAvailable = findIfPathIsAvailable(n, graph,source, dest);
    }

    private static boolean findIfPathIsAvailable(int n, int[][] graph, int source, int dest) {
        boolean ans = false;
        //create adjacency list
        List<List<Integer>> adjacencyListGraph = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjacencyListGraph.add(new ArrayList<>());
        }
        for(int[] currentPair : graph){
            adjacencyListGraph.get(currentPair[0]).add(currentPair[1]);
            adjacencyListGraph.get(currentPair[1]).add(currentPair[0]);
        }
        for(int i=0; i<adjacencyListGraph.size(); i++){
            System.out.print( i + " --> ");
            adjacencyListGraph.get(i).forEach( e -> {
                System.out.print(e + " , " );
            });
            System.out.println();
        }

        //DFS
        boolean[] visitedVertex = new boolean[n];
        ans =  findPath(n, adjacencyListGraph, source, dest, ans, visitedVertex);
        System.out.println("answer: " + ans);
        return ans;
    }

    private static boolean findPath(int n, List<List<Integer>> adjacencyListGraph, int source, int dest, boolean ans, boolean[] visitedVertex) {
        visitedVertex[source] = true;

        for(int nextVertex: adjacencyListGraph.get(source)){
            if(nextVertex == dest){
                return true;
            }
            if(!visitedVertex[nextVertex]){
               ans = findPath(n, adjacencyListGraph, nextVertex, dest,ans, visitedVertex);
            }
        }
        return ans;
    }
}
