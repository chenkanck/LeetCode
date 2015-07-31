package net.Tree;

public class ValidateBST {
	//similar with build BST from linkedlist
	private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return isValidInorder(root);
    }
    public boolean isValidInorder(TreeNode root){
        if (root == null) return true;
        if (isValidInorder(root.left)&&(prev == null || prev.val<root.val)){
            prev = root;
            return isValidInorder(root.right);
        }
        return false;
    }
    
    
    public boolean isValidBST2(TreeNode root) {
        return isValidInorder(root,(long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1);
    }
    public boolean isValidInorder(TreeNode root, long min, long max){
        if (root == null) return true;
        if (root.val> min && root.val<max)
            return (isValidInorder(root.left,min,root.val) && isValidInorder(root.right,root.val, max));
        return false;
    }
}
