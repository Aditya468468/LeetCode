class Solution {
    public int lowerBound(int []nums,int x)
    {
        int low=0;
        int high=nums.length-1;
        int ans=nums.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>=x)
            {
                ans=mid;
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public int upperBound(int[]nums,int x)
    {
        int low=0;
        int high=nums.length-1;
        int ans=nums.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>x)
            {
                ans=mid;
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
        return ans;

    }
    public int[] searchRange(int[] nums, int target) 
    {
        int first=-1;
        int idx1=lowerBound(nums,target);
        if(idx1<nums.length && nums[idx1]==target) first=idx1;
        int last=-1;
        int idx2=upperBound(nums,target);
        if(first!=-1)
            last=idx2-1;
        else
            last=-1;
        return new int[]{first,last};

    
    }
}