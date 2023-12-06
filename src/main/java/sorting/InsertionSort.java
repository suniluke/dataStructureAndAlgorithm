package sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {8,5,2,9,5,6,3};
        performInsertionSort(array);
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    private static void performInsertionSort(int[] array) {
        for(int i=1; i<array.length; i++){
            if(array[i] < array[i-1]){
                shiftElements(array, i);
            }
        }
    }

    private static void shiftElements(int[] array, int index) {
        while(index > 0 && array[index] < array[index-1]){
            //swap
            int tempHolder = array[index];
            array[index] = array[index-1];
            array[index-1] = tempHolder;
            index--;
        }
    }
}
