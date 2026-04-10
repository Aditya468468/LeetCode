class Solution {

    private int xorSet(int idx,int sum,int[]nums)
    {
        if(idx==nums.length)
        {
            return sum;
        }
        //take it.
        int take=xorSet(idx+1,sum^nums[idx],nums);
        //Not take it 
        int notTake=xorSet(idx+1,sum,nums);
        return take+notTake;
    }
    public int subsetXORSum(int[] nums) 
    {
        
        return xorSet(0,0,nums);
    }
}