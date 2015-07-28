package net.kc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;



public class WorkWithList {
	public void play ()
	{
		ListNode head = new ListNode (1);
		head.next = new ListNode (2);
		head.next.next = new ListNode (3);
		head.next.next.next = new ListNode (4);
		
		reorderList(head);
		
		while (head !=null)
		{
			System.out.println(head.val);
			head= head.next;
		}
	}
	
	public void showList ()
	{
		ListNode head = new ListNode(3);
		head.next=new ListNode(4);
		head.next.next = new ListNode(1);
		ListNode cur = head;
		while (cur!= null)
		{
			System.out.println(cur.val);
			cur= cur.next;
		}
		cur = insertionSortList2(head);
		while (cur!= null)
		{
			System.out.println(cur.val);
			cur= cur.next;
		}
	}

	
	public void reorderList(ListNode head) {
	    if (head != null)
	    {
	        int count = 0;
	        ListNode countNode = head;
	        Stack<ListNode> stack = new Stack<ListNode>();
	        while (countNode != null)
	        {
	            stack.push(countNode);
	            count++;
	            countNode = countNode.next;
	        }
	        ListNode start = head;
	        int i;
	        for (i=0; i< (count-1)/2 ;i++)
	        {
	            ListNode tmp = stack.pop();
	            
	            tmp.next = start.next;
	            start.next = tmp;
	            
	            start = tmp.next;
	        }
	        if (count == 2*i+2)
	            start.next.next = null;
	        else 
	            start.next = null;
	      
	    }
	}
	
	public void reorderList2(ListNode head) {
	    if (head != null)
	    {
	        int count = 0;
	        ListNode countNode = head;
	        while (countNode != null)
	        {
	            count++;
	            countNode = countNode.next;
	        }
	        for ( int i=0; i< count/2 ;i++)
	        {
	            //get end Node
	            ListNode start =new ListNode (0);
	            start.next = head;
	            while (start.next.next != null)
	                start= start.next;
	            //start point to n-1
	            ListNode tmp = start.next;
	            start.next = null;
	            
	            ListNode insert = head;
	            
	            for (int j=1 ; j<= 2*i+1 ;j++)
	            {
	                insert = insert.next;
	            }
	            
	            tmp.next = insert.next;
	            insert.next = tmp;
	            
	        }
	    }
	    }
	public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummy.next;
    }
	/*
	 * Definition for ListNode
	 */
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	private static final Comparator<ListNode> listComparator = new Comparator<ListNode>(){

		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val-o2.val;
		}
		
	};
	public ListNode mergeKLists(ListNode[] lists){
		if (lists == null||lists.length == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,listComparator);
		for (ListNode n:lists){
			if (n!=null){
				pq.add(n);
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!pq.isEmpty()){
			ListNode node = pq.poll();
			p.next = node;
			p = p.next;
			if (node.next!=null)
				pq.add(node.next);
		}
		return dummy.next;
	}
	
}
