class Solution 
{
    private int length(ListNode head)
    {
        ListNode temp=head;
        int len=0;
        while(temp!=null)
        {
            temp=temp.next;
            len++;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        // Length-Based Approach
        int l1=length(headA);
        int l2=length(headB);
        int diff=Math.abs(l1-l2);
        //Gap Method
        ListNode fast=null;
        ListNode slow=null;
        if(l1>l2)
        {
            fast=headA;
            slow=headB;
        }
        else
        {
            fast=headB;
            slow=headA;
        }
        for(int i=0;i<diff;i++)
        {
            fast=fast.next;
        }
        while(fast!=slow)
        {
            fast=fast.next;
            slow=slow.next;
        }

        return slow;

        

    }
}
