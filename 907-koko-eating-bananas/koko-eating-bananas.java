class Solution {
    private boolean isPossible(int[]nums,int h,long k)
    {
        int n=nums.length;
        long total=0;
        for(int i=0;i<n;i++)
        {
            long hrs=(nums[i]+k-1)/k;
            total+=hrs;
            if(total>h) return false; 
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) 
    {

        long low=1;
        long high=Integer.MIN_VALUE;
        for(int x:piles)
            if(x>high) high=x;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(piles,h,mid))
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