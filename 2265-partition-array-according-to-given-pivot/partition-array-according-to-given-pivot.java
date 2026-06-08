class Solution {
    public int[] pivotArray(int[] nums, int pivot) 
    {
      
        int []ans=new int[nums.length];
        int idx=0;
        //smaller
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            {
                ans[idx++]=nums[i];
            }
        }
        //Equal
         for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==pivot)
            {
                ans[idx++]=nums[i];
            }
        }
        //Greater
         for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>pivot)
            {
                ans[idx++]=nums[i];
            }
        }

       
        return ans;
        
    }
}