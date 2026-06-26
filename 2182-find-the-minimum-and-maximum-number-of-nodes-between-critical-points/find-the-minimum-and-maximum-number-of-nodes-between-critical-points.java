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
        if(head==null || head.next==null) return new int[]{-1,-1};
        //Lets Just calculate all The Critical Points
        List<Integer> list=new ArrayList<>();
        ListNode prev=head;
        ListNode curr=head.next;
        int cnt=2;
        while(curr.next!=null)
        {
            ListNode nextNode=curr.next;
            int currV=curr.val;
            int nextV=nextNode.val;
            int prevV=prev.val;
            if(prevV<currV && currV>nextV)
            {
                list.add(cnt);
            }
            else if(prevV>currV && currV<nextV)
            {
                list.add(cnt);
            }
            prev=curr;
            curr=curr.next;
            cnt++;
        }
        if(list.size()<2) return new int[]{-1,-1};
        // Well The List would be aleady sorted..soo max diff will be btw
        // the end points.
        int max=list.get(list.size()-1)-list.get(0);
        //The Min dis will be btw adj elements as List is Sorted.
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++)
        {
            int val=list.get(i)-list.get(i-1);
            min=Math.min(min,val);
        }

        return new int[]{min,max};


        
    }
}