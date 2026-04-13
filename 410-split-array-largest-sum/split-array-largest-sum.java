class Solution {

    private boolean canSplit(int[]nums,int k,long limit)
    {
        int cnt=1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(sum+nums[i]<=limit)
            {
                sum+=nums[i];
            }
            else
            {
                cnt++;
                sum=nums[i];
                if(cnt>k) return false;
            }
        }

        return cnt<=k;
    }
    public int splitArray(int[] nums, int k) 
    {
        long low=Integer.MIN_VALUE;
        long high=0;
        for(int x:nums)
        {
            if(x>low) low=x;
            high+=x;
        }

        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canSplit(nums,k,mid))
            {
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }

        }

        return (int)low;
        
    }
}