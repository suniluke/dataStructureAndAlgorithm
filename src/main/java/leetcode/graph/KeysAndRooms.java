package leetcode.graph;


import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KeysAndRooms {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{3,0,1},{2},{0}};
        List<List<Integer>> list = new ArrayList<>();
        for(int[] currArr : arr){
            list.add(Arrays.stream(currArr).boxed().collect(Collectors.toList()));
        }
        System.out.println(list);

        KeysAndRooms kr = new KeysAndRooms();
        boolean b = kr.canVisitAllRooms(list);
        System.out.println(b);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        return visitReursive(rooms, 0, 0, new ArrayList<>());
    }

    private boolean visitReursive(List<List<Integer>> rooms, Integer currentRoom, int visitCount, List<Integer> visited) {
        if(visitCount == rooms.size()){
            return true;
        }

        if(visited.contains(currentRoom) && visitCount != rooms.size()){
            return false;
        }
        visitCount++;
        visited.add(currentRoom);
        for(int nextRoom : rooms.get(currentRoom)){
            if(!visited.contains(nextRoom)){
                boolean isVisited = visitReursive(rooms, nextRoom, visitCount, visited);
            }
        }
        visited.remove(currentRoom);
        return false;
    }
}
