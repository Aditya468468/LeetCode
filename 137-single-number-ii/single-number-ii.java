class Solution {
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int low=1;
        int high=nums.length-2;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            mid=mid-mid%3;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
            {
                return nums[mid];
            }
            if(nums[mid]==nums[mid+1] && nums[mid+1]==nums[mid+2])
            {
                low=mid+3;
            }
            else
            {
                high=mid;
            }
        }
        return -1;
    }
}