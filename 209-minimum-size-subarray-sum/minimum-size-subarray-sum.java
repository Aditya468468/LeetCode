class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int n=nums.length;
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];
            while(sum>=target)
            {
                int len=right-left+1;
                if(len<minLen) minLen=len;
                sum-=nums[left];
                left++;

            }


        }
        if(minLen==Integer.MAX_VALUE) return 0;

        return minLen;


        
    }
}