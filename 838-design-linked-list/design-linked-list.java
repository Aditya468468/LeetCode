
class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class MyLinkedList 
{
    Node head;
    public Node getHead()
    {
        return this.head;
    }
    public MyLinkedList() 
    {
        //Umm Not Using
    }

    public int get(int index) 
    {
        if(head==null)
        {
            return -1;
        }
        int cnt=0;
        Node temp=head;
        while(temp!=null)
        {
            if(cnt==index)
            {
                return temp.data;
            }
            cnt++;
            temp=temp.next;
        }
        return -1;

    }
    public void addAtHead(int val) 
    {
        Node node=new Node(val);
        if(head==null)
        {
            head=node;
            return;
        }
        node.next=head;
        head=node;
        return;
    }
    
    public void addAtTail(int val) 
    {
        Node node=new Node(val);
        if(head==null)
        {
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=node;
        return;
        
    }
    
    public void addAtIndex(int index, int val) 
    {
       Node node=new Node(val);
        if(index==0)
        {
            addAtHead(val);
            return;
        }
        if(head==null)
        {
            return;
        }
        Node temp=head;
        Node prev=null;
        int cnt=0;
        while(temp!=null && cnt!=index)
        {   
            prev=temp;
            temp=temp.next;
            cnt++;
        }
        if(cnt<index) return;
        prev.next=node;
        node.next=temp;
       
        return;
    }
    
    public void deleteAtIndex(int index) 
    {
        if(head==null)
        {
            return;
        }
        if(index==0)
        {
           Node temp=head;
            head=head.next;
            temp.next=null;
            return;
        }
        int cnt=0;
        Node temp=head;
        Node prev=null;
        while(temp!=null && cnt!=index)
        {
            prev=temp;
            temp=temp.next;
            cnt++;
        }
        if(cnt<index) return;
        if(temp==null) return;
        prev.next=temp.next;
        temp.next=null;

        return; 
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */