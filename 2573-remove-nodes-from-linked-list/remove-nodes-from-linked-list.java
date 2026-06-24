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
            ListNode nextNode=curr.next;
            if(curr.val>=maxValue)
            {
                maxValue=curr.val;
                prev=curr;
            }
            else
            {
                prev.next=curr.next;
                //prev wont change, As we still dont know the safe next pointer to keep prev.
            }
             curr=nextNode;

        }

        return reverse(head);

        //Note-Kind off Leader in Array Type of Prblm.
        
    }
}