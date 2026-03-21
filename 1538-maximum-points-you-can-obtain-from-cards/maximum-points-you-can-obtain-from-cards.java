class Solution {
    public int maxScore(int[] nums, int k) 
    {
        int n=nums.length;
        int totalSum=0;
        for(int x:nums) totalSum+=x;
        int sum=0;
        int min=Integer.MAX_VALUE;
        int left=0;
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];
            while(right-left+1>n-k)
            {
                sum-=nums[left];
                left++;
            }
            if(right-left+1==n-k)
            {
                if(sum<min) min=sum;
            }
            
        }

        return totalSum-min;

        
    }
}