class Solution {
    public int[] limitOccurrences(int[] nums, int k) 
    {
        int idx=0;
        int prev=-1;
        int cnt=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==prev)
            {
                cnt++;
            }
            else if(nums[i]!=prev)
            {
                prev=nums[i];
                cnt=1;
            }
            if(cnt<=k)
            {
                nums[idx++]=nums[i];

            }
        }  

        return Arrays.copyOf(nums,idx);

    }
}