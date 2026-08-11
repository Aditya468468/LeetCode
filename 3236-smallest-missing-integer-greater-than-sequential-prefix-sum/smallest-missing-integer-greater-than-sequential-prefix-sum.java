class Solution {
    public int missingInteger(int[] nums) 
    {
        int preSum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-1==nums[i-1])
            {
                preSum+=nums[i];
            }
            else
            {
                break; // nums[0]......nums[i]
            } 
        }

        Set<Integer> set=new HashSet<>();
        for(int x:nums)
        {
            set.add(x);
        }

        int x=preSum;
        while(true)
        {
            if(!set.contains(x)) return x;
            x++;
        }
        
        
    }
}