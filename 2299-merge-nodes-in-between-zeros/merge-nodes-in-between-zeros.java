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
    private int add(ListNode start,ListNode end)
    {
        ListNode temp=start;
        int sum=0;
        while(temp!=end.next)
        {
            sum+=temp.val;
            temp=temp.next;
        }
        return sum;

    }
    public ListNode mergeNodes(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode prevZero=head;
        ListNode temp=head.next;
        while(temp.next!=null)
        {
            if(temp.next.val==0)
            {
                int x=add(prevZero.next,temp);
                ListNode node=new ListNode(x);
                curr.next=node;
                curr=node;
            }
            else if(temp.val==0)
            {
                prevZero=temp;
            }
            temp=temp.next;
        }

        return dummy.next;
    }
}