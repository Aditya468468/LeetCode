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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        //Optimal
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode temp1=list1;
        ListNode temp2=list2;
        while(temp1!=null && temp2!=null)
        {
            ListNode node=new ListNode();
            if(temp1.val<temp2.val)
            {
                node.val=temp1.val;
                curr.next=node;
                curr=node;
                temp1=temp1.next;
            }
            else
            {
                node.val=temp2.val;
                curr.next=node;
                curr=node;
                temp2=temp2.next;
            }
            
        }
        while(temp1!=null)
        {
            ListNode node=new ListNode();
            node.val=temp1.val;
            curr.next=node;
            curr=node;
            temp1=temp1.next;

        }
        while(temp2!=null)
        {
            ListNode node=new ListNode();
            node.val=temp2.val;
            curr.next=node;
            curr=node;
            temp2=temp2.next;

        }
       
        return dummy.next;

        
    }
}