package minReward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinReward {

    public static void main(String[] args) {
        int[] array = {8,4,2,1,3,6,7,9,5};

        int[] rewards = getMinRewards(array);

        List<Integer> collect = Arrays.stream(rewards).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }

    private static int[] getMinRewards(int[] array) {
        int[] rewards = new int[array.length];
        Arrays.fill(rewards, 1);
        for(int i=1; i< array.length; i++){
            if(array[i] > array[i-1]){
                rewards[i] = rewards[i-1] + 1;
            }
        }

        for(int i=array.length-2; i >=0; i--){
            if(array[i] > array[i+1]){
                rewards[i] = Math.max(rewards[i], rewards[i+1] + 1);
            }
        }
        return rewards;
    }
}
