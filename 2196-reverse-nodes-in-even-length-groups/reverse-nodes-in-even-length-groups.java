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
    class Pair
    {
        int count;
        ListNode node;
        Pair()
        {

        }
        Pair(int count,ListNode node)
        {
            this.count=count;
            this.node=node;
        }
    }
    public Pair countNode(ListNode head,int count)
    {
        int cnt=1;
        ListNode temp=head;
        ListNode prev=null;
        while(temp.next!=null && count>cnt)
        {
            prev=temp;
            temp=temp.next;
            cnt++;
        }
        Pair p=new Pair();
        if(temp==null)
        {
            p.count=cnt;
            p.node=prev;
        }
        else
        {
            p.count=cnt;
            p.node=temp;
        }

        return p;

    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        return prev; // the head;
    }
    public ListNode reverseEvenLengthGroups(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        ListNode curr=null;
        ListNode prev=null;
        ListNode prevTail=head;
        int cnt=2;
        while(prevTail!=null && prevTail.next!=null)
        {
            ListNode start=prevTail.next;
            Pair nodeData=countNode(start,cnt);
            ListNode end=nodeData.node;
            int countOfNode=nodeData.count;
            if(end==null) break;
            if(countOfNode%2 == 1)
            {
                prevTail=end;
            }
            else
            {
                ListNode nextNode=end.next;
                end.next=null; // break the connection.
                ListNode newHead=reverse(start);
                prevTail.next=newHead;
                start.next=nextNode;
                prevTail=start;
            }
            cnt++;
        }
        
        return head;

        
    }
}