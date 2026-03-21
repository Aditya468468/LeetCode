class Solution {
    private boolean isPossible(int[]nums,double hour,long speed)
    {
        double count=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            count+=(nums[i]+speed-1)/speed;
            if(count>hour) return false;
        }
        count+=(double)nums[n-1]/speed;
        return count<=hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) 
    {
        long low=1;
        // long high=Integer.MIN_VALUE;
        // for(int x:dist) if(x>high) high=x;
        long high = (long)1e7;
        int ans=-1;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(dist,hour,mid))
            {
                ans=(int)mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }

        return ans;

        
    }
}