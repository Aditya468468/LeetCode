class Solution {
    public int valueAfterKSeconds(int n, int k) 
    {
        int MOD=1_000_000_007;
        int[]nums=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=1;
        } //Creation 
        int x=1;
        while(x<=k)
        {
            for(int i=1;i<n;i++)
            {
                nums[i]=(nums[i]+nums[i-1])%MOD;
            }
            x++;
        }


        return (nums[n-1])%MOD;
        
    }
}