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

    public ListNode removeZeroSumSublists(ListNode head) 
    {
        ListNode dummy=new ListNode(-1);
        Map<Integer,ListNode> map = new HashMap<>();
        map.put(0,dummy);
        ListNode curr=dummy;
        dummy.next=head;
        ListNode temp=head;
        int sum=0;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            sum+=temp.val;
            int req=sum;
            if(map.containsKey(req))
            {
                ListNode prevNode=map.get(req);
                int tempSum=sum;
                ListNode toRemove = prevNode.next;
                while (toRemove != temp) {
                    tempSum += toRemove.val;
                    map.remove(tempSum);
                    toRemove = toRemove.next;
                }
                prevNode.next=nextNode;
                temp.next=null;
                temp=nextNode;
                //sum=0;
            }
            else
            {
                map.put(sum,temp);
                temp=nextNode;

            }
        
        }

        return dummy.next;
        
    }
}