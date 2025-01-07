package graph.unionfind;

import java.util.Arrays;

public class UnionFind {

    private int[] parent;
    private int[] rank;
    private int[] size;

    UnionFind(int length){
        parent = new int[length+1];
        rank = new int[length+1];

        for(int i=0; i<=length; i++){
            parent[i] = i;
        }

        for(int i=0; i<=length; i++){
            size[i] = 1;
        }
    }
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(7);

        uf.union(0,1);
        uf.union(2,7);
        uf.union(3,6);
        boolean af1 = uf.areFriend(0,2);
        System.out.println(af1);
        uf.union(0,7);
        uf.union(2,3);
        af1 = uf.areFriend(2,3);
        System.out.println(af1);
    }

    private boolean areFriend(int elementA, int elementB) {
        Arrays.stream(rank).forEach(e -> {
            System.out.println(e);
        });
        return find(elementA) == find(elementB);
    }

    private void union(int elementA, int elementB) {
        //find by rank
        int parentOfA = find(elementA);
        int parentOfB = find(elementB);

        if(parentOfA == parentOfB){
            return;
        }

        if (rank[parentOfA] < rank[parentOfB]){
            parent[parentOfA] = parentOfB;
        } else if (rank[parentOfB] < rank[parentOfA]) {
            parent[parentOfB] = parentOfA;
        }else {
            parent[parentOfB] = parentOfA;
            rank[parentOfA] = rank[parentOfB] + 1;
        }
    }

    private void unionBySize(int elementA, int elementB) {
        int parentOfA = find(elementA);
        int parentOfB = find(elementB);

        if(parentOfA == parentOfB){
            return;
        }

        if (rank[parentOfA] < rank[parentOfB]){
            parent[parentOfA] = parentOfB;
        } else if (rank[parentOfB] < rank[parentOfA]) {
            parent[parentOfB] = parentOfA;
        }else {
            parent[parentOfB] = parentOfA;
            rank[parentOfA] = rank[parentOfB] + 1;
        }
    }
    private int find(int element) {

        if(parent[element] == element){
            return element;
        }

        parent[element] = find(parent[element]);
        return parent[element];
    }
}
