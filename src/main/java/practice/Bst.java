package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bst {
    
    private Node root; 
    public class Node{
        Integer data;
        Node left;
        Node right;

        Node(Integer data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Bst bst = new Bst();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(2);
        bst.add(5);
        bst.add(13);
        bst.add(22);
        bst.add(1);
        bst.add(14);

        List<Integer> branchSums = bst.branchSum();
        System.out.println("branch sum : " + branchSums);
    }

    private List<Integer> branchSum() {
        List<Integer> branchSums = new ArrayList<>();
        Integer currentSum = 0;
        return branchSumsHelper(branchSums, currentSum, root);
    }

    private List<Integer> branchSumsHelper(List<Integer> branchSums, Integer currentSum, Node node) {
        if(node == null) return branchSums;

        currentSum += node.data;
        if(node.left == null && node.right == null) {
            branchSums.add(currentSum);
        }
        branchSumsHelper(branchSums, currentSum, node.left);
        branchSumsHelper(branchSums, currentSum, node.right);
        return branchSums;
    }

    public void add(int data) {
        root = addHelper(data, root);
    }

    private Node addHelper(Integer data, Node node) {
        if(node == null){
            return new Node(data);
        }

        if(data <= node.data){
            node.left = addHelper(data, node.left);
        }else {
            node.right = addHelper(data, node.right);
        }
        return node;
    }
}
