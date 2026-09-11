class Solution {
    public int sumSubarrayMins(int[] nums) 
    {
        int n=nums.length;
        int[]nsE=new int[n];
        int[]pseE=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
            {
                nsE[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nsE[st.pop()]=n;
        }
        //prevSmallerOrEqual
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])
            {
                pseE[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            pseE[st.pop()]=-1;
        }
        long sum=0;
        long MOD=1_000_000_007;
        for(int i=0;i<n;i++)
        {
            long contri=((1L)*(nums[i])*((nsE[i]-i)*(i-pseE[i])))%MOD;
            sum+=(contri)%MOD;
        }

        return (int)(sum%MOD);
   
    }
}
