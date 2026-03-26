class Solution {
    private boolean isPossible(int[]nums,int k,long limit)
    {
        int count=0;
        long sum=0;
        for(int x:nums)
        {
            if(sum+x>limit)
            {
                count++;
                sum=x;
            }
            else
            {
                sum+=x;
            }
        }
        if(sum<=limit) count++;
        return count<=k;
        
    }
    public int splitArray(int[] nums, int k) 
    {
        long low=Integer.MIN_VALUE;
        long high=0;
        for(int x:nums)
        {
            if(low<x) low=x;
            high+=x;
        }
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(nums,k,mid))
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