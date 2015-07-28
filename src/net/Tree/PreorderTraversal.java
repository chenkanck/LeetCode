package net.Tree;

import java.util.*;

public class PreorderTraversal {
	/**
	 * Recursive
	 */
	private List<Integer> ret = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return ret;
    }
    public void helper(TreeNode root){
        if (root==null) return;
        ret.add(root.val);
        helper(root.left);
        helper(root.right);
    }
    /**
     * iteration
     */
    public List<Integer> preorderTraversalIter(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if (cur == null) cur = stack.pop();
            ret.add(cur.val);
            if (cur.right!=null) stack.add(cur.right);
            cur = cur.left;
        }
        return ret;
     }
    
    
}
