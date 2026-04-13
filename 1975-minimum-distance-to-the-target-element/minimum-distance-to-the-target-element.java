class Solution {
    public int getMinDistance(int[] nums, int target, int start) 
    {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        // start to n-1.
        for(int i=start;i<n;i++)
        {
            if(nums[i]==target)
            {
                int val=(i-start);
                if(val<min) min=val;
            }
        }
        // 0 to start-1.
        for(int i=0;i<start;i++)
        {
              if(nums[i]==target)
            {
                int val=(start-i);
                if(val<min) min=val;
            }

        }
        
        return min;
    }
}