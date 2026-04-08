class Solution {

    static final long MOD=1_000_000_007;
    public long pow(long x,int n) // x^n
    {
        if(n==0) return 1;
        if(n%2==0)
        {
            return (pow((x*x)%MOD,n/2))%MOD;
        }
        else 
        {
            return (x*pow(x,n-1))%MOD;
        }

    }
    public int monkeyMove(int n) 
    {
        // Instead of Calculating -> Atleast one collison.(More also counted).
        //Lets find Total=(Collison)+(Safe);
        //Safe-> When all goes CW or All Go ACW-> 2 ways.
        // And Total-> Each vertex has a choice of ACW or CW-> 2^n
        // Sooo-> Collison=Total-Safe-> 2^n-2;

        return (int)((pow(2, n)-2+MOD)%MOD);


        
    }
}