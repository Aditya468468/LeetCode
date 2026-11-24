class Solution 
{
    public long gcd(long a, long b)
    {
        while(a!=0 && b!=0)
        {
            if(a<b)
            {
                b=b%a;
            }
            else 
            {
                a=a%b;
            }
        }
        if(a==0) return b;
        return a;
    }
    
    public long lcm(long a,long b)
    {
        long g=gcd(a,b);
        return (a/g)*b;
    }
    public int maxLength(int[] nums) 
    {
        int maxLen=Integer.MIN_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            int prod=nums[i];
            long curGcd=nums[i];
            long curLcm=nums[i];

            for(int j=i+1;j<n;j++)
            {
                prod*=nums[j];

                curGcd=gcd(curGcd,nums[j]);
                curLcm=lcm(curLcm,nums[j]);

                if(prod==curGcd*curLcm)
                {
                   maxLen=Math.max(maxLen,j-i+1);
                }
              
            }
        }


        return maxLen;

        
    }
}