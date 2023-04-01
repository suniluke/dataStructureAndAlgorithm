package smallestDifference;

import java.util.Arrays;

public class SmallestDifference {
    /*
    Given two array, you need to find the pair or number from both array whose difference is smallest
    example:
    {-1, 5, 10, 20, 28, 3}, {26, 134, 135, 15, 17}
    Answer: 28 from array 1 and 26 from array 2 has the smallest difference
    return {28, 26}
     */
    public static void main(String[] args) {

        int[] leftArray = new int[] {-1, 5, 10, 20, 28, 3};
        int[] rightArray = new int[] {26, 134, 135, 15, 17};

        int[] smallestDifferencePair = getSmallestDifferencePair(leftArray, rightArray);

        Arrays.stream(smallestDifferencePair).forEach( a -> {
            System.out.println(a);
        });
    }

    private static int[] getSmallestDifferencePair(int[] arr1, int[] arr2) {
        int[] leftArr = Arrays.stream(arr1).sorted().toArray();
        int[] rightArr = Arrays.stream(arr2).sorted().toArray();

        int[] outputArray = new int[2];

        int smallestDifference = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightindex = 0;

        while(leftIndex < leftArr.length && rightindex < rightArr.length){
            int currentDifference = Math.abs(leftArr[leftIndex] - rightArr[rightindex]);
            if(currentDifference < smallestDifference){
                smallestDifference = currentDifference;
                outputArray[0] = leftArr[leftIndex];
                outputArray[1] = rightArr[rightindex];
            }
            if(leftArr[leftIndex] < rightArr[rightindex]){
                leftIndex++;
            }else {
                rightindex++;
            }
        }
        return outputArray;
    }

}
