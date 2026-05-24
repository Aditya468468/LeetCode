class Solution {
    public int[] limitOccurrences(int[] nums, int k) 
    {
        int n=nums.length;
        int prev=nums[0];
        int idx=1;
        int cnt=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]!=prev)
            {
                cnt=1;
                prev=nums[i];
            }
            else 
            {
                cnt++;
            }
            if(cnt<=k)
            {
                nums[idx++]=nums[i];
            }
        }

        return Arrays.copyOf(nums, idx);
        
        
    }
}