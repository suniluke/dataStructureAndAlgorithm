package search.in.sorted.metrix;

public class SortedMetrixSearch {

    public static void main(String[] args) {
        int[][] sortedMetrix = new int[][] {
                {1,4,7,12,15,1000},
                {2,5,19,31,32,1001},
                {3,8,24,33,35,1002},
                {40,4,42,44,45,1003},
                {99,100,103,106, 128,1004}
                };

        System.out.println(sortedMetrix.length);
        System.out.println(sortedMetrix[0].length);

        //how to iterate 2D array
        for (int row =0; row < sortedMetrix.length; row++){
            for (int col=0; col < sortedMetrix[row].length; col++){
                System.out.print(sortedMetrix[row][col] + " ");
            }
            System.out.println();
        }
        int target = 44;

        int[] index = searchTargetInSortedMetrix(sortedMetrix, target);

        System.out.println("Target " + target+ " is found at index " + index);
    }

    private static int[] searchTargetInSortedMetrix(int[][] sortedMetrix, int target) {

        int row = 0;
        int col = sortedMetrix[0].length-1;

        //while you're at right indexes
        while(row < sortedMetrix.length && col >=0){
            if(sortedMetrix[row][col] > target){
                col--;
            } else if(sortedMetrix[row][col] < target){
                row++;
            } else{
                return new int[]{row, col};
            }
        }
        //if target is not found
        return new int[] {-1,-1};
    }
}
