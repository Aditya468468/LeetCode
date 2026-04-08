class Solution {

    static final int MOD = 1337;

    public int pow(int a,int n)
    {
        if(n==0) return 1;
        a%=MOD;
        if(n%2==0)
        {
            return (pow(a*a,n/2)%MOD);
        }
        else
        {
            return (a*pow(a,n-1))%MOD;
        }
    }
    public int helper(int a,int[]b,int idx)
    {
        if(idx<0) return 1; 
        int last=b[idx];
        int right=pow(a,last);
        int left=pow(helper(a,b,idx-1),10);
        
        return (right*left)%MOD;

    }
    public int superPow(int a, int[] b) 
    {
        return helper(a%MOD,b,b.length-1);
    }
}