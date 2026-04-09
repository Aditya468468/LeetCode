class Solution 
{
    private int count(int idx,int[]nums,int sum,int target)
    {
        if(idx==nums.length)
        {
            if(sum==target) return 1;
            else return 0;
        }
        int takePos=count(idx+1,nums,sum+nums[idx],target);
        int takeNeg=count(idx+1,nums,sum-nums[idx],target);
        return takePos+takeNeg; //combine
    }
    public int findTargetSumWays(int[] nums, int target) 
    {
        return count(0,nums,0,target);
        
    }
}