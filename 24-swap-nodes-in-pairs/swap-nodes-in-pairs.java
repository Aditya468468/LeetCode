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
    public ListNode swapPairs(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prevTail=dummy;
        while(prevTail.next!=null && prevTail.next.next!=null) // So we see from the prevTail, do I have 2 nodes in Front of me.
        {
            //Storing Future connections
            ListNode prev=prevTail.next;
            ListNode curr=prev.next; 
    
            //Conecting 
            prev.next=curr.next;
            curr.next=prev;
            prevTail.next=curr;
            // Moving
            prevTail=prev;
        }
        
        return dummy.next;
        
    }
}