class Solution 
{
    public int smallestNumber(int n, int t) 
    {

        while(true)
        {
            int temp=n;
            boolean flag=true;
            long product=1;
            while(temp!=0)
            {
                int ld=temp%10;
                product*=(ld*(1L));
                temp/=10;
            }
            if(product%t==0) return n;
            n=n+1;
        }

        
    }
}