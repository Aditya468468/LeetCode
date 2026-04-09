class Solution 
{
    static final long MOD=1_000_000_007;
    private long pow(long n,long x)
    {
        if(x==0) return 1;
        if(x%2==0)
        {
           return (pow(((n*n)%MOD),x/2))%MOD;
        }
        else
        {
            return (n*pow(n,x-1))%MOD;
        }

    }
    public int countGoodNumbers(long n) 
    {
        long evenCount;
        long oddCount;
        if(n%2==0)
        {
            evenCount=n/2;
            oddCount=n/2;
        }
        else
        {
            evenCount=(n/2)+1;
            oddCount=n/2;
        }

        return (int)((pow(5,evenCount)*pow(4,oddCount))%MOD);
        
    }
}