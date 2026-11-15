class Solution {
    public int numOfSubarrays(int[] nums) 
    {
        long MOD=1000_000_007;
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        long cnt=0;
        long preSum=0;

        for(int i=0;i<n;i++)
        {
            preSum+=nums[i];
            int state=(int)(preSum%2);

            cnt+=map.getOrDefault(state,0);

            map.put(state,map.getOrDefault(state,0)+1);
        }

        long totalSub=(1L*n*(n+1)/2);

        return (int)((totalSub-cnt+MOD)%MOD);
        
    }
}