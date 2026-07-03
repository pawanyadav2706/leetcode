/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) {
        	return head;
        }
     // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        while(true) {
            ListNode last = prev;
            ListNode newEnd = current;
            ListNode temp = current;
            int count = 0;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
}

        if (count < k) {
        break;
}
            
            // reverse between left and right
            ListNode next = current.next;
            for(int i=0; current != null && i<k; i++) {
            	current.next = prev;
    			prev = current;
    			current = next;
    			if(next != null) {
    				next = next.next;
    			}
            }
            if(last != null) {
            	last.next = prev;
            }else {
            	head = prev;
            }
            newEnd.next = current;
            
            if(current == null) {
            	break;
            }
            prev = newEnd;
        }
        return head;
    }
}