class Solution 
{
    public long reverse(long num)
    {
        long rev=0;
        while(num!=0)
        {
            rev=(rev*10*1L)+num%10;
            num/=10;
        }
        return rev;
    }
    public long sumAndMultiply(int n) 
    {
        long rev=0;
        long sum=0;
        while(n!=0)
        {
            int ld=n%10;
            sum+=ld;
            if(ld!=0) rev=(rev*10*1L)+ld;
            n/=10;
        }
        long reversedNum=reverse(rev);

        return reversedNum*sum;
        
        
    }
}