class Solution {

   long MOD=1_000_000_007;

    private long moves(long x,long n)
    {
        if(n==0) return 1;
        if(n%2==0) return moves((x*x)%MOD,n/2)%MOD;
        else return (x*moves(x,n-1))%MOD;
    }
    public int monkeyMove(int n) 
    {
    
        //return (int)(moves(2,n)-2);
        return (int)((moves(2,n)-2+MOD)%MOD);
        
        
    }
}