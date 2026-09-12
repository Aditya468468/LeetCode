class Solution {
    public int[] mostCompetitive(int[] nums, int k) 
    {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++)
        {
            //We need k elements at last, Soo its a strict Constraint which is there by the question, While maintaing the Mono-stack, we should make k elemets at last for sure
            int remain=(n-i); // These many elements can be added.
            while(!st.isEmpty() && k-st.size()<remain && st.peek()> nums[i])
            {
                st.pop();
            }
            if(st.size()<k)
            {
                st.push(nums[i]);
            }
        }

        int []ans=new int[k];
        int idx=k-1;
        while(!st.isEmpty())
        {
            ans[idx]=st.pop();
            idx--;
        }

        return ans;
        
    }
}