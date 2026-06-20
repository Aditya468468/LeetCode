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
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head==null || head.next==null) return head;

        ListNode prev=head; 
        // Single element is always unique, prev tracks the prev unique element
        ListNode curr=head.next; //traversal.
        while(curr!=null)
        {
            ListNode nextNode=curr.next;
            curr.next=null; //isolate it
            if(prev.val!=curr.val)
            {
                prev.next=curr;
                prev=curr;
            }
             curr=nextNode;
        }
        prev.next=null; // Any Last connections.

        return head;
        
    }
}