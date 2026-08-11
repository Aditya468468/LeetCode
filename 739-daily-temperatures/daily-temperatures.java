class Solution {
    public int[] dailyTemperatures(int[] nums) 
    {
        int n=nums.length;
        int []answer = new int[n];

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i])
            {
                int idx=st.pop();
                answer[idx]=i-idx;  // day=curr(IDX)-topIdx
            }
            st.push(i);
        }

        return answer;
        
    }
}