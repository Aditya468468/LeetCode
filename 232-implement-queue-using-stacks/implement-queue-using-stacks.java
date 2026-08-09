class MyQueue 
{
    Stack<Integer> st;
    int frontElem;

    public MyQueue() 
    {
        st=new Stack<>();
        frontElem=-1;
        
    }

    public void push(int x) 
    {
        if(st.isEmpty())
        {
            frontElem=x;
        }
         st.push(x);
    }

    public int pop() 
    {
        if(st.empty()) return -1;
        Stack<Integer> temp = new Stack<>();
        int size=st.size();
        for(int i=0;i<size-1;i++)
        {
            frontElem=st.pop();
            temp.push(frontElem);
        }

        int elem=st.pop();
        while(!temp.isEmpty())
        {
            int top=temp.pop();
            st.push(top);
        }

        if(st.empty())
        {
            frontElem=-1;
        }

        return elem;
      
    }

    public int peek() 
    {
        if(st.empty()) return -1;

        return frontElem;
        
    }

    public boolean empty() 
    {
       return st.isEmpty();
    }
}
