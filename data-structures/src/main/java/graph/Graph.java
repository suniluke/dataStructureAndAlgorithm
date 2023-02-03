package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    Map<Integer,Node> lookUpMap = new HashMap<>();

    public static class Node{
        int id;
        List<Node> adjucents = new LinkedList<>();

        public Node(int id){
            this.id = id;
        }
    }

    private  Node getNode(int id){
        return lookUpMap.get(id);
    }


}
