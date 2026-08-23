class Solution 
{
    public List<Integer> factors(int n)
    {
        List<Integer> factors = new ArrayList<>();
        
        // Check for the smallest prime number 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        
        // Check odd numbers up to the square root of n
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        // If n is still greater than 2, the remaining n is prime
        if (n > 2) {
            factors.add(n);
        }
        
        return factors;
    }
    public int longestSubarray(int[] nums, int k) 
    {
        Map<Integer,List<Integer>> list=new HashMap<>();

        for(int x:nums)
        {
            if(!list.containsKey(x))
            {
                list.put(x,factors(x));
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        int left=0;
        int maxLen=0;
        for(int right=0;right<nums.length;right++)
        {
            List<Integer> fac=list.get(nums[right]);
            for(int x:fac)
            {
                map.put(x,map.getOrDefault(x,0)+1);
            }
            while(map.size()>k)
            {
                List<Integer> facts=list.get(nums[left]);
                for(int x:facts)
                {   
                    map.put(x,map.get(x)-1);
                    if(map.get(x)==0)
                    {
                        map.remove(x);
                    }
                }
                left++;   
            }
            maxLen=Math.max(maxLen,right-left+1);
        }


        return maxLen;

        
    }
}