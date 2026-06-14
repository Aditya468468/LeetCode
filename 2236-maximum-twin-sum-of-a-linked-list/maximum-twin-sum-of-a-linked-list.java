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
    private ListNode middleOfLL(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }
    private ListNode reverse(ListNode head,ListNode middle)
    {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=middle)
        {
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        return prev;
    }

    public int pairSum(ListNode head) 
    {

        if(head==null) return 0;
        if(head.next==null) return head.val;

        ListNode middle=middleOfLL(head);
        ListNode left= reverse(head,middle);
        int maxSum=0;
        while(left!=null && middle!=null)
        {
            int sum=left.val+middle.val;
            maxSum=Math.max(sum,maxSum);
            left=left.next;
            middle=middle.next;
        }

        return maxSum;
        
    }
}