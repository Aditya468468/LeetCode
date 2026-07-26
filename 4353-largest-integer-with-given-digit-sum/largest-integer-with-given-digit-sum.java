class Solution 
{
    public int sumOfDigits(int n)
    {
        int sum=0;
        while(n!=0)
            {
                sum+=n%10;
                n=n/10;
            }
        return sum;
    }
    public int largestInteger(int n, int s) 
    {
        
   
        int high=(int)Math.pow(10,n);
        for(int i=high-1;i>=0;i--)
            {
                int sum=sumOfDigits(i);
                if(sum==s)
                {
                    return i;
                }
            }

        return -1;
        
    }
}