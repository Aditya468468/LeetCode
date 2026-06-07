class Solution 
{
    static int MOD=1_000_000_007;
    private long pow(long n,long x)
    {
        if(x==0) return 1;
        if(x==1) return n;
        if(x%2==0)
        {
            return pow((n*n)%MOD,x/2)%MOD;
        }
        else 
        {
            return n*pow((n*n)%MOD,x/2)%MOD;
        }

    }
    public int monkeyMove(int n) 
    {
        int MOD=1_000_000_007;
        return (int)(pow(2L,n)-2+MOD)%MOD;
    }
}