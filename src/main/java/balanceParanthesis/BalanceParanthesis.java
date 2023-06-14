package balanceParanthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceParanthesis {

    public static void main(String[] args) {
        String input = "(([]()()){})";

        System.out.println(isBalancedBackets(input));

    }

    private static boolean isBalancedBackets(String input) {
        String openingBrackets = "{[(";
        String closingBrackets = "}])";

        Stack<Character> bracketHolder = new Stack<>();
        Map<Character, Character> openingClosingBracketMap = new HashMap<>();
        openingClosingBracketMap.put('}', '{');
        openingClosingBracketMap.put(']', '[');
        openingClosingBracketMap.put(')', '(');

        for(Character currentBracket : input.toCharArray()){
            if(openingBrackets.contains(currentBracket.toString())){
                bracketHolder.push(currentBracket);
            } else if(closingBrackets.contains(currentBracket.toString())){
                if(bracketHolder.isEmpty())
                    return false;
                Character topFromBracketHolder = bracketHolder.pop();
                Character closingBrancketFromMap = openingClosingBracketMap.get(currentBracket);

                if(topFromBracketHolder != closingBrancketFromMap)
                    return false;
            }
        }
        return bracketHolder.isEmpty();
    }
}
