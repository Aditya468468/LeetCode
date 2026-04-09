class Solution {
    //Fast Exponential Method
    private double pow(double x,long n)
    {
        if(n==0) return 1;
        if(n%2==0)
        {
            return pow(x*x,n/2);
        }
        else
        {
            return x*pow(x,n-1);
        }
    }
    public double myPow(double x, int n) 
    {
        long N=n;
        if(N<0)
        {
            x=1/x;
            N=(-1L)*N;
        }
        
        return pow(x,N);
        
    }
}