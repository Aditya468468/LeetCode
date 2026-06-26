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
        while(a!=0 && b!=0)
        {
            if(a>b)
            {
                a=a%b;
            }
            else
            {
                b=b%a;

            }
        }
        if(a==0) return b;
        else return a;
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