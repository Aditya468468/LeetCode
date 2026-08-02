class Solution {
    public int longestOnes(int[] nums, int k) 
    {
        int maxLen=0;
        int countZero=0;
        int left=0;
        int n=nums.length;

        for(int right=0;right<n;right++)
        {
            if(nums[right]==0) countZero++;

            while(countZero>k)
            {
                if(nums[left]==0)
                {
                    countZero--;
                }
                left++;
            }
            int len=right-left+1;
            maxLen=Math.max(maxLen,len);
        }

        return maxLen;

        
    }
}