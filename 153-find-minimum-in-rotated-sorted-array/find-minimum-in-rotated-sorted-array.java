class Solution {
    public int findMin(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return nums[0];
        int min=Integer.MAX_VALUE;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<min) min=nums[mid];
            if(nums[low]==nums[mid] && nums[mid]==nums[high])
            {
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid])
            {
                min=Math.min(min,nums[low]);
                low=mid+1;
            }
            else if(nums[mid]<=nums[high])
            {
                min=Math.min(min,nums[mid]);
                high=mid-1;
            }
        }

        return min;
        
    }
}