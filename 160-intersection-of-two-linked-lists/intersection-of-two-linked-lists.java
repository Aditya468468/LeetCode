/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        // Hashing Approach
        HashMap<ListNode,Integer> map=new HashMap<>();
        ListNode temp1=headA;
        while(temp1!=null)
        {
            int val=temp1.val;
            map.put(temp1,val);
            temp1=temp1.next;
        }
        ListNode temp2=headB;
        while(temp2!=null)
        {
            if(map.containsKey(temp2))
            {
                return temp2;
            }
            temp2=temp2.next;
        }

        return null;

        
    }
}