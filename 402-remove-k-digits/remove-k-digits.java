class Solution {
    public String removeKdigits(String nums, int k) 
    {
        Stack<Integer> st=new Stack<>();
        int n=nums.length();
        for(int i=0;i<n;i++)
        {
            int digit=nums.charAt(i)-'0';
            while(!st.isEmpty() &&k>0 && st.peek()>digit)
            {
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(!st.isEmpty() && k>0) // 2,3,4,5,6
        {
            st.pop(); //We remove the last digits
            k--;
        }
        if(st.isEmpty()) return "0";

        StringBuilder str=new StringBuilder();
        while(!st.isEmpty())
        {
            str.append(st.pop());
        }

        while(str.length()>0 && str.charAt(str.length()-1)=='0')
        {
            str.deleteCharAt(str.length()-1);
        }

        if(str.length() == 0) return "0"; // Missed it initally
        str.reverse();


        return str.toString();
        


       
    }
}