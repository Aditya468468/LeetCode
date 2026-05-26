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
        
        while(head!=null && head.next!=null && head.val==head.next.val)
        {
            int d=head.val;
            while(head!=null && head.val==d)
            {
                head=head.next;
            }
           
        }
        if(head==null) return null;
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr!=null && curr.next!=null)
        {
            
            if(curr.val==curr.next.val)
            {
                int data=curr.val;
                while(curr!=null && curr.val==data)
                {
                    curr=curr.next;
                }
                prev.next=curr;

            }
            else
            {
                prev=curr;
                curr=curr.next;
            }
        }

        return head;
        
    }
}