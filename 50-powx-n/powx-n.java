class Solution {

    private double pow(double x,long N)
    {
        if(N==0) return 1; // Base Case
        if(N%2==0) return pow(x*x,N/2);
        else return x*pow(x,N-1);
    }
    public double myPow(double x, int n) 
    {
        long N=n;
        if(N<0)
        {
            x=1/x;
            N=(-1)*N;
        }
        return pow(x,N);

        
    }
}