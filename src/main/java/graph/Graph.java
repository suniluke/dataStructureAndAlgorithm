package graph;

import java.util.*;

public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isDirectional, isWeighted;

    public Graph(Boolean isDirectional, boolean isWeighted){
        this.isDirectional = isDirectional;
        this.isWeighted = isWeighted;
        this.vertices = new ArrayList<>();
    }

    //METHODS

    /**
     * addVertex method just add V to instance variable vertices list
     */
    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public boolean removeVertex(Vertex vertex){
        return this.vertices.remove(vertex);
    }

    /**
     * addEdge, Think here in terms of end user
     * @param vertex1
     * @param vertex2
     * @param weight
     */
    public void addEdge(Vertex vertex1,Vertex vertex2, Integer weight){
        if(!this.isWeighted){
            weight = null;
        }

        vertex1.addEdge(vertex2, weight);

        if(!this.isDirectional){
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2){
        vertex1.removeEdge(vertex2);

        if(!this.isDirectional){
            vertex2.removeEdge(vertex1);
        }
    }



    public static void main(String[] args) {

    }

}
