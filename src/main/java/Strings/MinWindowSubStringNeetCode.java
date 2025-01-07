package Strings;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubStringNeetCode {

    public String minWindow(String s, String t){
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();

        //populate mapT
        for(Character c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int resultLength = Integer.MAX_VALUE;
        int haveCount = 0;
        int needCount = mapT.size(); // this has to be mapT.size(); and not t.length();
        int[] indexes = {-1, -1};

        for(int right=0; right < s.length(); right++){
            Character currentChar = s.charAt(right);

            mapS.put(currentChar, mapS.getOrDefault(currentChar, 0) + 1);

            if(mapT.containsKey(currentChar) && mapS.get(currentChar) == mapT.get(currentChar)){
                haveCount++;
            }

            while (haveCount == needCount){
                //we have valid window. check if its smaller than before and update result
                if((right - left + 1) < resultLength){
                    resultLength = right - left + 1;
                    indexes[0] = left;
                    indexes[1] = right;
                }

                //reduce window from left
                Character leftChar = s.charAt(left);

                mapS.put(leftChar, mapS.get(leftChar) - 1);
                if(mapT.containsKey(leftChar) && mapS.get(leftChar) < mapT.get(leftChar)){
                    haveCount--;
                }
                left++;
            }
        }
        return resultLength != Integer.MAX_VALUE? s.substring(indexes[0], indexes[1] + 1) : "";
    }

    public static void main(String[] args) {
        MinWindowSubStringNeetCode sol = new MinWindowSubStringNeetCode();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + sol.minWindow(s, t));
    }
}
