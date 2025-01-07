package Arrays;

import java.util.HashMap;
import java.util.Map;

class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int result = 0;

        for(int i=0; i<s.length()-1; i++){
            int firstValue = romanMap.get(s.charAt(i));
            int secondValue = romanMap.get(s.charAt(i+1));
            if(firstValue >= secondValue){
                result = result + firstValue;
            } else {
                result = result - firstValue;
            }
        }
        return result + romanMap.get(s.charAt(s.length()-1));
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomanToInt r = new RomanToInt();
        int i = r.romanToInt(s);
        System.out.println(i);
    }
}