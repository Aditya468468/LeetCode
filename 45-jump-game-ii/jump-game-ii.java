class Solution {
    public int jump(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return 0;
        int jumps=0;
        int maxSoFar=0;
        int currEnd=0;
        for(int i=0;i<n;i++)
        {
            if(currEnd>=n-1) break;
            maxSoFar=Math.max(maxSoFar,i+nums[i]);

            if(i==currEnd) //Done with the region
            {
                jumps++;
                currEnd=maxSoFar;
            }
        }       

        return jumps; 
    }
}