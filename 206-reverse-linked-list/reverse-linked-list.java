/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution 
{
    private ListNode reverse(ListNode curr,ListNode prev)
    {
        if(curr==null)
        {
            return prev;
        }
        ListNode nextNode=curr.next;
        curr.next=prev;
        return reverse(nextNode,curr);
    }
    public ListNode reverseList(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        return reverse(head,null);
    }
}