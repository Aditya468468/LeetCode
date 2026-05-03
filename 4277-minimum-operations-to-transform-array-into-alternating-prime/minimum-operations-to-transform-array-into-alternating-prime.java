class Solution {
    private boolean isPrime(int x )
    {
        if(x < 2) return false;
        for(int i=2;i*i<=x;i++)
        {
            if(x%i==0) return false;
        }
        return true;
    }
    public int minOperations(int[] nums) 
    {
        int ops=0;
        int n=nums.length;
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