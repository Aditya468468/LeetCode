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
    private ListNode k_Start(ListNode head,int k)
    {
        ListNode temp=head;
        while(temp!=null && (k-1)!=0)
        {
            temp=temp.next;
            k--;
        }
        if(k<0) return null;
        
        return temp;


    }
    private ListNode k_End(ListNode head,int k)
    {
        ListNode fast=head;
        for(int i=0;i<k;i++)
        {
            fast=fast.next;
        }
        if(fast==null) return head;
        ListNode slow=head;
        while(fast!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }

        return slow;
    }
    public ListNode swapNodes(ListNode head, int k) 
    {
        ListNode start=k_Start(head,k);
        ListNode end=k_End(head,k);
        if(start==null) return head; // Out of Range.
        int temp=start.val;
        start.val=end.val;
        end.val=temp;

        return head;
    }
}