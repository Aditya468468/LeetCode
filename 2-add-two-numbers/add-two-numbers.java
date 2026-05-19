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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0;
        ListNode head=null;
        ListNode curr=null;
        while(temp1!=null && temp2!=null)
        {
            int sum=temp1.val+temp2.val+carry;
            if(sum>9)
            {
                sum=sum%10;
                carry=1;
            }
            else
            {
                carry=0;
            }
            if(head==null)
            {
                head=new ListNode(sum);
                curr=head;
                
            }
            else
            {
                ListNode node=new ListNode(sum);
                curr.next=node;
                curr=curr.next;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        // Either l1 || l2 would have ended.. But other remains.

        while(temp1!=null)
        {
            int sum=temp1.val+carry;
            if(sum>9)
            {
                sum=sum%10;
                carry=1;
            }
            else 
            {
                carry=0;
            }
            ListNode node=new ListNode(sum);
            curr.next=node;
            curr=node;
            temp1=temp1.next;
        }
        while(temp2!=null)
        {
            int sum=temp2.val+carry;
            if(sum>9)
            {
                sum=sum%10;
                carry=1;
            }
            else 
            {
                carry=0;
            }
            ListNode node=new ListNode(sum);
            curr.next=node;
            curr=node;
            temp2=temp2.next;
        }
        // After all this there can be still Carry remaning.
        if(carry!=0)
        {
            ListNode node=new ListNode(carry);
            curr.next=node;
            curr=node;
        }

        return head;

        
    }
}