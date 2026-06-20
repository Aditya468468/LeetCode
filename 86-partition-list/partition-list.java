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
class Solution {
    public ListNode partition(ListNode head, int x) 
    {
        ListNode dummySmaller=new ListNode(-1);
        ListNode dummyGreater=new ListNode(-1);
        ListNode smaller=dummySmaller;
        ListNode greater=dummyGreater;
        ListNode curr=head;
        while(curr!=null)
        {
            if(curr.val<x)
            {
                smaller.next=curr;
                smaller=smaller.next;
            }
            else
            {
                greater.next=curr;
                greater=greater.next;
            }
            curr=curr.next;
        }
      
        if(dummySmaller.next==null)
        {
            greater.next=null;
            return dummyGreater.next;
        }
        smaller.next=dummyGreater.next;
        greater.next=null;

        return dummySmaller.next;
        
    }
}