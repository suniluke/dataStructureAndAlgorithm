package leetcode.graph;

import java.util.*;

public class NetworkDelay {

    public static void main(String[] args) {

        int[][] times = {{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}};
        int  n = 5, k = 3;
        int min = networkDelayTime(times, n, k);
        System.out.println("Min Time To Visit All Nodes: " + min);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
       //create a graphMap
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] arr : times){
            int source = arr[0];
            int target = arr[1];
            int weight = arr[2];

            graph.putIfAbsent(source, new HashMap<>());
            graph.get(source).put(target, weight);
        }
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0; //for n starting from 0 to n and not 1 to n, we will just have to comment this line out
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(k);
        distances[k] = 0;

        while (!queue.isEmpty()){
            int currentNode = queue.poll();
            Map<Integer, Integer> map = graph.getOrDefault(currentNode, new HashMap<>());

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer nextNode = entry.getKey();
                Integer weight = entry.getValue();

                Integer newWeight = distances[currentNode] + weight;

                if(newWeight >= distances[nextNode]){
                    continue;
                }

                distances[nextNode] = newWeight;
                queue.add(nextNode);
            }
        }

        Integer minTimeToVisitAllNodes = Arrays.stream(distances).boxed().max(Comparator.comparingInt(a -> a)).get();
        return minTimeToVisitAllNodes != Integer.MAX_VALUE? minTimeToVisitAllNodes: -1;

    }
}
/*
Below code solution with better runtime by leetcode
class Solution {

       class Pair implements Comparable<Pair> {
        int vertex;
        int weight;

        Pair(int v,int w)
        {
            vertex = v;
            weight = w;
        }

        public int compareTo(Pair other)
        {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
         List<List<Pair>> ed = new ArrayList<>();
          int shortT[] = new int[n+1];
          Arrays.fill(shortT, Integer.MAX_VALUE);
          shortT[k] = 0;
        for(int i=0;i<=n;i++){
            ed.add(new ArrayList<>());
        }

         for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int t= time[2];
            ed.get(u).add(new Pair(v, t));
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>();
        pq.add(new Pair(k,0));
        int max=Integer.MIN_VALUE;

         while(!pq.isEmpty()){
            Pair p = pq.poll();
            int w = p.weight;
            int e = p.vertex;
            List<Pair> list = ed.get(e);

            for(Pair p1:list){
                int vertex = p1.vertex;
                int pr = w + p1.weight;
                if(shortT[vertex] > pr){
                    shortT[vertex] = pr;
                    pq.add(new Pair(vertex, pr));
                }
            }
        }


        for(int i=1;i<=n;i++){
            if(shortT[i] == Integer.MAX_VALUE){
                return -1;
            }
           if(max < shortT[i]){
               max = shortT[i];
           }
        }
        return max;

    }
}
 */
