package moveElementToEnd;

import java.util.Arrays;

public class MoveElementToEnd {
    
    /*
    given an array and a key, shift all the occurances of key in array to the end
     */

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 2, 2, 2, 3, 4, 2};
        int key = 2;
        
        moveElementToEnd(arr, key);

        Arrays.stream(arr).forEach(element -> {
            System.out.println(element);
        });
    }

    private static void moveElementToEnd(int[] arr, int key) {
        int leftIndex = 0;
        int rightIndex = arr.length-1;

        while(leftIndex < rightIndex){
            if(arr[leftIndex] == key && arr[rightIndex] != key){
                int tempNum = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = tempNum;
                leftIndex++;
                rightIndex--;
            }else if(arr[leftIndex] != key){
                leftIndex++;
            }else if(arr[rightIndex] == key){
                rightIndex--;
            }
        }
    }

}
