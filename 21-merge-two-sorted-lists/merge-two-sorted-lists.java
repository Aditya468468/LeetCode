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
        //Data Replacement/Data Extraction
        ArrayList<Integer> list=new ArrayList<>();
        ListNode temp1=list1;
        ListNode temp2=list2;
        while(temp1!=null || temp2!=null)
        {
            if(temp1!=null)
            {
                list.add(temp1.val);
                temp1=temp1.next;
            }
            if(temp2!=null)
            {
                list.add(temp2.val);
                temp2=temp2.next;
            }
        }
        Collections.sort(list);
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        for(int i=0;i<list.size();i++)
        {
            ListNode node=new ListNode(list.get(i));
            curr.next=node;
            curr=node;
        }

        return dummy.next;

        
    }
}