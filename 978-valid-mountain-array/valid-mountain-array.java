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
        if(idx<=0) return false;// peak cant be the nums [0] ans there should be
        //both parts-> strict inc-peak- strict dec.. exp-> [3,2,1] ->peak=nums[0] but mountain  doesnt have a inc part

        //after peak all should decrease.
        for(int i=idx+1;i<n;i++)
        {
            if(nums[i-1]<=nums[i]) return false;
        }
           
        return true;

    }
}
