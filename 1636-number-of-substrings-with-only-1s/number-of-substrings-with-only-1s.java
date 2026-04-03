class Solution {
    public int numSub(String s) 
    {
        char[]nums=s.toCharArray();
        int n=nums.length;
        long len=0;
        long cnt=0;
        long MOD=1_000_000_007;
        for(int i=0;i<n;i++)
        {
            if(nums[i]=='1')
            {
                len++;
            }
            else 
            {
                cnt+=(len)*(len+1)/2;
                len=0;
            }
        }
        cnt+=(len)*(len+1)/2;
        return (int)(cnt%MOD);

        
    }
}