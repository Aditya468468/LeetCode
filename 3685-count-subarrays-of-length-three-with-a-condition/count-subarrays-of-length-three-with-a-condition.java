class Solution {
    public int countSubarrays(int[] nums) 
    {
        int cnt=0;
        int left=0;
        for(int right=0;right<nums.length;right++)
        {
            while(right-left+1>3)
            {
                left++;
            }
            if(right-left+1==3)
            {
                int m=nums[right-1];
                int l=nums[right];
                int r=nums[left];
                if((2*(l+r))==m)
                {
                    cnt++;
                }
            }

            
        }

        return cnt;
        
    }
}