class Solution {
    private boolean canMake(int []nums,int totalTrips,long t)
    {
        long count=0;
        for(int i=0;i<nums.length;i++)
        {
            long x=(long)(t/nums[i]);
            count+=x;
            if(count>=totalTrips) return true;
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) 
    {
        long low=1;
        int min=Integer.MAX_VALUE;
        for(int x:time) if(x<min) min=x;
        long high=(long)min*totalTrips;
        while(low<=high)
        {
            long mid=low+(high-low)/2; 
            if(canMake(time,totalTrips,mid))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }

        return low;
        
    }
}