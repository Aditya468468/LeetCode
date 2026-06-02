class Solution 
{

    private boolean isPrime(int x)
    {
        if (x<2) return false;
        for(int i=2;i*i<=x;i++)
        {
            if(x%i==0) return false;
        }

        return true;
    }
    public int distinctPrimeFactors(int[] nums) 
    {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            for(int j=1;j*j<=x;j++)
            {
                if(x%j==0)
                {
                    int fact1=j;
                    int fact2=x/j;
                    
                    if(isPrime(fact1))
                    {
                        set.add(fact1);
                    }
                    if(isPrime(fact2))
                    {
                        set.add(fact2);
                    }

                }
            }
        }

        return set.size();

        
    }
}