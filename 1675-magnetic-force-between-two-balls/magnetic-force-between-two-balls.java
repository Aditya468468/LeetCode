class Solution {
    public boolean canKeep(int[]nums,int k,long d)
    {
        int count=1;
        int prev=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int distance=nums[i]-prev;
            if(distance>=d)
            {
                count++;
                prev=nums[i];
            }
            if(count>=k) return true;
        }

        return false;
    }
    public int maxDistance(int[] nums, int k) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        long low=1;
        long high=nums[n-1]-nums[0];
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canKeep(nums,k,mid))
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return (int)high;
   
    }
}
