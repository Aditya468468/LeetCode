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
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {

            fast=fast.next.next;
            ListNode nextNode=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nextNode;

        }
        if(fast!=null)
        {
            slow=slow.next;
        }
        //slow-> Middle
        ListNode leftTemp=prev;
        ListNode rightTemp=slow;
        while(leftTemp!=null || rightTemp!=null)
        {
            if(leftTemp.val!=rightTemp.val) return false;
            leftTemp=leftTemp.next;
            rightTemp=rightTemp.next;
        }


        return true;
        
    }
}