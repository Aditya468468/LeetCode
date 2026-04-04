class Solution {
    private int lowerBound(int[]nums,int k)
    {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>=k)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
    private int upperBound(int[]nums, int k)
    {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<=k)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return low;
    }
    public int maximumCount(int[] nums) 
    {
        int n=nums.length;
        int neg=lowerBound(nums,0);
        int pos=n-upperBound(nums,0);
        
        return Math.max(neg,pos);
      


        
    }
}