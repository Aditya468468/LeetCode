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
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }

        return prev;

    }
    public ListNode removeNodes(ListNode head) 
    {
        //We need to Know data towards right from i idx,if it would be array we 
        // would have done back-traversal,But its LL, So we Reverse the LL.
        head=reverse(head);
        ListNode prev=null;
        ListNode curr=head;
        int maxValue=head.val;
        while(curr!=null)
        {
            if(curr.val>=maxValue)
            {
                maxValue=curr.val;
                prev=curr;
                curr=curr.next;
            }
            else
            {
                ListNode nextNode=curr.next;
                prev.next=curr.next;
                curr=nextNode;
            }

        }

        return reverse(head);
        
    }
}