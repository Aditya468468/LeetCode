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
    private int multiply(ListNode curr)
    {
        if(curr==null)
        {
            return 0;
        }
        int carry=multiply(curr.next);
        int x=(curr.val*2)+carry;
        curr.val=x%10;
        return x/10;
    }
    public ListNode doubleIt(ListNode head) 
    {
        if(head==null) return head;
        int carry=multiply(head);
        if(carry!=0)
        {
            ListNode node=new ListNode(carry);
            node.next=head;
            head=node;
        }
        return head;

        

        
    }
}