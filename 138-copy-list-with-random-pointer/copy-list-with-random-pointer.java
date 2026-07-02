/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


class Solution {
    public Node copyRandomList(Node head) 
    {
        if(head==null) return null;
        Node temp=head;
        //Insert the deepNodes btw nodes
        while(temp!=null)
        {
            Node nextNode=temp.next;
            Node node = new Node(temp.val);
            temp.next=node;
            node.next=nextNode;
            temp = nextNode;
        }
        // Connecting Random Pointers
        temp=head;
        // Node dummy=new Node(-1);
        // Node curr=dummy;
        while(temp!=null && temp.next!=null)
        {
            Node deepNode=temp.next;
            Node random=temp.random;
            Node deepRandom = null;
            if(random!=null) 
            {
                deepRandom = random.next;
            }
            deepNode.random=deepRandom;
            temp=temp.next.next;
        }
        // Connecting Next Pointers.
        Node dummy=new Node(-1);
        dummy.next=head.next;
        temp=head;
        while(temp!=null)
        {
            Node deepNode=temp.next;
            Node nextNode=deepNode.next;
            temp.next=nextNode;
            if(nextNode==null)
            {
                deepNode=null;
            }
            else
            {
                deepNode.next=nextNode.next;
            }
            temp=nextNode;
          
        }

        return dummy.next;

    }
}