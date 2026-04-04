class Solution {
    public int findMin(int[] nums) 
    {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int min=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<min) min=nums[mid];
            if(nums[mid]==nums[low] && nums[mid]==nums[high])
            {
                low++;
                high--;
                continue; 
            }
            if(nums[low]<=nums[mid])
            {
                if(min>nums[low]) min=nums[low];
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }
        }

        return min;
        
    }
}