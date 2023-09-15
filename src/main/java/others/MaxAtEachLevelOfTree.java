package others;

import tree.BinaryTree;

import java.util.List;

public class MaxAtEachLevelOfTree {

    Node head;
    private class Node{
        Integer value;
        Node left;
        Node right;

        Node(Integer value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MaxAtEachLevelOfTree obj = new MaxAtEachLevelOfTree();

        obj.addData();

        List<Integer> list = obj.getMaxAtEachLevel();
        
    }

    private List<Integer> getMaxAtEachLevel() {
        return getMaxAtEachLevelHelper(head);

    }

    private static List<Integer> getMaxAtEachLevelHelper(Node head) {
        return null;
    }

    private void addData() {

        head = new Node(1);
        head.left = new Node(3);
        head.right = new Node(2);
        head.left.left = new Node(5);
        head.left.right = new Node(3);
        head.right.right = new Node(9);

    }
}
