class Solution {
    public long maxTotalValue(int[] nums, int k) 
    {
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        for(int x:nums)
        {
            if(max<x) max=x;
            if(min>x) min=x;
        }

        return (max-min)*k;
        
    }
}