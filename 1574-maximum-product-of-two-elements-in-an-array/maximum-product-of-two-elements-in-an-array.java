class Solution {
    public int maxProduct(int[] nums) 
    {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int smax=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            if(max<nums[i])
            {
                smax=max;
                max=nums[i];
            }
            else if(smax<nums[i])
            {
                smax=nums[i];
            }
        }


        return (max-1)*(smax-1);
        
    }
}