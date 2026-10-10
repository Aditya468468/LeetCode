class Pair
{
    char ch;
    int state;
    public Pair(char ch,int state)
    {
        this.ch=ch;
        this.state=state;
    }
}
class Solution 
{
    public String removeOuterParentheses(String s) 
    {

        Stack<Pair> st=new Stack<>();
        StringBuilder str=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                if(!st.isEmpty())
                {
                    str.append('(');
                    int value=st.peek().state;
                    st.push(new Pair('(',value+1));
                }
                else
                {
                    st.push(new Pair('(',1));
                }
            }
            else
            {
                if(!st.isEmpty())
                {
                 
                    int state=st.peek().state;
                    st.pop();
                    if(state!=1)
                    {
            
                        str.append(')');
                    }
                }
            }
        }


        return str.toString();
        
        
    
        
    }
}