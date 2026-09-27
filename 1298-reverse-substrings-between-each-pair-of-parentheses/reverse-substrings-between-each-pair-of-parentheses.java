class Solution {
    public String reverseParentheses(String s)
    {
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if(ch==')')
            {
                StringBuilder str=new StringBuilder();
                while(!st.isEmpty() && st.peek()!='(')
                {
                    str.append(st.pop());
                }
                //st.top=='(' so we pop that too
                st.pop();
                for(int j=0;j<str.length();j++)
                {
                    st.push(str.charAt(j));
                }
            }
            else
            {
                st.push(ch);
            }
        }
        StringBuilder ans=new StringBuilder();

        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }
        
        return ans.reverse().toString();
    }
}