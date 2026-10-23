class Solution {
    public int minDeletions(int[] nums) 
    {
        int ans=0;
        for(int i=1;i<nums.length;i++)
        {
            int x=nums[i-1];
            int y=nums[i];
            if(x==y) ans++;
        }

        return ans;
        
    }
}