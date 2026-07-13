class Solution {
    public int jump(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return 0;
        int minJumps=0;
        int endPoint=0;
        int maxReach=0;
    
        for(int i=0;i<n-1;i++)
        {
            maxReach=Math.max(nums[i]+i,maxReach);
            if(i==endPoint)
            {
                endPoint=maxReach;
                minJumps++;
                if (endPoint>=n-1) {
                    break;
                }
            }

        }

        return minJumps;
    }
}