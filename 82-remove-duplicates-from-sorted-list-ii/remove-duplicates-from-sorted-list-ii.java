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
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        //if curr.next.val=curr.val.-> delete it.
        ListNode temp=head;
        while(temp!=null && temp.next!=null)
        {
            if(temp.val!=temp.next.val)
            {
                curr.next=temp;
                curr=temp;
                 temp=temp.next;
            }
            else
            {
                int x=temp.val;
                while(temp!=null && temp.val==x)
                {
                    temp=temp.next;
                }

            }
        
        }
        if(temp!=null)
        {
            curr.next=temp; // Last Node is Unique.
        }
        else
        {
            curr.next=null; // Removing Older Connections.
        }

        return dummy.next;
    }
}