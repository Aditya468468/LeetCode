class Solution {
    public int countDominantElements(int[] nums) 
    {
        int dominant=0;
        if(nums.length==1) return 1;

        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                if(nums[i]>=nums[i+1])
                {
                    dominant++;
                }
            }
            else if(i==nums.length-1)
            {
                if(nums[i]>=nums[i-1])
                {
                    dominant++;
                }
            }
            else 
            {
                double avg=(nums[i-1]+nums[i+1])/2.0;
                if(nums[i]>=avg)
                    {
                        dominant++;
                    }

            }
        }

        return dominant;
        
        
    }
}