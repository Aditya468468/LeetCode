class Solution {
    public int minAbsoluteDifference(int[] nums) 
    {
        int min=Integer.MAX_VALUE;
        int prev1=-1;
        int prev2=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                if(prev2!=-1)
                {
                    min=Math.min(min,Math.abs(prev2-i));
                }
                prev1=i;
            }
            else if(nums[i]==2)
            {
                if(prev1!=-1)
                {
                    min=Math.min(min,Math.abs(prev1-i));
                }
                prev2=i;
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
       
       


    }
}