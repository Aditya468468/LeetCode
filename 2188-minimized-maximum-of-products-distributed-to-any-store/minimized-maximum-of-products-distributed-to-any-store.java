class Solution 
{
    private boolean isPossible(int[]nums,int shop,long k)
    {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            count+=(nums[i]+k-1)/k;
            if(count>shop) return false;
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) 
    {
        long low=1;
        long high=Integer.MIN_VALUE;
        for(int x:quantities)
        {
            if(high<x) high=x;
        }
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(quantities,n,mid))
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