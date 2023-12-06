package search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,3,4,6,12,23,34,55,57,59,66};

        int numberToFind = 57;

        int index = findInSortedArray(array, numberToFind);

        System.out.println(index);
    }

    private static int findInSortedArray(int[] array, int target) {
        int left = 0;
        int right = array.length-1;

        while(left <= right){
            int middle =left+(right-left)/2;
            
            if(array[middle] == target) return middle;

            if(target > array[middle]) left = middle + 1;

            if(target < array[middle]) right = middle - 1;
        }
        return -1;
    }
}
