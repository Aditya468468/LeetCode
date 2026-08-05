
class Solution {
    public boolean isValid(String str) 
    {
        Stack<Character> st=new Stack<>();
        int n=str.length();
        for(int i=0;i<n;i++)
        {
            char ch=str.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{')
            {
                st.push(ch);
            }
            else
            {
                if(st.isEmpty()) return false;
                if(ch==')')
                {
                    if(st.peek()!='(') return false;
                } 
                else if(ch=='}') 
                {
                    if(st.peek()!='{') return false;
                }  
                else if(ch==']') 
                {
                  if(st.peek()!='[') return false;
                }
                st.pop();
            }

        }

        return st.isEmpty(); // (([{ -> Not balanced 

        
    }
}