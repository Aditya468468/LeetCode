class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) 
    {
        int n=nums.length;
        long cnt=0;
        double sum=0;
        int left=0;
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];
            if(right-left+1>k)
            {
                sum-=nums[left];
                left++;
            }
            if(right-left+1==k)
            {
                //double avg=sum/k;
                if(sum>=threshold*k) cnt++;
            }
        }
        return (int)cnt;
        
    }
}