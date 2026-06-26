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
    public ListNode middleNode(ListNode head)
    {
        if(head==null || head.next==null) return head;
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;

    }
    public ListNode mergeSort(ListNode head)
    {
      
        if(head==null || head.next==null) return head;
        ListNode mid=middleNode(head);
        ListNode right = mid.next;
        mid.next = null;

        return merge(mergeSort(head),mergeSort(right));
    
    }
    public ListNode sortList(ListNode head) 
    {
        return mergeSort(head);
    }
}

