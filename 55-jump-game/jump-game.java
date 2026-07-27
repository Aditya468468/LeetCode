class Solution {
    public boolean canJump(int[] nums) 
    {
        int maxReach=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(i>maxReach) return false;//Can i even reach that idx?? If not return false
            int reach=i+nums[i];
            maxReach=Math.max(maxReach,reach); //Update
            if(maxReach>=n-1) return true; // We crossed the line , Vamos 
        }


        return true;
       
    }
}