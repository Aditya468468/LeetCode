
class Pair
{
    long element;
    long min_at_level;
    public Pair(long element,long min_at_level)
    {
        this.element=element;
        this.min_at_level=min_at_level;

    }
}
class MinStack 
{

    private Stack<Pair> st;
    // The Stack will store elem and min_at that level,
    //instead of storing min_elem history just store min at that level and
    //consider each level as its own, pop -> removes level, push-> Adds that level

    public MinStack() 
    {
        st=new Stack<>();
    }
    
    public void push(int value) 
    {

        if(st.isEmpty())
        {
            st.push(new Pair(value,value));
        }
        else
        {
            if(value<st.peek().min_at_level)
            {
                st.push(new Pair(value,value));
            }
            else
            {
                 st.push(new Pair(value,st.peek().min_at_level));
            }
        }        
    }
    
    public void pop() 
    {
        st.pop();
    }
    
    public int top() 
    {
        return (int)(st.peek().element);
        
    }
    
    public int getMin() 
    {
        return (int)(st.peek().min_at_level);
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */