class MyStack 
{
    Queue<Integer> q;

    public MyStack() 
    {
        q=new LinkedList<>();   
    }
    
    public void push(int x) //O(N)
    {
        q.offer(x); 
        for(int i=0;i<q.size()-1;i++)
        {
            q.offer(q.poll());
        }

    }
    
    public int pop()  //O(1)
    {
        if(q.isEmpty())
        {
            return -1;
        }
    
        int element=q.poll(); 
        return element;
       
    }

    public int top()  //O(1)
    {
        if(q.isEmpty())
        {
            return -1;
        }

        int element=q.peek();
        return element;
        
    }
    
    public boolean empty() 
    {
        return q.isEmpty();   
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */