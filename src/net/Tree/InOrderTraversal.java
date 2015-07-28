package net.Tree;
import java.util.*;

public class InOrderTraversal {
	/**
	 * recursive
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }
    public void helper(TreeNode root, List<Integer> ret){
        if (root == null) return;
        helper(root.left, ret);
        ret.add(root.val);
        helper(root.right, ret);
    }
    /**
     * iteration
     */
    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur == null){
                cur = stack.pop();
                ret.add(cur.val);
                    
                cur = cur.right;
                
            }else{
                stack.push(cur);
                cur = cur.left;
            }
        }
        return ret;
    }
}
