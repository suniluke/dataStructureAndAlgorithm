
package tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    Node root;
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Tree bst = new Tree();

        bst.add(20);
        bst.add(15);
        bst.add(25);
        bst.add(10);
        bst.add(18);
        bst.add(23);
        bst.add(28);

        bst.inorderTraversal();

        int closestValue = bst.findClosestValueTo(17);
        System.out.println("findClosestValueToIterative: " + closestValue);

        List<Integer> branchSum = bst.branchSum();
        System.out.println("branchSum: " + branchSum);
    }

    private List<Integer> branchSum() {

        return branchSumRecursive(root, new ArrayList<>(), 0);
    }

    /*
    * O(N) time | O(N) space
    * */
    private List<Integer> branchSumRecursive(Node node, ArrayList<Integer> branchSumList, int runningSum) {
        if(node == null){
            return branchSumList;
        }

        runningSum = runningSum + node.val;

        if(node.left == null && node.right == null){
            branchSumList.add(runningSum);
        }
        branchSumRecursive(node.left, branchSumList, runningSum);
        branchSumRecursive(node.right, branchSumList, runningSum);

        return branchSumList;
    }

    private int findClosestValueTo(int key) {
        //return findClosestValueToRecursive(key, Integer.MAX_VALUE, root);

        return findClosestValueToIterative(key, Integer.MAX_VALUE, root);
    }

    /*
    * average O(log(N)) time | O(log(N)) space
    * worst O(N) time | O(N) space
    * */
    private int findClosestValueToIterative(int key, int closesetValue, Node root) {
        Node currentNode = root;

        while(currentNode != null){
            int currentNodeDiff = Math.abs(key - currentNode.val);
            int currentClosestDiff = Math.abs(key - closesetValue);

            if(currentClosestDiff == 0){
                return currentNode.val;
            }else if(currentNodeDiff < currentClosestDiff){
                closesetValue = currentNode.val;
            }

            if(key <= currentNode.val){
                currentNode = currentNode.left;
            }else {
                currentNode = currentNode.right;
            }
        }

        return closesetValue;
    }

    /*
     * average O(log(N)) time | O(1) space
     * worst O(N) time | O(1) space
     * */
    private int findClosestValueToRecursive(int key, int closesetValue, Node node) {

        //base termination case
        if(node == null){
            return closesetValue;
        }

        int newDiff = Math.abs(key - node.val);
        int currentClosestDiff = Math.abs(key - closesetValue);

        if(newDiff == 0) {
            return node.val;
        } else if (newDiff < currentClosestDiff) {
            closesetValue = node.val;
        }

        if(key <= node.val){
            return findClosestValueToRecursive(key, closesetValue, node.left);
        }else{
            return findClosestValueToRecursive(key, closesetValue, node.right);
        }
    }

    private void inorderTraversal() {

        if(root == null) {
            return;
        }
        inorderTraversalUtil(root);
    }

    private void inorderTraversalUtil(Node node) {
        if(node == null){
            return;
        }
        System.out.println(node.val);
        inorderTraversalUtil(node.left);
        inorderTraversalUtil(node.right);
    }

    private void add(int val) {
        root = addNodeUtil(val, root);
    }

    private Node addNodeUtil(int val, Node node) {
        if(node == null){
            return new Node(val);
        }else if(val <= node.val){
            node.left = addNodeUtil(val, node.left);
        }else{
            node.right = addNodeUtil(val, node.right);
        }
        return node;

    }
}
