package net.Tree;

import java.util.*;

public class LevelOrderTraversal {
	/**
	 * BFS
	 * use size to record each line
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> line = new ArrayList<>();
            TreeNode cur = null;
            for (int i=0;i<size;i++){
                cur = queue.poll();
                if (cur.left!=null) queue.offer(cur.left);
                if (cur.right!=null) queue.offer(cur.right);
                line.add(cur.val);
            }
            ret.add(line);
        }
        return ret;
    }
	/**
	 * BFS
	 *use 2 Queue to level order
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        Queue<TreeNode> parent = new LinkedList<>();
        Queue<TreeNode> child = new LinkedList<>();
        parent.offer(root);
        List<Integer> line = new ArrayList<>();
        while (!parent.isEmpty()){
            TreeNode cur = parent.poll();
            if (cur.left!=null) child.offer(cur.left);
            if (cur.right!=null) child.offer(cur.right);
            line.add(cur.val);
            if (parent.isEmpty()){
                ret.add(new ArrayList<Integer>(line));
                line.clear();
                Queue<TreeNode> tmp = child;
                child = parent;
                parent = tmp;
            }
        }
        return ret;
    }
}
