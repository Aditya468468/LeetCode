class Solution {
    public int count(int n,int m,long x)
    {
        int cnt=0;
        for(int i=1;i<=n;i++)
        {
            int low=0;
            int high=m-1;
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                int value=i*(mid+1);
                if(value<=x)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            cnt+=low;
        }
        return cnt;
    }
    public int findKthNumber(int n, int m, int k) 
    {
        long low=1;
        long high=m*n;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            int cnt=count(n,m,mid);
            if(cnt<k)
            {
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }
        }
        
    

    return (int)low;
    }
}