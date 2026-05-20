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
        ListNode temp=head;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            if(temp.val<x)
            {
                smaller.next=temp;
                smaller=temp;

            }
            else
            {
                greater.next=temp;
                greater=temp;

            }
            temp.next=null;
            temp=nextNode;
        }
        if(dummySmaller.next==null)
        {
            return dummyGreater.next;
        }
        smaller.next=dummyGreater.next;
        greater.next=null;

        return dummySmaller.next;
        
        
    }
}