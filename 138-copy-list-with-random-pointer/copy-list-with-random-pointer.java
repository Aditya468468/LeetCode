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
        HashMap<Node,Node> map=new HashMap<>();
        Node temp=head;
        while(temp!=null)
        {
           Node node=new Node(temp.val);
            map.put(temp,node);
            temp=temp.next;

        }

        temp=head;
        while(temp!=null)
        {
            Node next=temp.next;
            Node random=temp.random;
            Node deepNode=map.get(temp);
            Node deepNext=map.get(next);
            Node deepRandom=map.get(random);
            deepNode.next=deepNext;
            deepNode.random=deepRandom;
            temp=temp.next;
        }
        return map.get(head);
    }
}