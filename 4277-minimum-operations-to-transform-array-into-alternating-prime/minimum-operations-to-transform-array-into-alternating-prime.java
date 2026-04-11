class Solution 
{
    private boolean isPrime(int n)
    {
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }

        }
        return true;
    }
    public int minOperations(int[] nums) 
    {
        int n=nums.length;
        int ops=0;
        //even-Prime, odd-> NotPrime
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                while(!isPrime(nums[i]))
                {
                    nums[i]++;
                    ops++;
                }
            }
            else 
            {
                 while(isPrime(nums[i]))
                {
                    nums[i]++;
                    ops++;
                }
                
            }
        }

        return ops;

        
    }
}