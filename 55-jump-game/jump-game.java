class Solution {
    public boolean canJump(int[] nums) 
    {
        int maxFar=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(i>maxFar) return false;  // Validate
            maxFar=Math.max(maxFar,i+nums[i]); //Update
            if(maxFar>=nums.length-1) return true; //Check
        }
        return true ; // Dummy
        
    }
}