package net.Tree;

import java.util.*;

class TreeLinkNode extends TreeNode{
	TreeLinkNode next, left, right;
	TreeLinkNode(int x){
		super(x);
	}
}

public class PopulatingNextRightPoints {
	/*
	 * BFS using Queue
	 */
	public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.add(root);
        TreeLinkNode cur = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (i < size-1)
                    cur.next = queue.peek();
            }
        }
    }
	
	public void connect2(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode parentStart = root;
        TreeLinkNode childStart = null;
        while (parentStart != null){
            TreeLinkNode parentCurrent = parentStart;
            TreeLinkNode childPre = null;
            while (parentCurrent != null){
                if (parentCurrent.left != null){
                    if (childStart == null) childStart = parentCurrent.left;
                    if (childPre != null) childPre.next = parentCurrent.left;
                    childPre = parentCurrent.left;
                }
                if (parentCurrent.right != null){
                    if (childStart == null) childStart = parentCurrent.right;
                    if (childPre != null) childPre.next = parentCurrent.right;
                    childPre = parentCurrent.right;
                }
                parentCurrent = parentCurrent.next;
                
            }
            parentStart = childStart;
            childStart = null;
        }
        
    }
}
