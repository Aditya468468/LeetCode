class Solution {
    private int countPairs(int []nums,long k)
    {
        int n=nums.length;
        int cnt=0;
        int left=0;
        for(int right=0;right<n;right++)
        {
    
            while(nums[right]-nums[left]>k && left<n)
            {
                left++;
            }
            cnt+=(right-left);

        }
        return cnt;

    }
    public int smallestDistancePair(int[] nums, int k) 
    {
        int n=nums.length;
        long low=0;
        Arrays.sort(nums);
        long high=nums[n-1]-nums[0];
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            int value=countPairs(nums,mid);
            if(value<k)
            {
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }
        } 

        return (int)low;

        
    }
}