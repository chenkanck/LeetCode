package net.kc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class WorkWithTree {
	
	 public void play () {
		 TreeNode right = new TreeNode(2);
		 TreeNode left = new TreeNode(2);
		 TreeNode root = new TreeNode(1);
		 root.left = left;
		 root.right = right;
		 System.out.println(isSymmetric(root));
	 }
	 public boolean isSymmetric(TreeNode root) {
	        if(root == null)
	            return true;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        
	        while (!queue.isEmpty()) {
	            ArrayList<String> line = new ArrayList<String>();
	            int size = queue.size();
	            for (int i=0 ; i< size;i++) {
	                TreeNode tmp = queue.poll();
	                if (tmp.left != null){
	                    line.add(String.valueOf(tmp.left.val));
	                    queue.offer(tmp.left);
	                }
	                else {
	                    line.add("#");
	                }
	                if (tmp.right != null) {
	                    line.add(String.valueOf(tmp.right.val));
	                    queue.offer(tmp.right);
	                }
	                else {
	                    line.add("#");
	                }
	            }
	            //check line
	            for (int i = 0; i< line.size()/2 ;i++)
	                if (!line.get(i).equals(line.get(line.size()-1-i)))
	                    return false;
	        }
	        
	        return true;
	    }	 
		
    public int minDepth(TreeNode root) {
        if (root == null)
        	return 0;
        else
        	return getMin(root);	
    }
	
    int getMin (TreeNode node)
    {
    	
    	if (node.left ==null && node.right ==null)
    		return 1;
    	else
    		return 1+Math.min(getMin(node.left),getMin(node.right));
    }
	
    int getMax (TreeNode node)
    {
    	if (node ==null)
    		return Integer.MIN_VALUE;
    	if (node.left ==null && node.right ==null)
    		return 1;
    	else
    		return 1+Math.max(getMax(node.left), getMax(node.right));
    }
	
	/*
	 * Binary Tree Preorder Traversal 
	 */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (root == null)
            return list;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            
        }
        return list;
    } 
	/*
	 * Binary Tree Inorder Traversal 
	 * Using Iteration rather than Recursive 
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode crtNode = root;
        while (!stack.empty() || crtNode!=null){
            if (crtNode!=null){
                stack.push(crtNode);
                crtNode = crtNode.left;
            }else{
                TreeNode pNode = stack.pop();
                result.add(pNode.val);
                crtNode = pNode.right;
            }
        }
        
        return result;
    }
	
    
    
    /*
     * Problem: Binary Tree Level Order Traversal 
     * Using: BFS, Queue
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result =new  ArrayList<List<Integer>>();
    	if (root == null)
    	{
    		return result;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	while(!queue.isEmpty()) {
    		ArrayList<Integer> line = new ArrayList<Integer>();
    		int size = queue.size();
    		for (int i = 0 ; i <size ;i++)
    		{
    			TreeNode head = queue.poll();
    			line.add(head.val);
    			if (head.left != null)
    				queue.offer(head.left);
    			if (head.right != null)
    				queue.offer(head.right);
    		}
    		result.add(line);
    	}
    	
    	return result;
    }
    /*
     * Validate Binary Search Tree
     * In order Travel of tree
     */
    private int lastVal = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
         if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastVal >= root.val) {
            return false;
        }
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
    /*
     * Populating Next Right Pointers in Each Node
     * Using BFS Queue
     */
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0 ;  i< size ;i++) {
                TreeLinkNode node = queue.poll();
                if (i==size-1) //last node in this leave
                    node.next = null;
                else
                    node.next= queue.peek();
                if (node.left != null)
    				queue.offer(node.left);
    			if (node.right != null)
    				queue.offer(node.right);
            }//end for
        }
    }
    /*
     * Problem: Binary Tree Level Order Traversal 
     * End
     */
    
    /*
	 * Definition for Binary Tree
	 */
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	 }
	/*
	 * Definition for binary tree with next pointer.
	 */
	  public class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }
	 
}
