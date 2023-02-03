package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree{

    Node head;

    private class Node{
        Integer value;
        Node left;
        Node right;

        Node(Integer value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(30);
        tree.add(25);
        tree.add(35);
        tree.add(20);
        tree.add(28);
        tree.add(33);
        tree.add(38);

        //tree.invertBinaryTree();

        List<Integer> sums = tree.branchSums();
        System.out.println("Sum Of All Branches: " + sums);

        tree.inorderTraversal();

        Integer closestValue = tree.closestValueTo(33);
        System.out.println("Closest Value: " + closestValue);
    }

    private void add(int value) {
        //head = insertValueRecursive(head, value);
        insertValueIterative(head, value);
    }

    private Node insertValueRecursive(Node node, int value) {
        if(node == null){
            return new Node(value);
        }

        if(value >= node.value)
            node.right = insertValueRecursive(node.right, value);
        else
            node.left = insertValueRecursive(node.left, value);
        return node;
    }


    private void insertValueIterative(Node node, Integer value) {
        if(head == null){
            head = new Node(value);
            return;
        }

        while(true){
            if(value >= node.value){
                //go to right
                if(node.right == null){
                    node.right = new Node(value);
                    break;
                }else{
                    node = node.right;
                }
            }else{
                //go to left
                if(node.left == null){
                    node.left = new Node(value);
                    break;
                }else{
                    node = node.left;
                }
            }
        }

    }


    private void inorderTraversal() {
        inorderTraversalRecursive(head);
    }

    private void inorderTraversalRecursive(Node node) {
        if(node == null){
            return;
        }

        inorderTraversalRecursive(node.left);
        System.out.println(node.value);
        inorderTraversalRecursive(node.right);
    }


    private void invertBinaryTree() {
        invertBinaryTreeRecursive(head);
    }

    private void invertBinaryTreeRecursive(Node node) {
        if(node == null){
            return;
        }

        //invert
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertBinaryTreeRecursive(node.left);
        invertBinaryTreeRecursive(node.right);

    }


    private List<Integer> branchSums() {
        List<Integer> sums = new ArrayList<Integer>();
        branchSumsUtil(head, 0, sums);
        return sums;
    }

    private void branchSumsUtil(Node node, int currentSum, List<Integer> sums) {
        if(node == null){
            return;
        }
        currentSum = currentSum + node.value;
        if(node.left == null && node.right == null){
            sums.add(currentSum);
        }
        branchSumsUtil(node.left, currentSum, sums);
        branchSumsUtil(node.right, currentSum, sums);
    }


    private Integer closestValueTo(int target) {
        Integer currentClosest = Integer.MAX_VALUE;
        return closestValueToRecursive(head, target, currentClosest);
    }

    private Integer closestValueToRecursive(Node node, int target, Integer currentClosest) {

        if(node == null){
            return currentClosest;
        }

        Integer currentNodeAndTargetDifference = Math.abs(target - node.value);
        Integer currentClosestAndTargetDifference = Math.abs(currentClosest - target);

        if(currentNodeAndTargetDifference < currentClosestAndTargetDifference){
            currentClosest = node.value;
        }

        if(target < node.value){
            return closestValueToRecursive(node.left, target, currentClosest);
        } else if(target > node.value){
            return closestValueToRecursive(node.right, target, currentClosest);
        }else{
            return currentClosest;
        }
    }

}
