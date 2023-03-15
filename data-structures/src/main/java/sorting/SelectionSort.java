package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = new int[] {8, 5, 2,9, 5, 6, 3};

        performSelectionSort(arr);
        Arrays.stream(arr).forEach(elem -> {
            System.out.println(elem);
        });
    }

    private static void performSelectionSort(int[] arr) {
        int sortedIndex = 0;

        while(sortedIndex < arr.length-1){
            int currentSmallestIndex = sortedIndex;
            for(int i = currentSmallestIndex; i < arr.length; i++){
                if(arr[i] < arr[currentSmallestIndex]){
                    currentSmallestIndex = i;
                }
            }

            //swap
            swapNumbers(sortedIndex, currentSmallestIndex, arr);
            sortedIndex++;
        }
    }

    private static void swapNumbers(int i, int j, int[] arr) {
        int firstNum = arr[i];
        arr[i] = arr[j];
        arr[j] = firstNum;
    }
}
