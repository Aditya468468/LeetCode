class Solution {
    private boolean isPossible(int[]nums,int days,long wt)
    {
        long d=0;
        long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(sum>wt) return false;
            if(sum+nums[i]<=wt)
            {
                sum+=nums[i];
            }
            else
            {
               d++;
               sum=nums[i];
               if(d>days) return false;

            }

        }
        if(sum>wt) return false;
        if(sum<=wt) d++;
        return d<=days;

    }
    public int shipWithinDays(int[] weights, int days) 
    {
        long low=1;
        long high=0;
        for(int x:weights)
        {
           // low=Math.max(low, x);
            high+=x;
        }
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(weights,days,mid))
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