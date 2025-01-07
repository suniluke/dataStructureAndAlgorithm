package Arrays;

import java.util.*;

class ArraySubsequence {
    public static boolean isValidSubsequence(
            List<Integer> array, List<Integer> sequence
    ) {
        int indexTracker = 0;

        for(Integer currentNumber: array){
            if(indexTracker < sequence.size() && currentNumber == sequence.get(indexTracker))
                indexTracker++;
        }

        System.out.println(indexTracker);
        if(indexTracker == sequence.size())
            return true;
        return false;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> seq = Arrays.asList(5, 1, 22, 6, -1, 8, 10);
        System.out.println(ArraySubsequence.isValidSubsequence(array, seq));
    }
}
