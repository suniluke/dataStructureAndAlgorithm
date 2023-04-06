package maxSubsetSumNoAdjucent;

public class MaxSubsetSumNoAdjucent {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 10, 12, 7, 9, 14};

        int maxSubsetSum = getMaxSubsetSumWithNoAdjucentValues(arr);
        System.out.println("maxSubsetSum: " + maxSubsetSum);
    }
    private static int getMaxSubsetSumWithNoAdjucentValues2(int[] arr) {
        if(arr == null)
            return 0;

        if(arr.length == 1)
            return  arr[0];


        int[] maxSumArr = new int[arr.length];

        maxSumArr[0] = arr[0];
        maxSumArr[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<arr.length; i++){
            maxSumArr[i] = Math.max(maxSumArr[i-1], maxSumArr[i-2]+arr[i]);
        }
        return maxSumArr[maxSumArr.length-1];
    }
    private static int getMaxSubsetSumWithNoAdjucentValues(int[] arr) {
        if(arr == null)
            return 0;

        if(arr.length == 1)
            return  arr[0];

        int firstMax = arr[0];
        int secondMax = Math.max(arr[0], arr[1]);

        int currentMax = 0;

        for(int i=2; i< arr.length; i++){
            currentMax = Math.max(secondMax, firstMax+arr[i]);
            firstMax = secondMax;
            secondMax = currentMax;
        }
        return secondMax;
    }
}
