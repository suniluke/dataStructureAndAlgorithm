package twoPointers;

public class HaystackNeedle {
    public static void main(String[] args) {
        HaystackNeedle sol = new HaystackNeedle();

        // Test cases
        System.out.println(sol.strStr("sadbutsad", "sad"));
    }

    public int strStr(String haystack, String needle) {

        int hlength = haystack.length();
        int nlength = needle.length();

        for(int i=0; i<hlength; i++){
            int j=0;
            while(j<nlength && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(j == nlength)
                return i;
        }
        return -1;
    }

}
