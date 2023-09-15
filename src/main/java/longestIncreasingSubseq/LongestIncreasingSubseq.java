package longestIncreasingSubseq;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LongestIncreasingSubseq {

    public static void main(String[] args) {
        //NOT COMPLETED
        int[] array = {5,7,-24,12,10,2,3,12,5,6,35};

        int[] longestSubseq = getLongestIncreasingSubsequence(array);

    }

    private static int[] getLongestIncreasingSubsequence(int[] array) {
        int[] lengthArray = new int[array.length];
        int[] indexArray  = new int[array.length];

        Arrays.fill(lengthArray, 1);
        Arrays.fill(indexArray, -1);

        for(int i=0; i< array.length; i++){
            for(int j=0; j<i; j++){
                if(array[j] < array[i] && (lengthArray[j] +1 > lengthArray[i])){
                    lengthArray[i] = lengthArray[j] + 1;
                    indexArray[i] = j;
                }
            }
        }
        System.out.println(Arrays.stream(lengthArray).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(indexArray).boxed().collect(Collectors.toList()));
        return new int[]{};
    }
}
