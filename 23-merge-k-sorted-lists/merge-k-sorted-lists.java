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

class Pair
{
    int val;
    ListNode node;
    public Pair(int val,ListNode node)
    {
        this.val=val;
        this.node=node;
    }
}
class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.val-b.val);
        // As its a custom class PQ doesnt know how to sort it, So passed a custom comp
        for(ListNode x:lists)
        {
            if(x!=null) q.offer(new Pair(x.val,x));
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(!q.isEmpty())
        {
            Pair p =q.poll();
            curr.next=p.node;
            curr=curr.next;
            if(p.node.next!=null)
            {
                q.offer(new Pair(p.node.next.val,p.node.next));
            }
        }

        return dummy.next;

        
    }
}