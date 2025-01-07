package leetcode.graph;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class EvaludateDivision {

    public static void main(String[] args) {
        String[][] equationsArray = new String[][]{{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
        //String[][] equationsArray = new String[][]{{"a","b"},{"b","c"},{"bc","cd"}};
        //String[][] equationsArray = new String[][]{{"a","b"}};

        //converting 2D array into List of List
        List<List<String>> equations = Arrays.stream(equationsArray).map(Arrays::asList).collect(Collectors.toList());
        double[] values = new double[]{3.0,4.0,5.0,6.0};
        //double[] values = new double[]{1.5,2.5,5.0};
        //double[] values = new double[]{0.5};

        String[][] queriesArray = new String[][]{{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};
        //String[][] queriesArray = new String[][]{{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}};
        //String[][] queriesArray = new String[][]{{"a","b"},{"b","a"},{"a","c"},{"x","y"}};

        List<List<String>> queries = Arrays.stream(queriesArray).map(Arrays::asList).collect(Collectors.toList());

        EvaludateDivision ed = new EvaludateDivision();
        double[] answers = ed.calcEquation(equations, values, queries);
        Arrays.stream(answers).boxed().forEach( e -> {
            System.out.println(e);
        });

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //create adjacency lookup graph
        Map<String, Map<String, Double>> lookupMap = getLookupMap(equations, values);

        int queriesSize = queries.size();

        double[] evaluatedDivision = new double[queriesSize];
        for(int index=0; index<queriesSize; index++){
            List<String> currentQuery = queries.get(index);

            boolean isValidQuery = checkIfQueryIsValid(lookupMap, currentQuery);

            if(isValidQuery){
                //perform operation of evaluating division
                double divisionAnswer = getDivisionByDFS(lookupMap, currentQuery.get(0), currentQuery.get(1), -1.0, new ArrayList<>(), 1.0);
                evaluatedDivision[index] = divisionAnswer;
            }else {
                evaluatedDivision[index] = -1.0;
            }
        }
        return evaluatedDivision;
    }

    private double getDivisionByDFS(Map<String, Map<String, Double>> lookupMap, String currentNode, String destNode,
                                    double answer, List<String> visitedNodes, double value) {

        if(visitedNodes.contains(currentNode)){
            return answer;
        }

        if(currentNode.equals(destNode)){
            answer = value;
            return answer;
        }

        visitedNodes.add(currentNode);

        for (Map.Entry<String, Double> entrySet : lookupMap.get(currentNode).entrySet()) {
            String nextNode = entrySet.getKey();
            Double currentValue = entrySet.getValue();

            answer = getDivisionByDFS(lookupMap, nextNode, destNode, answer, visitedNodes, value * currentValue);
        }
        return answer;
    }

    private boolean checkIfQueryIsValid(Map<String, Map<String, Double>> lookupMap, List<String> queries) {
        return lookupMap.containsKey(queries.get(0)) && lookupMap.containsKey(queries.get(1));
    }

    private Map<String, Map<String, Double>> getLookupMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> lookupMap = new HashMap<>();
        int equationSize = equations.size();

        for(int index=0; index<equationSize; index++){
            String numerator = equations.get(index).get(0);
            String denominator = equations.get(index).get(1);
            Double value = values[index];

            //add initial empty data
            lookupMap.putIfAbsent(numerator, new HashMap<>());
            lookupMap.putIfAbsent(denominator, new HashMap<>());

            //add actual values against the keys in map
            lookupMap.get(numerator).put(denominator, value);
            lookupMap.get(denominator).put(numerator, 1.0/value);
        }

        return lookupMap;
    }
}
