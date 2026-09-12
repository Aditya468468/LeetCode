class Solution {
    public int monotoneIncreasingDigits(int n) 
    {
        StringBuilder num=new StringBuilder(Integer.toString(n));
        if(num.length()==1) return n;
        Stack<Integer> st=new Stack<>(); // Will store the Index
        st.push(num.length()-1); // Last Idx

        
        for(int i=num.length()-2;i>=0;i--)
        {
            int y=num.charAt(i+1)-'0';
            int x=num.charAt(i)-'0';
            if(x>y)
            {
                while(!st.isEmpty() && x>y)
                {
                    num.setCharAt(st.pop(),'9');
                }
                num.setCharAt(i,(char)(x-1+'0'));

            }
            st.push(i);
            
        }

       int i=0;
       while(num.charAt(i)=='0') // removing leading Zero
       {
            i++;
       }



        return Integer.parseInt(num.substring(i));
        
    }
}