class Solution {

    private boolean canMake(int []nums,int m,int k,long day)
    {
        int total=0;
        int n=nums.length;
        int len=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<=day)
            {
                len++;
            }
            else
            {
                int x=len/k;
                total+=x;
                len=0;
            }
        }
        int x=len/k;
        total+=x;
        if(total>=m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) 
    {
        long low=Integer.MAX_VALUE;
        long high=Integer.MIN_VALUE;
        for(int x: bloomDay)
        {
            if(x<low) low=x;
            if(x>high) high=x;
        }
        int ans=-1;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canMake(bloomDay,m,k,mid))
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