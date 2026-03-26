class Solution {
    public boolean check(int[] nums) 
    {
        int dip=0;
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]>nums[i])
            {
                dip++;
            }
        }
        if(nums[0]<nums[n-1]) dip++;
        return dip<=1;
        
    }
}