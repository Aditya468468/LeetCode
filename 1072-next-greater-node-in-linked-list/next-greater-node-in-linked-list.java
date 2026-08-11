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
    public int[] nextLargerNodes(ListNode head) 
    {
       Map<ListNode,Integer> map=new HashMap<>(); // Will contains Node->ngE

       ListNode temp=head;
       Stack<ListNode> st=new Stack();
       int size=0;
       while(temp!=null)
       {
            int currValue=temp.val;

            while(!st.isEmpty() && currValue>st.peek().val)
            {
                ListNode node=st.pop();
                map.put(node,currValue);
            }

            st.push(temp);
            temp=temp.next;
            size++;
       }

       int []ans=new int[size];
       temp = head;
       int idx=0;
       while(temp!=null)
       {
            if(!map.containsKey(temp)) // Didnt Find the ngE
            {
                ans[idx]=0;
            }
            else
            {
                ans[idx]=map.get(temp); //Found it 
            }
            temp =temp.next;
            idx++;
       }

        return ans;


        
    }
}