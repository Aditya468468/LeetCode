class Solution {
    public String removeDuplicates(String s) 
    {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(!st.isEmpty() && st.peek()==s.charAt(i))
            {
                st.pop();
            }
            else 
            {
                st.push(c);
            }
        }

        StringBuilder str=new StringBuilder();
        for(char x:st)
        {
            str.append(x);
        }

        return str.toString();
        
    }
}