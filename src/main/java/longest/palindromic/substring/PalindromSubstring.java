package longest.palindromic.substring;

public class PalindromSubstring {

    public static void main(String[] args) {
        String str = "aabbaacc";

        String longestPalindromcSubstring = getLongestPalindromcSubstring(str);

        System.out.println(longestPalindromcSubstring);
    }

    private static String getLongestPalindromcSubstring(String str) {

        int[] indexArr = new int[]{0,0};

        for (int i=0; i< str.length()-1; i++){
            updatePalindromSubstringIndexes(str, indexArr, i, i);
            updatePalindromSubstringIndexes(str, indexArr, i, i+1);
        }

        return str.substring(indexArr[0], indexArr[1] + 1);
    }

    private static void updatePalindromSubstringIndexes(String str, int[] indexArr, int start, int end) {
        while(start >=0 && end < str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }
        start++;
        end--;
        if (indexArr[1] - indexArr[0] < end - start){
            indexArr[0] = start;
            indexArr[1] = end;
        }
    }
}
