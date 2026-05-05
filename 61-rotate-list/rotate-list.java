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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null || k == 0)
            return head;

        // Step 1: find length
        ListNode temp = head;
        int n = 1;
        while(temp.next != null)
        {
            temp = temp.next;
            n++;
        }

        // Step 2: make circular
        temp.next = head;

        // Step 3: reduce k
        k = k % n;
        int stepsToNewHead = n - k;

        // Step 4: move to new tail
        ListNode newTail = head;
        for(int i = 1; i < stepsToNewHead; i++)
        {
            newTail = newTail.next;
        }

        // Step 5: break
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}