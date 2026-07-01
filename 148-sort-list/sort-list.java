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
    public ListNode merge(ListNode list1,ListNode list2)
    {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode temp1=list1;
        ListNode temp2=list2;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val<temp2.val)
            {
                ListNode nextNode=temp1.next;
                curr.next=temp1;
                curr=curr.next;
                temp1.next=null;
                temp1=nextNode;
            }
            else
            {
                ListNode nextNode=temp2.next;
                curr.next=temp2;
                curr=curr.next;
                temp2.next=null;
                temp2=nextNode;

            }
        }
        if(temp1!=null) curr.next=temp1;
        else curr.next=temp2;

        return dummy.next;

    }
    public ListNode middle(ListNode head)
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
        ListNode mid=middle(head);
        ListNode right=mid.next;
        mid.next=null;
        return merge(mergeSort(head),mergeSort(right));
    }
    public ListNode sortList(ListNode head) 
    {
        return mergeSort(head);
        
    }
}