package tree;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BST {
    TreeNode root;

    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null)
            return root;

        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{
            //found the node.
            //Scenario 1 -> No or one child
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            //Scenario 2 -> both child present
            TreeNode successorNode = root.right;
            while(successorNode.left != null)
                successorNode = successorNode.left;

            root.val = successorNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // Helper method to insert a node into the BST
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Helper method to print the tree in-order
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        // Insert nodes into the BST
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("Inorder traversal before deletion:");
        tree.inorder(tree.root);

        int key = 80;
        tree.root = tree.deleteNode(tree.root, key);

        System.out.println("\nInorder traversal after deletion:");
        tree.inorder(tree.root);
    }
}

