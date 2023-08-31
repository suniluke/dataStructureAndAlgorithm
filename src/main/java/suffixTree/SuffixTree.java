package suffixTree;

import java.util.HashMap;
import java.util.Map;

public class SuffixTree {

    private Node rootNode;

    private SuffixTree(){
        this.rootNode = new Node();
    }

    class Node{
        Map<Character, Node> children;
        boolean isWord;

        public Node(){
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }



    public static void main(String[] args) {

        String str = "suniluke";

        SuffixTree suffixTree = new SuffixTree();

        suffixTree.insert(str);

        boolean isFound = suffixTree.findWord("iluke");

        System.out.println(isFound);
    }

    private void insert(String word) {
        Node itrNode;
        for(int firstIndex=0; firstIndex< word.length(); firstIndex++){
            itrNode = this.rootNode;
            for(int secondIndex = firstIndex; secondIndex< word.length(); secondIndex++){
                Character currentChar = word.charAt(secondIndex);
                    if(itrNode.children.get(currentChar) == null){
                        Node node = new Node();
                        itrNode.children.put(currentChar, node);
                        itrNode = node;
                    }
            }
            itrNode.isWord = true;
        }
    }

    private boolean findWord(String word) {
        Node itrNode = rootNode;

        for(Character currentChar: word.toCharArray()){
            if(itrNode.children.get(currentChar) == null){
                return false;
            }
            itrNode = itrNode.children.get(currentChar);
        }
        return itrNode.isWord;
    }
}
