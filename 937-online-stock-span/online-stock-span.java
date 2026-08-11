class Pair
{
    int price;
    int spam;
    public Pair(int price,int spam)
    {
        this.price = price;
        this.spam=spam;
    }
}
class StockSpanner 
{
    private Stack<Pair> st;

    public StockSpanner() 
    {
        st=new Stack<>();
        
    }
    
    public int next(int price) 
    {
        int spam=1;

        while(!st.isEmpty() && st.peek().price<=price)
        {
            spam+=st.pop().spam;
        }

        st.push(new Pair(price,spam));

        return spam;


        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */