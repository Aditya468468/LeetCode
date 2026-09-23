class Solution {
    public int minOperations(int[] nums, int x) 
    {
        //Maximum subarray with sum equal to ==Total-x
        // similar to Maximum Cards to Obtain Ques
        //Can be solved with presum+ HashMaps
        //Lets try Sliding window--> sum< need--> inc the sum, if sum>k--> dec the sum, if ==k capture the length
       


       
        int totalSum=0;
        int n=nums.length;

        for(int num:nums)
        {
            totalSum+=num;
        }

        int k=totalSum-x;
        if(k<0) return -1;
        if (k==0) return n;
        int maxLen=Integer.MIN_VALUE;
        int sum=0;
        int left=0;
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];

            while(sum>k)
            {
                sum-=nums[left];
                left++;
            }

            if(sum==k) 
            {
                int len=right-left+1;
                maxLen=Math.max(maxLen,len);
            }

        }
        
        if(maxLen==Integer.MIN_VALUE) return -1;
        return n-maxLen;

        
        
    }
}