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
    private ListNode reverse(ListNode head)
    {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }

        return prev;
    }
    public ListNode doubleIt(ListNode head) 
    {
        head=reverse(head);
        int carry=0;
        ListNode temp=head;
        // ListNode dummy=new ListNode(-1);
        // ListNode curr=dummy;
        while(temp!=null)
        {
            int x=(temp.val*2)+carry;
            temp.val=x%10;
            carry=x/10;
            temp=temp.next;
        }
        if(carry!=0)
        {
            ListNode node=new ListNode(carry);
            node.next=temp;
        }
        head=reverse(head);
        if(carry!=0)
        {
            ListNode node=new ListNode(carry);
            node.next=head;
            head=node;
        }
        return head;

        

        
    }
}