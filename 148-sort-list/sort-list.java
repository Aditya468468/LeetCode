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
    private int length(ListNode head)
    {
        int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        return len;
    }
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
    public ListNode NthNode(ListNode head,int n)
    {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        for(int i=0;i<n-1;i++)
        {
            if(temp==null) return null;
            temp=temp.next;
        }
        return temp;

    }
    public ListNode mergeSort(ListNode head)
    {
      
        if(head==null || head.next==null) return head;
        int len=length(head);
        ListNode mid=NthNode(head,len/2);
        ListNode right = mid.next;
        mid.next = null;
        // ListNode left=mergeSort(head);
        // ListNode right=mergeSort(right);
        return merge(mergeSort(head),mergeSort(right));
    
    }
    public ListNode sortList(ListNode head) 
    {
        return mergeSort(head);
    }
}

