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
    public ListNode oddEvenList(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode oddHead=head;
        ListNode odd=head;
        ListNode evenHead=head.next;
        ListNode even=evenHead;
        ListNode temp=evenHead.next;
        boolean flag=true;
        while(temp!=null)
        {
            if(flag)
            {   
                odd.next=temp;
                odd=temp;
                flag=false;

            }
            else 
            {
                even.next=temp;
                even=temp;
                flag=true;

            }
            temp=temp.next;
        }
        odd.next=evenHead;
        even.next=null;

        return oddHead;
        
    }
}