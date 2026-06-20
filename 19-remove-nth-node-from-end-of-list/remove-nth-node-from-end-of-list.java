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
    private int lengthOfLL(ListNode head)
    {
        ListNode temp=head;
        int len=0;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }

        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head==null) return null;
        int len=lengthOfLL(head);
        if(n==len) //head deletion.
        {
            return head.next;
        }
        int k=(len-n);
        if(k<0) return head;
        ListNode curr=head;
        int cnt=1;
        while(curr!=null && cnt!=k)
        {
            curr=curr.next;
            cnt++;
        }
        if(curr.next.next==null)
        {
            curr.next=null;
            return head;
        }
        ListNode nextNode=curr.next;
        curr.next=curr.next.next;
        nextNode.next=null;

        return head;

        
    }
}