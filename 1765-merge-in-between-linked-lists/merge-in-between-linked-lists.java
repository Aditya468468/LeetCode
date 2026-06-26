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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        //Lets find ath Node
        ListNode aNodePrev=list1;
        int cnt=1;
        while(aNodePrev!=null && cnt<a)
        {
            aNodePrev=aNodePrev.next;
            cnt++;
        }
        int diff=b-a+2;
        int cnt2=0;
        ListNode bNodeNext=aNodePrev;
        while(bNodeNext!=null && cnt2<diff)
        {
            bNodeNext=bNodeNext.next;
            cnt2++;
        }
        //Tail of list2;
        ListNode tail=list2;
        while(tail.next!=null)
        {
            tail=tail.next;
        }
        aNodePrev.next=list2;
        tail.next=bNodeNext;

        return list1;
        
    }
}