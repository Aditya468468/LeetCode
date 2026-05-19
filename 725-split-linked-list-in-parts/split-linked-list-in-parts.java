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
    private int lengthOfLL(ListNode head)
    {
        int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }

        return len;
    }
    public ListNode[] splitListToParts(ListNode head, int k) 
    {
        int N=lengthOfLL(head);
        ListNode[] res=new ListNode[k];
        int idx=0;
        //When N<k.-> we can split as many ways but ques said-> Keep more equals.
        // Soo we Split is as 1 each.(Where N<k)
        if(N<k)
        {
            ListNode temp=head;
            while(temp!=null)
            {
                ListNode nextNode=temp.next;
                temp.next=null;
                res[idx++]=temp;
                temp=nextNode;
            }

            return res;
        }
        
        int split=N/k;
        int extra=N%k;
        ListNode temp=head;
        ListNode tempHead=null;
        int cnt=0;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            if(tempHead==null)
            {
                tempHead=temp;
            }
            cnt++;
            if(extra>0 && cnt==split+1)
            {
                   
                    temp.next=null;
                    res[idx++]=tempHead;
                    tempHead=null;
                    cnt=0;
                    extra--;
            }
            else if(extra==0 && cnt==split)
            {
                    temp.next=null;
                    res[idx++]=tempHead;
                    tempHead=null;
                    cnt=0;
            }
           temp=nextNode;
        }

        return res;
    }
}