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
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return new int[]{-1,-1};
        }
        ListNode prev=head;
        ListNode curr=head.next;
        int firstCritical=-1;
        int prevCritical=-1;
        int min=Integer.MAX_VALUE;
        int node=2;

        while(curr.next!=null)
        {
            if((prev.val<curr.val && curr.val>curr.next.val) || (prev.val>curr.val && curr.next.val>curr.val)) //Critcial Point
            {
                if(firstCritical==-1)
                {
                    firstCritical=node;
                    prevCritical=node;
                }
                else
                {
                    min=Math.min(node-prevCritical,min);
                    prevCritical=node;
                }

            }
            node++;
            prev=curr;
            curr=curr.next;
        }
        
        if(firstCritical==-1 || firstCritical==prevCritical)
        {
            return new int[]{-1,-1};

        }
        return new int[]{min,prevCritical-firstCritical};
        
    }
}