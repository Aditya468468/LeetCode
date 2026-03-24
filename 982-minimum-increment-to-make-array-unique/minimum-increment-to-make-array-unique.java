class Solution {
    public int minIncrementForUnique(int[] nums) 
    { 
        HashSet<Integer> set=new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]<=nums[i-1])
            {
                int need=nums[i-1]+1;
                ans+=need-nums[i];
                nums[i]=need;
            }

        }
        return ans;
    }
}