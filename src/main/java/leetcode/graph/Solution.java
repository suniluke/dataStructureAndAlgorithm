package leetcode.graph;


import java.util.*;
import java.util.stream.Collectors;
class Solution {
    class Node{
        private int source;
        private int weight;
        Node(int i, int t) {
            this.source = i;
            this.weight = t;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + source +
                    ", t=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {

        int[][] times = {{1,2,1}};
        int  n = 2, k = 2;
        Solution s= new Solution();
        int min = s.networkDelayTime(times, n, k);
        System.out.println("Min Time To Visit All Nodes: " + min);
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // create graph
        List<Node>[] graph = new List[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] t : times){
            graph[t[0]-1].add(new Node(t[1]-1, t[2]));
        }

        for(List<Node> list : graph){
            System.out.println(list);
        }
        int[] time = new int[n];
        Queue<Integer> q = new PriorityQueue<>((u, v) -> time[u]-time[v]);
        Arrays.fill(time, Integer.MAX_VALUE);
        time[--k] = 0;
        q.add(k);

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for (Node next : graph[cur]) {
                int t2 = time[cur] + next.weight;
                if (t2 >= time[next.source]) continue;
                time[next.source] = t2;
                q.add(next.source);
            }
        }

        System.out.println(Arrays.stream(time).boxed().collect(Collectors.toList()));
        int res = time[0];
        for (Integer t : time){
            if (t == Integer.MAX_VALUE){
                return -1;
            } else if (t > res){
                res = t;
            }
        }
        //[59, 18, 0, 53, 46]
        return res;
    }
}