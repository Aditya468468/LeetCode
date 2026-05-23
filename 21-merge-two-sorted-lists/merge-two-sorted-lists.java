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
            if(temp1.val<temp2.val)
            {
               
                curr.next=temp1;
                curr=temp1;
                temp1=temp1.next;
            }
            else
            {

                curr.next=temp2;
                curr=temp2;
                temp2=temp2.next;
            }
            
        }
        //we can directly link it,because remaining part is already sorted chain
        if(temp1==null)
        {
            curr.next=temp2;
        }
        else
        {
            curr.next=temp1;
        }
       
        return dummy.next;

        
    }
}