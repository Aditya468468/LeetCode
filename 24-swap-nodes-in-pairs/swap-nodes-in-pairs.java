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
        ListNode curr=head.next;
        ListNode prev=head;
        while(curr!=null)
        {
            int val=curr.val;
            curr.val=prev.val;
            prev.val=val;
            if(curr.next==null || curr.next.next==null)
            {
                break;
            }
            prev=curr.next;
            curr=curr.next.next;
        }

        return head;
        
    }
}