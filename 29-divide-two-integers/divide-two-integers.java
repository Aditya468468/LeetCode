class Solution {
    public int divide(int dividend, int divisor) 
    {
        if(dividend==divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isPositive=true;
        if((dividend<0 && divisor>=0) || (dividend>=0 && divisor<0)) 
        {
            isPositive=false;
        }
        if(divisor==1) return dividend;
        // Pos-> 2^31 - 1 and neg-> 2^32 soo thats why
        int ans=0;
        long n=dividend;
        long d=divisor;
        n=Math.abs(n);
        d=Math.abs(d);
        while(n>=d)
        {
            int cnt=0;
            while((d<<(cnt+1))<=n)
            {
                cnt++;
            }
            
            ans+=(1<<cnt);
            n-=(d<<cnt);
            
        }
    
        if(ans>Integer.MAX_VALUE)
        {
            if(isPositive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        if(!isPositive) return -1*ans;
        return ans;

    }
}