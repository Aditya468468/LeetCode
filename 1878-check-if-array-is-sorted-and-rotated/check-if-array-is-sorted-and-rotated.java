class Solution {
    public boolean check(int[] nums) 
    {
        int dip=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>nums[i])
            {
                dip++;
                if(dip>1) return false;
            }
        }
        if(nums[0]<nums[nums.length-1]) dip++;

        return dip<=1;
        
    }
}