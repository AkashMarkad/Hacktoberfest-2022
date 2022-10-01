// Search in BST
// we know that the bst have the smaller elements on the left and greater elements on the right 
// so if the key is grater than the root then we go on right else go on left if found return node

// code:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        while(root != null && root.val != val){
            root = (val < root.val) ? root.left : root.right;
        }
        
        return root;
    }
}

// Coding Studio Solution :

public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		// Write your code here.
        
        if(root == null)    return false;
        
        while(root != null){
            if(root.data == x)    return true;
            root = x<root.data ? root.left : root.right;
        }
        return false;
	}
}
