class Solution {
    private boolean canDistribute(int[]candies,long k,long mid)
    {
        long cnt=0;
        for(int i=0;i<candies.length;i++)
        {
            long x=candies[i]/mid;
            cnt+=x;
            if(cnt>=k) return true;
    
        }

        return false;
    }
    public int maximumCandies(int[] candies, long k) 
    {
        if(candies.length==0) return 0;
        long low=1;
        long high=-1;
        for(int x:candies)
        {
            if(x>high) high=x;
        }

        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canDistribute(candies,k,mid))
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return (int)high;
        
    }
}