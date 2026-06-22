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
class Solution 
{
    private int length(ListNode head)
    {
        ListNode temp=head;
        int cnt=0;
        while(temp!=null)
        {
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
    private int add(ListNode l1,ListNode l2)
    {
        if(l1==null && l2==null)
        {
            return 0;
        }
        int carry=add(l1.next,l2.next);
        int sum=carry+l1.val+l2.val;
        l1.val=sum%10;
        return sum/10;


    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int len1=length(l1);
        int len2=length(l2);
        int diff=Math.abs(len1-len2);
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(diff!=0)
        {
            ListNode node=new ListNode(0);
            curr.next=node;
            curr=node;
            diff--;
        }
        //Padding list is available.
        if(len1>len2)
        {
            curr.next=l2;
            l2=dummy.next;
        }
        else if(len2>len1)
        {
            curr.next=l1;
            l1=dummy.next;
        }
        // 7->2->4->3
        // 0->5->6->4
        int carry=add(l1,l2);
        if(carry!=0)
        {
            ListNode node=new ListNode(1);
            node.next=l1;
            l1=node;
        }

        return l1;


        
    }
}