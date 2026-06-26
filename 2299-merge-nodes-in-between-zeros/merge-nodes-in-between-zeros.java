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
    public ListNode mergeNodes(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int sum=0;
        ListNode temp=head.next;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            if(temp.val==0)
            {
                temp.val=sum;// Using the 0 node itself as a part of my result to save memory.
                curr.next=temp;
                temp.next=null;
                curr=temp;
                sum=0;

            }
            else 
            {
                sum+=(temp.val);
            }
            temp=nextNode;
        }

        return dummy.next;
    }
}