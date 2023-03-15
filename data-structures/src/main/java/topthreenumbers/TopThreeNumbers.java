package topthreenumbers;

import java.util.Arrays;

public class TopThreeNumbers {
    public static void main(String[] args) {

        //find top three numbers
        int[] arr = new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};

        // o(n) time | o(1) space
        int[] outputArr = findTopThreeNumbers(arr);
        Arrays.stream(outputArr).forEach(elem -> {
            System.out.println(elem);
        });
    }

    private static int[] findTopThreeNumbers(int[] arr) {
        int[] outputArray = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int index = 0; index < arr.length; index++){
            int currentnumber = arr[index];
            if(currentnumber > outputArray[2])
                performShiftingValuesInOutputArray(outputArray, currentnumber, 2);
            else if(currentnumber > outputArray[1])
                performShiftingValuesInOutputArray(outputArray, currentnumber, 1);
            else if(currentnumber > outputArray[0])
                performShiftingValuesInOutputArray(outputArray, currentnumber, 0);
        }
        return outputArray;
    }

    private static void performShiftingValuesInOutputArray(int[] outputArray, int currentNumber, int maxIndex) {
        int currentIndex = 0;
        while(currentIndex < maxIndex){
            outputArray[currentIndex] = outputArray[currentIndex+1];
            currentIndex++;
        }
        outputArray[maxIndex] = currentNumber;
    }
}
