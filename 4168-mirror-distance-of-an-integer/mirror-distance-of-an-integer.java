class Solution 
{
    private int reverse(int n)
    {
        int rev=0;
        while(n!=0)
        {
            int ld=n%10;
            rev=(rev*10)+ld;
            n/=10;
        }

        return rev;
    }
    public int mirrorDistance(int n) 
    {
        int rev=reverse(n);

        return (int)Math.abs(n-rev);
        
    }
}