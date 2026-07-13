class Solution {
    public int jump(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return 0;
        int minJumps=0;
        int curr=0;
        int maxReach=nums[0];
        while(curr<nums.length-1)
        {
            if(curr+nums[curr] >= n-1) return minJumps + 1; //Direct
            int max=-1;
            int bestIdx=-1;
            for(int i=curr+1;i<=Math.min(maxReach,n-1);i++)
            {
                if(max<i+nums[i])
                {
                    bestIdx=i;
                    max=i+nums[i];
                }
            }
            if (bestIdx == -1) return -1;
            curr=bestIdx;
            maxReach=max;
            minJumps++;
        }

        return minJumps;
    }
}