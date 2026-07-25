class Solution {
    public int maxProduct(int n) 
    {
        int max=Integer.MIN_VALUE;
        int smax=Integer.MIN_VALUE;

        while(n!=0)
        {
            int ld=n%10;
            if(max<ld)
            {
                smax=max;
                max=ld;
            }
            else if(smax<ld)
            {
                smax=ld;
            }
            n=n/10;
        }

        return max*smax;
        
    }
}