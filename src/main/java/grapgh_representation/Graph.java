package grapgh_representation;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Integer>> adjecancyList;

    public Graph(int verticesCount){
        this.adjecancyList = new ArrayList<>();
        for(int i=0; i<verticesCount; i++){
            this.adjecancyList.add(new ArrayList<>());
        }
    }

    public void addNodeToGraph(int source, int dest){
        adjecancyList.get(source).add(dest);
        adjecancyList.get(dest).add(source);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        System.out.println(list.size());
    }
}
