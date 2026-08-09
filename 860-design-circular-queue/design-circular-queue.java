class MyCircularQueue 
{

    int[]queue;
    int capacity;
    int front;
    int rear;
    int currSize;
    public MyCircularQueue(int k) 
    {
        queue=new int[k];
        capacity=k;
        rear=-1;
        front=-1;
        currSize=0;
    }
    
    public boolean enQueue(int value) 
    {
        if(isFull())
        {
            return false;
        }
        if(front==-1) // First insertion
        {
            front=0;
        }
        rear=(rear+1)%capacity;
        queue[rear]=value;
        currSize++;
        return true;

        
    }
    
    public boolean deQueue() 
    {
        if(isEmpty())
        {
            return false;
        }
        if(currSize==1) // Last element
        {
            front=-1;
            rear=-1;   // Queue becomes empty, Reset Pointers
        }
        else
        {
            front=(front+1)%capacity;
        }
        currSize--;

        return true;
        
    }
    
    public int Front() 
    {
        if(isEmpty())
        {
            return -1;
        }
        return queue[front];
        
    }
    
    public int Rear() 
    {
         if(isEmpty())
        {
            return -1;
        }
        return queue[rear];
        
    }
    
    public boolean isEmpty() 
    {
        if(currSize==0)
        {
            return true;
        }
        return false;
        
    }
    
    public boolean isFull() 
    {
        if(currSize==capacity)
        {
            return true;
        }

        return false;
        
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */