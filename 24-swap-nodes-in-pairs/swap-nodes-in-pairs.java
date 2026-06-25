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
        ListNode groupHead=dummy;
        ListNode curr=head.next;
        ListNode prev=head;
        while(curr!=null && curr.next!=null)
        {
            ListNode nextNode=curr.next;
            ListNode nextCurr=curr.next.next;
            curr.next=prev;
            prev.next=nextNode;
            groupHead.next=curr;
            groupHead=prev;
            curr=nextCurr;
            prev=nextNode;

        }
        if(curr!=null)
        {
            curr.next=prev;
            groupHead.next=curr;
            prev.next=null;
        }

        return dummy.next;


        
    }
}