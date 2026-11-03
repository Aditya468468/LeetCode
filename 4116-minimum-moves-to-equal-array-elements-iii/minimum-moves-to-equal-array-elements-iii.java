class Solution {
    public int minMoves(int[] nums) 
    {
      //  Arrays.sort(nums);
        int n=nums.length;

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            count+=(max-nums[i]);
        
        }
        return count;       

    }
}