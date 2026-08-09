class MyStack 
{
    Queue<Integer> q;
    int topElem;

    public MyStack() 
    {
        q=new LinkedList<>();
        topElem=-1;
        
    }
    
    public void push(int x)  //O(1)
    {
        q.offer(x); // Add to the last -> Last In
        topElem=x;
        
    }
    
    public int pop()  // O(n)
    {
        if(q.isEmpty())
        {
            return -1;
        }
        //q.poll() // Removes from First-> Not a stack 
       
        for(int i=0;i<q.size()-1;i++)
        {
            topElem=q.poll(); // Keep Updating the topElem throughout the cycle
            q.offer(topElem);
        }
        // After Cycle the 2nd last Elem -> New TopElem
        int element=q.poll(); //Last element.

        return element;
       
    }

    public int top() // O(1)
    {
        if(q.isEmpty())
        {
            return -1;
        }

        return topElem;
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