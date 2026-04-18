
class Solution {

    static class Pair
    {
        char ch;
        int cnt;
        public Pair(char ch,int cnt)
        {
            this.ch=ch;
            this.cnt=cnt;
        }

    }  
    public String removeDuplicates(String s, int k) 
    {
        Stack<Pair> st=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!st.isEmpty() && st.peek().ch==c)
            {
                st.peek().cnt++;
                if(st.peek().cnt==k)
                {
                    st.pop();
                }
            }
            else 
            {
                st.push(new Pair(c,1));
            }
        }

        StringBuilder str=new StringBuilder();
    
        for(Pair p:st)
        {
            for(int i=0;i<p.cnt;i++)
            {
                str.append(p.ch);
            }
        }
        return str.toString();
        
    }
}