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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        int cnt=0;
        ListNode prev=null;
        ListNode curr=dummy;
        ListNode leftMost=null;
        ListNode rightMost=null;
        if(head==null || head.next==null) return head;
        while(curr!=null && cnt<=right)
        {
            ListNode nextNode=curr.next;
            if(cnt==left-1)
            {
                leftMost=curr;
            }
            if(cnt==right)
            {
                rightMost=nextNode;
            }
            if(cnt==left)
            {
                prev=curr;
            }
            if(cnt>left && cnt<=right)
            {
                curr.next=prev;
                prev=curr;
            }
            curr=nextNode;
            cnt++;
        }
        ListNode l=leftMost.next;
        leftMost.next=prev;
        l.next=rightMost;

        return dummy.next;
        
    }
}