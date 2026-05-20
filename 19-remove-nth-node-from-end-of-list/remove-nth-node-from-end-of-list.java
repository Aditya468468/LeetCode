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
    private int length(ListNode head)
    {
        int len=0;
        if(head==null)
        {
            return len;
        }
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        int len=length(head);
        if(n==len) 
        {
            return head.next;
        }
        int req=(len-n);
        if(req<0) return head;
        int cnt=1;
        ListNode temp=head;
        while(req!=cnt)
        {
            cnt++;
            temp=temp.next;
        }
        ListNode k=temp.next;
        if(k==null)
        {
            temp.next=null; // last Node
            return head;
        }
        temp.next=k.next;
        k.next=null;

        return head;
        
        
        
    }
}