class Solution {
    public int upperBound(int[]nums,int target)
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
        return low;
    }
    public int searchInsert(int[] nums, int target) 
    {
           int idx=upperBound(nums,target);
           if(idx-1>=0 && nums[idx-1]==target) return idx-1;
           return idx;

      
    }
}
