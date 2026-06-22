/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) 
    {
        ListNode nextNode=node.next;
        node.val=node.next.val;
        node.next=node.next.next;
        nextNode.next=null; //Clean Up
    }
        // A funny Ques, Haha,
        // See we dont need to delete its memory and all,
        // If node is give if i change its val to its next node val,
        // then make it point to next to next node, Then BOOM Done.
        // 4->5->1->

        //      |->->->|    
        //   4->1  1-> 9 see how flow changes.
    
}