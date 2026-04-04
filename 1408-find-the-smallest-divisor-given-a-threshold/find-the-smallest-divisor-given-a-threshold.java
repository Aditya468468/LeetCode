class Solution 
{   // Feasibilty.
    private boolean canDivide(int[]nums,int limit,long k)
    {
        long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum+=(nums[i]+k-1)/k;
            if(sum>limit) return false;
        }

        return true;

    }

    public int smallestDivisor(int[] nums, int limit) 
    {
        long low=1;
        long high=Integer.MIN_VALUE;
        for(int x:nums)
        {
            if(high<x) high=x;
        }
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canDivide(nums,limit,mid))
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