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
    public void reorderList(ListNode head) 
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        // slow-> Is at Middle.
        ListNode temp=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        //prev -> Will be at last node.
        ListNode front=head;
        ListNode end=prev;
        while(end!=null)
        {
            ListNode nextFront=front.next;
            ListNode nextEnd=end.next;
            front.next=end;
            end.next=nextFront;
            front=nextFront;
            end=nextEnd;
        }
        
       // return head;
        
    }
}