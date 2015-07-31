package net.Tree;
import java.util.*;

public class PostOrderTraversal {
	/**
	 * 
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        helper(root,ret);
        return ret;
    }
    public void helper(TreeNode root, List<Integer> ret){
        if (root == null) return;
        helper(root.left,ret);
        helper(root.right, ret);
        ret.add(root.val);
    }
}
