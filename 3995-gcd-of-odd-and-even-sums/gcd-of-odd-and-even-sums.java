class Solution 
{
    public int gcd(int a,int b)
    {
        while(a!=0 && b!=0)
        {
            if(a>b)
            {
                a=a%b;
            }
            else
            {
                b=b%a;
            }
        }
        if(a==0)return b;
        return a;
    }
    public int gcdOfOddEvenSums(int n) 
    {
        int sumEven=n*(n+1);
        int sumOdd=n*n ; 
        return gcd(sumOdd,sumEven);
        
    }
}