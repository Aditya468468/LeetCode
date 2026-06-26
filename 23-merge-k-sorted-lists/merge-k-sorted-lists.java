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
    public ListNode merge(ListNode headA,ListNode headB)
    {
        ListNode temp1=headA;
        ListNode temp2=headB;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy; 
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val>temp2.val)
            {
                curr.next=temp2;
                curr=temp2;
                temp2=temp2.next;
            }
            else
            {
                curr.next=temp1;
                curr=temp1;
                temp1=temp1.next;
            }
        }
        if(temp1==null)
        {
            curr.next=temp2;
        }
        else
        {
            curr.next=temp1;
        }

        return dummy.next;

    }
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        ListNode newHead=merge(lists[0],lists[1]);
        ListNode currHead=newHead;
        for(int i=2;i<lists.length;i++)
        {
            newHead=merge(currHead,lists[i]);
            currHead=newHead;
        }

        return currHead;
        
    }
}