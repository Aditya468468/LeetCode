class Solution 
{
    private double pow(double x,long n)
    {
        if(n==0) return 1;
        if(n==1) return x;
        if(n%2==0)
        {
            return pow(x*x,n/2);
        }
        else
        {
            return x*pow(x,n-1);
        }
    }
    public double myPow(double x, int N) 
    {
        long n=N;
        if(n==0) return 1;
        if(n<0)
        {
            n=(-1)*n;
            x=1/x;
        }
        return pow(x,n);
         
    }
}