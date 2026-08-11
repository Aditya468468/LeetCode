class Solution {
    public int[] nextGreaterElements(int[] arr) 
    {
        int n=arr.length;
        int[]ngE=new int[n];
        Arrays.fill(ngE,-1);
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<2*n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]<arr[i%n])
            {
                ngE[st.pop()]=arr[i%n];
            }
            if(ngE[i%n]==-1) // If Not resolved, then only we push.
            {
                st.push(i%n);
            }
        }

        return ngE;

   
    }
}
