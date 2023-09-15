package others;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] array = {4,3,5,6};
        int longestIncreasingSubsequence = getLongestIncreasingSubsequence(array);
        System.out.println(longestIncreasingSubsequence);
    }

    private static int getLongestIncreasingSubsequenceWithoutLISArray(int[] array) {

        //create LIS array
        int longestSubsequence = 1;

        for(int i=array.length-1; i>=0; i--){
            int longestSoFar = 1;
            for(int j=i; j<array.length; j++){
                if(j < array.length-1 && array[j] < array[j+1]){
                    longestSoFar++;
                    longestSubsequence = Math.max(longestSubsequence, longestSoFar);
                }
            }
        }
        return longestSubsequence;
    }

    //Time O(n^2)
    private static int getLongestIncreasingSubsequence(int[] array) {
        int[] LIS = new int[array.length];
        Arrays.fill(LIS, 1);
        for(int i=array.length-1; i>=0; i--){
            for(int j=i+1; j< array.length; j++){
                if(array[i] < array[j]){
                    LIS[i] = Math.max(LIS[i], 1+LIS[j]);
                }
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }
}
