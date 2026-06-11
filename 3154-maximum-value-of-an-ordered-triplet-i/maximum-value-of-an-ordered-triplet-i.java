class Solution {
    public long maximumTripletValue(int[] nums) 
    {
        //Max-> Multiplication will have more meaning.
        // (x-y)-> x-(Smax-min)-> Will Produce bigger value.
        
        //There should be least 3 elements naa.
        long maxDiff=Long.MIN_VALUE;
        long max=-1;
        long maxAns=0;
        for(int i=0;i<nums.length;i++)
        {
            maxAns=Math.max(maxAns,(1L)*maxDiff*nums[i]);

            maxDiff=Math.max(maxDiff,max-nums[i]);

            max=Math.max(max,nums[i]);

        
        }
        return maxAns;
    }
}