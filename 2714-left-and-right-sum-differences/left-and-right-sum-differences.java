class Solution {
    public int[] leftRightDifference(int[] nums) 
    {
        int n=nums.length;
        int []result=new int[n];
        int preSum=0;
        int totalSum=0;
        for(int x:nums)
        {
            totalSum+=x;
        }
        for(int i=0;i<n;i++)
        {
            int suffSum=totalSum-nums[i]-preSum;
            result[i]=Math.abs(preSum-suffSum);
            preSum+=nums[i];
        }


        return result;

        
    }
}