class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {

        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int[]ans=new int[n-k+1];
        
        int left=0;

        for(int right=0;right<n;right++)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[right])
            {
                dq.pollLast();
            }
            dq.offer(right);

            if(dq.peekFirst()<right-k+1)
            {
                dq.pollFirst();
            }

            if(right>=k-1)
            {
                ans[right-k+1]=nums[dq.peekFirst()];
            }
        }

        return ans;
        
    }
}