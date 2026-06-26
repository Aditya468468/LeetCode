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
    public int gcd(int a,int b)
    {
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        for(int i=min;i>0;i--)
        {
            if(a%i==0 && b%i==0)
            {
                return i;
            }
        }
        return -1; //dummy
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) 
    {

        if(head==null || head.next==null) return head;
        ListNode curr=head;
        while(curr.next!=null)
        {
            ListNode nextNode=curr.next;
            int x=gcd(curr.val,nextNode.val);
            ListNode node=new ListNode(x);
            curr.next=node;
            node.next=nextNode;
            curr=nextNode;
        }

        return head;

        
    }
}