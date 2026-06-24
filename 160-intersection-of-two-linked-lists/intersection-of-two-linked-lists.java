/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public int length(ListNode head)
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
    public ListNode collison(ListNode headA, ListNode headB,int d)
    {
        //headA->Longer Len
        ListNode t1=headA;
        ListNode t2=headB;
        for(int i=0;i<d;i++)
        {
            t1=t1.next;
        }
        // Both Pointers are aligned now.
        while(t1!=t2)
        {
            t1=t1.next;
            t2=t2.next;
        }

        return t1;

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int l1=length(headA);
        int l2=length(headB);

        if(l1>l2)
        {
            return collison(headA,headB,l1-l2);
        }
        else
        {
            return collison(headB,headA,l2-l1);
        }
        
    }
}