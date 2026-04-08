class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) 
    {
        
        long MOD=1_000_000_007;
        int n=queries.length;
        for(int i=0;i<n;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];
            int k=queries[i][2];
            int v=queries[i][3];
            int idx=l;
            while(idx<nums.length && idx<=r)
            {
                nums[idx]=(int)((1L*nums[idx]*v)%MOD);
                idx+=k;
            }
        }
        int ans=0;
        for(int x:nums)
        {
            ans^=x;
        }
        
        return ans;

        
    }
}