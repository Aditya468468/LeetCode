class Solution {
    public boolean validMountainArray(int[] nums) 
    {
        
        int idx=-1;
        int n=nums.length;
        if(n<3) return false;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]==nums[i])
            {
                return false;
            }
            if(nums[i-1]>nums[i])
            {
                idx=i-1;
                break;
            }
        }
        if(idx<=0) return false;
        //after peak all should decrease.
        for(int i=idx+1;i<n;i++)
        {
            if(nums[i-1]<=nums[i]) return false;
        }
           
        return true;

    }
}
