package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //Bubble sort
        //swapping numbers with multiple iteration.

        int[] arr = new int[] {8, 5, 2,9, 5, 6, 3};

        performBubbleSort(arr);
        Arrays.stream(arr).forEach( elem -> {
            System.out.println(elem);
        });
    }

    //o(n^2) time as we iterate n number of times, for each element in array
    //o(1) space
    private static void performBubbleSort(int[] arr) {

        boolean isArraySorted = false;
        int sortedValuesCounter = 0; //slight optimization, so we don't go to sorted end of array
        while(!isArraySorted){// while array is not sorted
            isArraySorted = true;
            for(int i=0; i<arr.length - 1 - sortedValuesCounter; i++){
                if(arr[i] > arr[i+1]){
                    isArraySorted = false;
                    swapNumbers(arr, i);
                }

            }
            sortedValuesCounter++;
        }

    }

    private static void swapNumbers(int[] arr, int index) {
        int firstNum = arr[index];
        arr[index] = arr[index+1];
        arr[index + 1] = firstNum;

    }
}
