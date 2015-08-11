package net.Tree;
import net.LinkedList.*;

public class convertSortedListToBST {
	 public int getLen(ListNode head){
	        int len = 0;
	        while (head!=null){
	            head = head.next;
	            len++;
	        }
	        return len;
	    }
	 
	/*
	 * O(n lgn)
	 */
	public TreeNode sortedListToBST1(ListNode head) {
        int len = getLen(head);
        return helper(head, len);
    }
    
    public TreeNode helper(ListNode head, int len){
        if (len == 0) return null;
        int m = 1 + len/2;
        ListNode cur = head;
        for (int i=1; i< m ;i++){
            cur = cur.next;
        }
        TreeNode root = new TreeNode(cur.val);
        root.left = helper(head, m -1);
        root.right = helper(cur.next, len-m);
        return root;
        
    } 
    
   
    private ListNode cur = null;
    public TreeNode sortedListToBST(ListNode head) {
        int len = getLen(head);
        if (head == null) return null;
        cur = head;
        return helper(len);
    }
    
    public TreeNode helper(int len){
        if (len == 0) return null;
        int m = 1 + len/2;
        TreeNode left = helper(m -1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        root.left = left;
        root.right = helper(len-m);
        return root;
        
    } 
    
    private ListNode list;
    public TreeNode sortedListToBST3(ListNode head){
        int len=0;
        ListNode p = head;
        while (p!=null){
            len++;
            p = p.next;
        }
        list = head;
        return sortedListToBST(0,len-1);
    }
    
    private TreeNode sortedListToBST(int start,int end){
        if (start>end) return null;
        int mid = (start+end)/2;
        TreeNode leftSub = sortedListToBST(start,mid-1);
        TreeNode node = new TreeNode(list.val);
        node.left = leftSub;
        list = list.next;
        TreeNode rightSub = sortedListToBST(mid+1,end);
        node.right = rightSub;
        return node;
    }
    
    
    /*
     * use Wrapper
     */
    class ListNodeWrapper {
        ListNode listNode;
        ListNodeWrapper (ListNode lnode) {
            listNode = lnode;
        }
    }
    
    public TreeNode sortedListToBST4(ListNode head) {
        int len = getLen(head);
        if (head == null) return null;
        ListNodeWrapper InWrapper = new ListNodeWrapper(head);
        return helper(InWrapper,len);
    }
    public TreeNode helper(ListNodeWrapper InWrapper, int len){
        if (len == 0) return null;
        TreeNode leftNode = helper(InWrapper, len/2);
        TreeNode root = new TreeNode(InWrapper.listNode.val);
        InWrapper.listNode = InWrapper.listNode.next;
        TreeNode rightNode = helper(InWrapper, len-1-len/2);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
