class Solution {
    private boolean isPossible(int[]nums,long k,long cand)
    {
        int n=nums.length;
        long count=0;//Children 
        for(int i=0;i<n;i++)
        {
            long x=nums[i]/cand;
            count+=x;
            if(count>=k) return true;

        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) 
    {
        long low=1;
        long totalSum=0;
        for(int x:candies) totalSum+=x;
        long high=(long)(totalSum/k);
        if(totalSum<k) return 0;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(isPossible(candies,k,mid))
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