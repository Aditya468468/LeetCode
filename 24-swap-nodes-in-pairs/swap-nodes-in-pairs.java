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
        ListNode prevTail=dummy;
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr!=null && curr.next!=null)
        {
            //Storing Future connections
            ListNode nextCurr=curr.next.next; // 2 nodes;
            ListNode nextPrev=prev.next.next; // 2 nodes;
    
            //Conecting 
            curr.next=prev;
            prev.next=nextPrev;
            prevTail.next=curr;
            // Moving
            prevTail=prev;
            prev=nextPrev;
            curr=nextCurr;
        }
        if(curr!=null)
        {
            curr.next=prev;
            prev.next=null;
            prevTail.next=curr;
        }

        return dummy.next;
        
    }
}