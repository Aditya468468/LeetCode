class MyStack 
{
    Queue<Integer> q;

    public MyStack() 
    {
        q=new LinkedList<>();
        
    }
    
    public void push(int x) 
    {
        q.offer(x); // Add to the last -> Last In
        
    }
    
    public int pop() 
    {
        if(q.isEmpty())
        {
            return -1;
        }
        //q.poll() // Removes from First-> Not a stack 
        int n=q.size();
        Queue<Integer> temp=new LinkedList<>();
        for(int i=0;i<n-1;i++)
        {
            temp.offer(q.poll());
        }

        int element=q.poll(); //Last element.
        q=temp;

        return element;
       
    }

    public int top() 
    {
        if(q.isEmpty())
        {
            return -1;
        }

        int n=q.size();
        Queue<Integer> temp=new LinkedList<>();
        for(int i=0;i<n-1;i++)
        {
            temp.offer(q.poll());
        }

        int element=q.peek();
        temp.offer(q.poll());

        q=temp;
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