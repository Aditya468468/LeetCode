
class Node
{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key,int value)
    {
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
}

class LRUCache 
{
    Node head;
    Node tail;
    int capacity;
    int size;
    Map<Integer,Node> map;

    public LRUCache(int capacity) 
    {
        this.head=null;
        this.tail=head;
        this.capacity=capacity;
        this.size=0;
        map=new HashMap<>();
    }

    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            Node currNode=map.get(key);
            int value=currNode.value;
            //We have the node with us
            //We have a single Element
            if(head.next==null)
            {
                //No need to change or LL seq
                return currNode.value;
            }
            if(currNode==tail) 
            {
                // already MRU
                return currNode.value;
            }
            if(currNode==head) //Updating head
            {
                head = head.next;
                head.prev = null;
                tail.next=currNode;
                currNode.prev=tail;
                tail=currNode;
                currNode.next = null;
            }
            // We have more than 1 element
            else
            {
                Node prevNode=currNode.prev;
                Node nextNode=currNode.next;
                prevNode.next=nextNode;
                nextNode.prev=prevNode;
                currNode.next=null;
                currNode.prev=null;
                //Isolating
                currNode.prev=tail;
                tail.next=currNode;
                tail=currNode;
            }

            return value;

        }
        else
        {
            return -1;
        }
       
    }
    public void put(int key, int value) 
    {
        Node newNode=new Node(key,value); //Insertion 
        if(!map.containsKey(key))
        {
            if(capacity==size)
            {
                //Evict
                Node LRUNode=head; //Head will have LRUNode
                if(head==tail) //One Element
                {
                    head=null;
                    tail=null;
                }
                else
                {
                    head=head.next;//Moved DLL
                    head.prev=null;
                }
                map.remove(LRUNode.key); //Removed the key from Map
                size--;//Now we have size 
            }
            if(head==null)
            {
                head=newNode;
                tail=newNode;
            }
            else
            {
                newNode.prev=tail;
                tail.next=newNode;
                tail=newNode;
            }
            map.put(key,newNode);
            size++;
        }
        else
        {
            //We already have it, We need not put again we just update the MRU step
            Node currNode=map.get(key);
            currNode.value = value;
            //We have the node with us
            //We have a single Element
            if(head.next==null)
            {
                //No need to change or LL seq as we have single Node
                return;
            }
            if(tail==currNode)
            {
                return; // already a MRU
            }
            if(currNode==head) //Updating head
            {
                head = head.next;
                head.prev = null;
                tail.next=currNode;
                currNode.prev=tail;
                tail=currNode;
                currNode.next = null;
            }
            else // We have more than 1 element
            {
                Node prevNode=currNode.prev;
                Node nextNode=currNode.next;
                prevNode.next=nextNode;
                nextNode.prev=prevNode;
                currNode.next=null;
                currNode.prev=null;
                //Isolating
                currNode.prev=tail;
                tail.next=currNode;
                tail=currNode;
            }

        }
    }

}