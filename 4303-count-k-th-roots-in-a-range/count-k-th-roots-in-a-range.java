class Solution 
{
    public long pow(long x,int k,long lim)
    {
        if(x==0) return 0;
        if(k==0) return 1;
        long half=pow(x,k/2,lim);
        if(half>lim) return lim+1;
        long res=half*half;
        if(res>lim) return lim+1;
        if(k%2==1)
        {
            if(res>lim/x) return lim+1;
            res*=x;
           
        }

        return res;
        
    }
    public int countKthRoots(int l, int r, int k) 
    {
        long low=0;
        long high=r;
        long left=-1;
        while(low<=high)
            {
                long mid=low+(high-low)/2;
                long val=pow(mid,k,r);
                if(val>=l)
                {
                    left=mid;
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
        low=0;
        high=r;
        long right=-1;
        while(low<=high)
            {
                long mid=low+(high-low)/2;
                long val=pow(mid,k,r);
                if(val<=r)
                {
                    right=mid;
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }

        return (int)Math.max(0,(right-left+1));
        
    }
}