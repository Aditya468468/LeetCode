class Solution {

    private boolean isPossible(int []nums,int limit,long k)
    {
        long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            long value=(nums[i]+k-1)/k;
            sum+=value;
            if(sum>limit) return false;
        }

        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) 
    {
        long low=1;
        long high=Integer.MIN_VALUE;
        for(int x:nums) if(x>high) high=x;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(nums,threshold,mid))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        } 

        return (int)low;
        
    }
}