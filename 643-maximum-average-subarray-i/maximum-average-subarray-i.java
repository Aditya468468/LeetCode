class Solution {
    public double findMaxAverage(int[] nums, int k) 
    {
        int n=nums.length;
        double maxAvg=Double.NEGATIVE_INFINITY;
        // Its a fixed size wind prblm
        int left=0;
        double sum=0;  // Avg=(TotalSum/k)
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];
            while(right-left+1>k)
            {
                sum-=nums[left];
                left++;
            }
            if(right-left+1==k)
            {
                maxAvg=Math.max(maxAvg,sum/k);
            }

        }

        return maxAvg;
        
    }
}