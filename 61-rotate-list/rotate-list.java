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
class Solution 
{
    private int length(ListNode head)
    {
        ListNode temp=head;
        int len=0;
        while(temp!=null)
        {
            temp=temp.next;
            len++;
        }

        return len;

    }
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null || head.next==null) return head;
        int len=length(head);
        k=k%len;
        if(k==0) return head;
        ListNode fast=head;
        for(int i=0;i<k;i++)
        {
            fast=fast.next;
        }
        if(fast==null) return head;
        ListNode slow=head;
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
            
        }
        ListNode node=slow.next;
        slow.next=null;
        fast.next=head;
        head=node;

        return head;
        
    }
}