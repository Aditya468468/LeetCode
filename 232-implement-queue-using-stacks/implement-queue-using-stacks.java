class MyQueue 
{
    Stack<Integer> s;
  
    // stack works in LIFO-> insert at End
    // Remove from end.
    //Lets Map with queue
    // Insert at End->Rear-> same as Stack
    // Remove from Front-> Opposite of Stack-> we can emit same behaviour if we reverse it.


    public MyQueue() 
    {
        s=new Stack<>(); 
    }
    
    public void push(int x) 
    {
       Stack<Integer> temp=new Stack<>();
       while(!s.isEmpty())
       {
            temp.add(s.pop());
       }
       temp.add(x);
       while(!temp.isEmpty())
       {
            s.push(temp.pop());
       }

    }
    
    public int pop() 
    {
        if(s.isEmpty()) return -1;

        return s.pop();

        
    }
    
    public int peek() 
    {

         if(s.isEmpty()) return -1;
         return s.peek();
    }
    
    public boolean empty() 
    {
        return s.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */