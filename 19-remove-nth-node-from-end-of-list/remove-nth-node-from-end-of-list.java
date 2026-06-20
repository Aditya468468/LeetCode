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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        //Gap Method Using Fast And Slow Pointer.
        // We Maintain a Gap of N btw two pointers

        ListNode fast=head;
        for(int i=0;i<n;i++) // Actually our Constraints says that n will be btw Len
        {
            fast=fast.next;
        }
        if(fast==null)
        {
            return head.next;
        }
        ListNode slow=head;
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        ListNode nextNode =slow.next;
        slow.next=slow.next.next;
        nextNode.next=null;

        return head;


        
    }
}