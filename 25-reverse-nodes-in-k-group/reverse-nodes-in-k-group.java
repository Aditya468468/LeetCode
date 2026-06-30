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

    public ListNode count_K_Nodes(ListNode head,int k)
    {
        int cnt=1;
        ListNode temp=head;
        while(temp.next!=null && cnt<k)
        {
            temp=temp.next;
            cnt++;
        }
        if(cnt!=k) return null;
        return temp;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode groupTail=dummy;
        while(groupTail!=null && groupTail.next!=null)
        {
            ListNode start=groupTail.next;
            ListNode end=count_K_Nodes(start,k);
            if(end==null) break;
            ListNode nextNode=end.next;
            end.next=null;
            ListNode newHead=reverse(start);
            groupTail.next=newHead;
            start.next=nextNode;
            groupTail=start;
        }

        return dummy.next;



        
    }
}