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

        System.out.println("Inverting Binary Tree");
        //tree.invertBinaryTree();
        System.out.println("-----------------------------------------------------------");


        List<Integer> sums = tree.branchSums();
        System.out.println("Sum Of All Branches: " + sums);
        System.out.println("-----------------------------------------------------------");

        Integer closestValue = tree.closestValueTo(33);
        System.out.println("Closest Value: " + closestValue);
        System.out.println("-----------------------------------------------------------");

        boolean isValidBST = tree.validateBst();
        System.out.println("isValidBST: " + isValidBST);
        System.out.println("-----------------------------------------------------------");

        System.out.println("Inorder Traveral:");
        tree.inorderTraversal();

        System.out.println("\nPreorder Traveral:");
        tree.preOrderTraversal();

        System.out.println("\nPostorder Traveral:");
        tree.postOrderTraversal();
        System.out.println("\n-----------------------------------------------------------");

        System.out.println("\nDepth First Search:");
        tree.depthFirstSearch();
        System.out.println("\n-----------------------------------------------------------");

    }

    private void depthFirstSearch() {
        List<Integer> dfsList = new ArrayList<>();
        depthFirstSearchHelper(dfsList, head);
        System.out.println(dfsList);
    }

    private void depthFirstSearchHelper(List<Integer> dfsList, Node node) {
        if(node == null) return;
        dfsList.add(node.value);

        depthFirstSearchHelper(dfsList, node.left);
        depthFirstSearchHelper(dfsList, node.right);
    }

    private boolean validateBst() {
        return validateBstHelper(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBstHelper(Node node, int minValue, int maxValue) {
        if(node == null){
            return true; //means whole tree is checked
        }

        if(node.value < minValue || node.value >= maxValue){
            return false;
        }

        return validateBstHelper(node.left,minValue, node.value) && validateBstHelper(node.right, node.value, maxValue);

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
        System.out.print(node.value + " ");
        inorderTraversalRecursive(node.right);
    }

    private void preOrderTraversal() {
        preOrderTraversalRecursive(head);
    }

    private void preOrderTraversalRecursive(Node node) {
        if(node == null) return;
        System.out.print(node.value + " ");
        preOrderTraversalRecursive(node.left);
        preOrderTraversalRecursive(node.right);
    }

    private void postOrderTraversal() {
        postOrderTraversalRecursive(head);
    }

    private void postOrderTraversalRecursive(Node node) {
        if(node == null) return;
        postOrderTraversalRecursive(node.left);
        postOrderTraversalRecursive(node.right);
        System.out.print(node.value + " ");

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

    public Node deleteNodeIterative(Node root, int key) {
        //find the node to be deleted
        Node parentNode = null;
        Node currentNode = root;

        while(currentNode != null && currentNode.value != key){
            parentNode = currentNode;
            if(key < currentNode.value){
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        //if currentNode has one or no children
        if(currentNode.left == null || currentNode.right == null){
            Node replacementNode = null;
            if(currentNode.right != null)
                replacementNode = currentNode.right;
            else if(currentNode.left != null)
                replacementNode = currentNode.left;

            //if node to be deleted is parent node
            if(parentNode == null)
                return replacementNode;

            if(parentNode.left == currentNode)
                parentNode.left = replacementNode;
            else
                parentNode.right = replacementNode;
        } else {
            //both nodes are present for node to be deleted
            Node successorParent = currentNode;
            Node successor = currentNode.left;
            while(successor.left != null){
                successorParent = successor;
                successor = successor.left;
            }

            //update current node value
            currentNode.value = successor.value;

            //delete the successor node
            if(successorParent.left == successor)
                successorParent.left = successor.right;
            else
                successorParent.right = successor.right;
        }
        return root;
    }

}
