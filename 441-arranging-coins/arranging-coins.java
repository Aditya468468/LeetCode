class Solution {
    public boolean canArrange(long x,int n)
    {
        long value=x*(x+1)/2;
        return value<=n;
    }
    public int arrangeCoins(int n) 
    {
        long low=1;
        long high=n;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canArrange(mid,n))
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