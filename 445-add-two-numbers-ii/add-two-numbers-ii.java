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
    private ListNode reverseList(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
    
        while(l1!=null || l2!=null || carry!=0)
        {
            int sum=carry;
            if(l1!=null) 
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            ListNode node=new ListNode(sum%10);
            curr.next=node;
            curr=node;
            carry=sum/10;
        }

        return reverseList(dummy.next);

    }
}