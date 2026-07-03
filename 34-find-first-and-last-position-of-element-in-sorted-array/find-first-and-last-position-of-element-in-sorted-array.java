class Solution 
{
    private int firstIdx(int[]nums,int target)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<target)
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
    private int lastIdx(int[]nums,int target)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<=target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return high;
        
    }
    public int[] searchRange(int[] nums, int target) 
    {
        int first=firstIdx(nums,target);
        if(first==nums.length || nums[first]!=target) return new int[]{-1,-1};
        int last=lastIdx(nums,target);
        return new int[]{first,last};        
    }
}