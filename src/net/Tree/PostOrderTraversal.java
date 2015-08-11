package net.Tree;
import java.util.*;

public class PostOrderTraversal {
	/**
	 * recursive
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
    /**
     * iterative method
     */
    public List<Integer> postorderTraversalIter(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while( cur != null || !stack.isEmpty()){
            if (cur != null){
                ret.add(cur.val);
                if (cur.left != null) stack.push(cur.left);
                cur = cur.right;
            }else{
                cur = stack.pop();
            /*    Refactor
             */
                // ret.add(cur.val);
                // if (cur.left != null) stack.push(cur.left);
                // cur = cur.right;
            }
        }
        //After Fake-preoder Traversal, the order is Root,Right,Left
        Collections.reverse(ret);
        return ret;
    }
    /**
     * iterative with pre is the best
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()){
            cur = stack.pop();
            if ((cur.left == null && cur.right == null) || (cur.right != null && cur.right == pre)
                ||(cur.right == null && cur.left == pre) ){
                ret.add(cur.val);
                pre = cur;
            }else if (cur.left == null || cur.left == pre) {
                stack.push(cur);
                stack.push(cur.right);
            }else{
                stack.push(cur);
                stack.push(cur.left);
            }
        }
        return ret;
    }
}
