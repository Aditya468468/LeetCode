class Solution {
    public int minMoves2(int[] nums) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        int mid=n/2;
        int ref=nums[mid];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            cnt+=Math.abs(ref-nums[i]);
        }

        return cnt;
    

        
    }
}