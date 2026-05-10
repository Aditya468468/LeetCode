class Solution 
{
 
    public int[] concatWithReverse(int[] nums) 
    {
        int n=nums.length;
        int []ans=new int[n+n];
        for(int i=0;i<nums.length;i++)
            {
                ans[i]=nums[i];
                ans[ans.length-1-i]=nums[i];
            }

        return ans;
        
    }
}