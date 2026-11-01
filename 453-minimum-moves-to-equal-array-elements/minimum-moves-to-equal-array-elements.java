class Solution {
    public int minMoves(int[] nums) 
    {
        //Increasing n-1 values at once== Decreasing 1 value at once.
        //So instead of finding max and try to figure this way,
        //Find minimum and make every element equal to it

        long min=Long.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            min=(long)Math.min(min,nums[i]);
        }

        int moves=0;

        for(int i=0;i<n;i++)
        {
            moves+=(int)(nums[i]-min);
        }

        return moves;

        
        
    }
}