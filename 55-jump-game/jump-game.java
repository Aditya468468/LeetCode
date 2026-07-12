class Solution {
    public boolean canJump(int[] nums) 
    {
        int maxFar=0;
    
        for(int i=0;i<nums.length;i++)
        {
            if(maxFar<i) return false; // we cant reach here.
            maxFar=Math.max(i+nums[i],maxFar);
            if(maxFar>=nums.length-1) return true;
        }

        return false;
        
    }
}