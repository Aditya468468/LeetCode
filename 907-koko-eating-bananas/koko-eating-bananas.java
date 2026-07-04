class Solution 
{
    private boolean canEat(int[]nums,long mid,int h)
    {
        long hrs=0;
        for(int i=0;i<nums.length;i++)
        {
            hrs+=(nums[i]+mid-1)/mid;
            if(hrs>h) return false;
        }

        return true;

    }
    public int minEatingSpeed(int[] piles, int h) 
    {
        long low=1;
        int max=0;
        for(int x:piles)
        {
            if(x>max) max=x;
        }
        long high=max;

        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canEat(piles,mid,h))
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