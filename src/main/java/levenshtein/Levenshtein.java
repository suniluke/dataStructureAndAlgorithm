package levenshtein;

import java.util.Arrays;

public class Levenshtein {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "yabd";

        int distance = getLevenshteinDistance(s1, s2);
        System.out.println("Distance for given string is " + distance);
    }

    private static int getLevenshteinDistance(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        int[][] array = new int[s1Length+1][s2Length+1];

        for(int i=0; i<=s1Length; i++){
            array[i][0] = i;
        }

        for(int i=0; i<=s2Length; i++){
            array[0][i] = i;
        }

        for (int row=1; row<=s2Length; row++){
            for(int col=1; col<=s1Length; col++){
                if(s2.charAt(row-1) == s1.charAt(col-1)){
                    //take diagonal value
                    array[col][row] = array[col-1][row-1];
                }else{
                    //find min of three prev values and add 1 to it
                    int min = Arrays.stream(new int[] {array[col-1][row], array[col][row-1], array[col-1][row-1]})
                            .min().getAsInt();
                    array[col][row] = min + 1;
                }
            }
        }

        //print the metrix
        for (int row=0; row<=s2Length; row++) {
            for (int col = 0; col <= s1Length; col++) {
                System.out.print(array[col][row]);
            }
            System.out.println();
        }
        return array[s1Length][s2Length];
    }
}
