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
        int firstPoint = -1;
        int prevPoint = -1;
        int minDistance = Integer.MAX_VALUE;
        while(curr.next!=null)
        {
            ListNode nextNode=curr.next;
            int currV = curr.val;
            int nextV = nextNode.val;
            int prevV = prev.val;
            
            if ((prevV < currV && currV > nextV) || (prevV > currV && currV < nextV)) 
            {
            // If this is the very first critical point found
            if (firstPoint==-1) 
            {
                firstPoint=cnt;
            } 
            else 
            {
                // If we've already found a previous point, update the minimum distance
                minDistance = Math.min(minDistance,cnt - prevPoint);
            }
            prevPoint=cnt;
        }
            prev=curr;
            curr=curr.next;
            cnt++;
        }
        if (firstPoint == prevPoint) 
        {
            return new int[]{-1, -1};// Just One Point 
        }

        int maxDistance = prevPoint-firstPoint;

        return new int[]{minDistance,maxDistance};
        
    }
}