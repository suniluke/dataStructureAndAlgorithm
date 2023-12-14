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

        Graph cci = new Graph(true, false);

        Vertex zero = cci.addVertex("zero");
        Vertex one = cci.addVertex("one");
        Vertex two = cci.addVertex("two");
        Vertex three = cci.addVertex("three");
        Vertex four = cci.addVertex("four");
        Vertex five = cci.addVertex("five");

        cci.addEdge(zero, one, null);
        cci.addEdge(zero, four, null);
        cci.addEdge(zero, five, null);

        cci.addEdge(one, three, null);
        cci.addEdge(one, four, null);

        cci.addEdge(two, one, null);

        cci.addEdge(three, two, null);
        cci.addEdge(three, four, null);

        System.out.println(" ---------- HOW GRAPH LOOKS LIKE ---------- ");
        cci.print();
        System.out.println(" ---------- DEPTH FIRST SEARCH ---------- ");
        dfsAlgorithm(cci);
        System.out.println(" ---------- BREADTH FIRST SEARCH ---------- ");
        bfsAlgorithm(cci);
    }

    private static void bfsAlgorithm(Graph cci) {
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex startingVertex = cci.vertices.get(0);
        queue.add(startingVertex);
        List<Vertex> visitedVertices = new ArrayList<>();
        System.out.println(startingVertex.getData());
        visitedVertices.add(startingVertex);

        while(!queue.isEmpty()){
            Vertex currentVertex = queue.remove();
            for (Edge edge : currentVertex.getEdges()) {
                Vertex childVertex = edge.getEnd();
                if(!visitedVertices.contains(childVertex)){
                    queue.add(childVertex);
                    System.out.println(childVertex.getData());
                    visitedVertices.add(childVertex);
                }

            }

        }
    }

    private static void dfsAlgorithm(Graph cci) {
        Vertex startingVertex = cci.vertices.get(0);
        dfsAlgorithmHelper(startingVertex, new ArrayList<Vertex>());
    }

    private static void dfsAlgorithmHelper(Vertex vertex, ArrayList<Vertex> visitedVertices) {
        if(vertex == null){ //base case
            return;
        }
        System.out.println(vertex.getData());
        visitedVertices.add(vertex);
        for (Edge edge : vertex.getEdges()) {
            Vertex currentVertex = edge.getEnd();
            if(!visitedVertices.contains(currentVertex)){
                dfsAlgorithmHelper(currentVertex, visitedVertices);
            }
        }

    }

    private void print() {
        for (Vertex vertex : this.vertices) {
            System.out.print(vertex.getData() + " --> ");
            ArrayList<Edge> edges = vertex.getEdges();
            for(Edge edge: edges){
                System.out.print(edge.getEnd().getData() + " --> ");
            }
            System.out.println();
        }

    }

}
