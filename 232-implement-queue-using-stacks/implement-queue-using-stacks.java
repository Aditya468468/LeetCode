class MyQueue 
{
    Stack<Integer> s1; //used for enqueue
    Stack<Integer> s2; //used for Dequeue
    int frontElem;

    public MyQueue() 
    {
        s1=new Stack<>();
        s2=new Stack<>();
        
    }

    public void push(int x) 
    {
       s1.push(x);
    }

    public int pop() 
    {
       if(s2.isEmpty())
       {
          while(!s1.isEmpty())
          {
            s2.push(s1.pop());
          }
       }
        if(s2.isEmpty()) return -1; //There was no prior enqueue
        
        return s2.pop();
    }

    public int peek() 
    {
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
            
        } 
        if(s2.isEmpty()) return -1; //There was no prior enqueue

        return s2.peek();
        
    }

    public boolean empty() 
    {
       return s1.isEmpty() && s2.isEmpty(); //Both is Empty 
    }
}
